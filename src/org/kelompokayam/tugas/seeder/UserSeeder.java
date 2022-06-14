/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.kelompokayam.tugas.seeder;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
import org.kelompokayam.tugas.datasource.FileData;
import org.kelompokayam.tugas.model.User;
import org.kelompokayam.tugas.util.CryptUtil;
import org.kelompokayam.tugas.util.FileUtil;

/**
 *
 * @author raz
 */
public class UserSeeder extends Seeder<User> {

    @Override
    public File getFile() {
        return FileUtil.getFileByCurrentDir(User.FILE_NAME);
    }
    
    @Override
    public List<User> createSeeder() {
        List<User> users = new ArrayList<>();
        
        try {
            User admin = new User();
            admin.setName("Admin");
            admin.setUsername("admin");
            admin.setPassword(CryptUtil.DefaultHash("admin"));
            admin.setRole("admin");

            users.add(admin);
        } catch (Exception ex) {
            ex.printStackTrace(System.err);
        }
        
        return users;
    }
}
