/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.kelompokayam.tugas.datasource;

/**
 *
 * @author raz
 */
public interface Storage<T> {
    public boolean write(T data) throws Exception;
    public T read() throws Exception;
}
