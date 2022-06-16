/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.kelompokayam.tugas.model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import org.kelompokayam.tugas.util.TableToolModel;

/**
 *
 * @author raz
 */
public class User implements TableToolModel, Serializable {
    private static final long serialVersionUID = 1L;
    
    public static String FILE_NAME = "auth.dat";
    
    private String name;
    private String username;
    private String password;
    private String role;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }    

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public Map<String, Object> toTableModel() {
        Map<String, Object> map = new HashMap<>();
        
        map.put("Nama", getName());
        map.put("Username", getUsername());
        
        return map;
    }
}
