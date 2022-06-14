/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.kelompokayam.tugas.seeder;

import java.io.File;
import java.util.List;
import org.kelompokayam.tugas.datasource.FileData;
import org.kelompokayam.tugas.datasource.FileListStorage;

/**
 *
 * @author raz
 */
public abstract class Seeder<T> {
    private final FileListStorage<T> fileStorage = new FileListStorage<>();
    
    public boolean call() throws Exception {
        fileStorage.setFile(getFile());
        fileStorage.setWriteSeeder(() -> new FileData<>(createSeeder()));
        
        return fileStorage.initiate();
    }
    
    public abstract File getFile();
    public abstract List<T> createSeeder();

    public FileListStorage<T> getFileStorage() {
        return fileStorage;
    }
}
