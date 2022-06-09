/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.kelompokayam.tugas.datasource;

import java.io.Serializable;

/**
 *
 * @author raz
 * @param <T>
 */
public class FileData<T> {
    private T data;

    public FileData(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
    
    public Object serialize() {
        return data;
    }
    
    public static <T> FileData<T> Deserialize(T data) {
        return new FileData<>(data);
    }
    
    public static <T> FileData<T> Empty() {
        return new FileData<>(null);
    }
}
