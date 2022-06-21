/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.kelompokayam.tugas.model;

import java.io.Serializable;
import java.util.Map;
import java.util.stream.Collectors;

/**
 *
 * @author raz
 */
public class Karyawan extends User implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private Map<String, Boolean> jadwal;
    private String keterangan;

    public Karyawan() {
        setRole("karyawan");
    }

    public Map<String, Boolean> getJadwal() {
        return jadwal;
    }

    public void setJadwal(Map<String, Boolean> jadwal) {
        this.jadwal = jadwal;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }
    
    @Override
    public Map<String, Object> toTableModel() {
        Map<String, Object> map = super.toTableModel();
        
        map.put("Jadwal", getJadwal().entrySet().stream()
                .filter(e -> e.getValue())
                .map(e -> e.getKey())
                .collect(Collectors.joining(","))
        );
        
        map.put("_tooltip", getKeterangan());
        
        return map;
    }
}
