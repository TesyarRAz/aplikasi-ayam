/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.kelompokayam.tugas.controller;

import org.kelompokayam.tugas.Injection;
import org.kelompokayam.tugas.datasource.FileListStorage;
import org.kelompokayam.tugas.model.Auth;
import org.kelompokayam.tugas.model.User;
import org.kelompokayam.tugas.util.CryptUtil;
import org.kelompokayam.tugas.util.FileUtil;

/**
 *
 * @author raz
 */
public class ChangePasswordController {
    private final FileListStorage<User> fileStorage = new FileListStorage<>();

    public ChangePasswordController() {
        fileStorage.setFile(FileUtil.getFileByCurrentDir(User.FILE_NAME));
    }

    public FileListStorage<User> getFileStorage() {
        return fileStorage;
    }
    
    public boolean comparePassword(String passwordLama) throws Exception {
        User user = Injection.Get(Auth.class).getUser();
        
        return user.getPassword().equals(CryptUtil.DefaultHash(passwordLama));
    }
    
    public boolean changePassword(String newPassword) throws Exception {
        User user = Injection.Get(Auth.class).getUser();
        
        user.setPassword(CryptUtil.DefaultHash(newPassword));
        
        return fileStorage.update(user, e -> e.getUsername().equalsIgnoreCase(user.getUsername()));
    }
}
