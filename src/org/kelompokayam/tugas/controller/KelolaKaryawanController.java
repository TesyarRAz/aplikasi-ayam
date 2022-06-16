/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.kelompokayam.tugas.controller;

import java.util.Arrays;
import org.kelompokayam.tugas.datasource.FileListStorage;
import org.kelompokayam.tugas.model.Karyawan;
import org.kelompokayam.tugas.model.User;
import org.kelompokayam.tugas.util.CryptUtil;
import org.kelompokayam.tugas.util.FileUtil;
import org.kelompokayam.tugas.util.TableTool;

/**
 *
 * @author raz
 */
public class KelolaKaryawanController {
    private final FileListStorage<User> fileStorage = new FileListStorage<>();
    private final TableTool<User> tableTool = new TableTool<>();

    public KelolaKaryawanController() {
        fileStorage.setFile(FileUtil.getFileByCurrentDir(User.FILE_NAME));
        
        tableTool.setHeaders(Arrays.asList("Nama", "Username", "Jadwal"));
        tableTool.addFilter((model) -> {
            return !model.getRole().equalsIgnoreCase("admin");
        });
        
        tableTool.setFileStorage(fileStorage);
    }

    public FileListStorage<User> getFileStorage() {
        return fileStorage;
    }

    public TableTool<User> getTableTool() {
        return tableTool;
    }
    
    public boolean isExistsUsername(String username) throws Exception {
        return fileStorage.find(user -> user.getUsername().equalsIgnoreCase(username)) != null;
    }
    
    public boolean tambah(String nama, String username, String password, String jadwal) throws Exception {
        Karyawan karyawan = new Karyawan();
        karyawan.setName(nama);
        karyawan.setUsername(username);
        karyawan.setPassword(CryptUtil.DefaultHash(password));
        karyawan.setJadwal(jadwal);
        
        return fileStorage.add(karyawan);
    }
    
    public boolean hapus(int index) throws Exception {
        return fileStorage.remove(index);
    }
}
