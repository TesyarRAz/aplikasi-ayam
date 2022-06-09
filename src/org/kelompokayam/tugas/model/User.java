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
    private String name;
    private String username;
    private String password;

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

    @Override
    public Map<String, Object> toTableModel() {
        Map<String, Object> map = new HashMap<>();
        
        return map;
    }
}
