/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.kelompokayam.tugas.datasource;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

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
    
    public boolean update(T data, Predicate<T> filter) throws Exception {
        FileData<List<T>> fileData = read();
        
        fileData.getData().replaceAll((t) -> {
            if (filter.test(t)) {
                return data;
            }
            
            return t;
        });
        
        return write(fileData);
    }
    
    public boolean remove(T data) throws Exception {
        FileData<List<T>> fileData = read();
        
        fileData.getData().remove(data);
        
        return write(fileData);
    }
    
    public boolean remove(int index) throws Exception {
        FileData<List<T>> fileData = read();
        
        fileData.getData().remove(index);
        
        return write(fileData);
    }
    
    public boolean removeIf(Predicate<T> filter) throws Exception {
        FileData<List<T>> fileData = read();
        
        fileData.getData().removeIf(filter);
        
        return write(fileData);
    }
    
    public T find(Predicate<T> filter) throws Exception {
        return read().getData().stream().filter(filter).findFirst().orElse(null);
    }

    @Override
    public FileData<List<T>> read() throws Exception {
        FileData<List<T>> data = super.read();
        
        if (data.getData() == null) {
            data.setData(new ArrayList<>());
        }
        
        return data;
    }
}
