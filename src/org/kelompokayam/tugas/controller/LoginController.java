/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.kelompokayam.tugas.controller;

import java.util.List;
import org.kelompokayam.tugas.Injection;
import org.kelompokayam.tugas.datasource.FileListStorage;
import org.kelompokayam.tugas.model.Auth;
import org.kelompokayam.tugas.model.User;
import org.kelompokayam.tugas.seeder.UserSeeder;
import org.kelompokayam.tugas.util.CryptUtil;
import org.kelompokayam.tugas.util.FileUtil;

/**
 *
 * @author raz
 */
public class LoginController {
    private final FileListStorage<User> fileStorage = new FileListStorage<>();

    public LoginController() {
        fileStorage.setFile(FileUtil.getFileByCurrentDir("auth.dat"));
    }
    
    public boolean login(String username, String password) throws Exception {
        List<User> users = fileStorage.read().getData();
        
        if (users == null) return false;
        
        User loggedInUser = users.stream()
                .filter(user -> user.getUsername().equalsIgnoreCase(username))
                .filter(user -> {
                    try {
                        return user.getPassword().equalsIgnoreCase(CryptUtil.DefaultHash(password));
                    } catch (Exception ex) {
                        ex.printStackTrace(System.err);
                        return false;
                    }
                })
                .findFirst()
                .orElse(null);
        
        if (loggedInUser != null) {
            Auth auth = new Auth();
            auth.setUser(loggedInUser);

            Injection.Put(auth);

            return true;
        }
        
        return false;
    }
    
    public boolean resetAll() throws Exception {
        return fileStorage.getFile().delete() && Injection.Get(UserSeeder.class).call();
    }
}
