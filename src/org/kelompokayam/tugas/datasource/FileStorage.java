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
import java.util.function.Supplier;

/**
 *
 * @author raz
 * @param <T>
 */
public class FileStorage<T> implements Storage<FileData<T>> {
    private File file;
    private Supplier<FileData<T>> writeSeeder;

    @Override
    public boolean initiate() throws Exception {
        if (!file.exists() && file.createNewFile()) {
            return write(writeSeeder.get(), false);
        }
        
        return false;
    }

    @Override
    public boolean write(FileData<T> data) throws Exception {
        return write(data, true);
    }
    
    private boolean write(FileData<T> data, boolean withDelete) throws Exception {
        if (!file.exists() && !file.createNewFile()) {
            return false;
        }
        
        if (withDelete) {
            if (file.exists() && !file.delete() && !file.createNewFile()) {
                return false;
            }
        }
        
        try (ObjectOutputStream output = getObjectOutputStream()) {
            output.writeUnshared(data.serialize());
            output.flush();
            
            return true;
        }
    }

    @Override
    public FileData<T> read() throws Exception {
        if (!file.exists()) return FileData.Empty();
        
        try (ObjectInputStream input = getObjectInputStream()) {
            return FileData.Deserialize((T) input.readUnshared());
        }
    }

    public Supplier<FileData<T>> getWriteSeeder() {
        return writeSeeder;
    }

    public void setWriteSeeder(Supplier<FileData<T>> writeSeeder) {
        this.writeSeeder = writeSeeder;
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
