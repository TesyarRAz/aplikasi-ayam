/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.kelompokayam.tugas.model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author raz
 */
public class Karyawan extends User implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private String jadwal;

    public Karyawan() {
        setRole("karyawan");
    }

    public String getJadwal() {
        return jadwal;
    }

    public void setJadwal(String jadwal) {
        this.jadwal = jadwal;
    }

    @Override
    public Map<String, Object> toTableModel() {
        Map<String, Object> map = super.toTableModel();
        
        map.put("Jadwal", getJadwal());
        
        return map;
    }
}
