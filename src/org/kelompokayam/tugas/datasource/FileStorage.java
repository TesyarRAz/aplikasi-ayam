/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.kelompokayam.tugas.datasource;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author raz
 * @param <T>
 */
public class FileStorage<T> implements Storage<FileData<T>> {
    private File file;

    @Override
    public boolean write(FileData<T> data) throws Exception {
        if (!(file.exists() && file.createNewFile()) || !(file.exists() && file.delete() && file.createNewFile())) {
            return false;
        }
        
        try (ObjectOutputStream output = getObjectOutputStream()) {
            output.writeObject(data.serialize());
        }
        
        return false;
    }

    @Override
    public FileData<T> read() throws Exception {
        if (!file.exists()) return FileData.Empty();
        
        try (ObjectInputStream input = getObjectInputStream()) {
            return FileData.Deserialize((T) input.readObject());
        }
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }
    
    private ObjectInputStream getObjectInputStream() throws Exception {
        return new ObjectInputStream(new FileInputStream(file));
    }
    
    private ObjectOutputStream getObjectOutputStream() throws Exception {
        return new ObjectOutputStream(new FileOutputStream(file));
    }
}
