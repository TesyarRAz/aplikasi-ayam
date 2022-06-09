/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.kelompokayam.tugas.datasource;

import java.util.List;

/**
 *
 * @author raz
 * @param <T>
 */
public class FileListStorage<T> extends FileStorage<List<T>> {
    public boolean add(T data) throws Exception {
        FileData<List<T>> fileData = read();
        
        fileData.getData().add(data);
        
        return write(fileData);
    }
    
    public boolean remove(T data) throws Exception {
        FileData<List<T>> fileData = read();
        
        fileData.getData().remove(data);
        
        return write(fileData);
    }
}
