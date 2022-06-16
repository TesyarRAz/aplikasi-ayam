/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.kelompokayam.tugas.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import org.kelompokayam.tugas.util.TableToolModel;

/**
 *
 * @author raz
 */
public class StatusAyam implements TableToolModel, Serializable {
    private static final long serialVersionUID = 1L;
    
    public static final String FILE_NAME = "ayam.dat";
    
    private LocalDate tanggal;
    private int totalSehat;
    private int totalSakit;
    private int totalMati;
    private int totalBaru;

    public LocalDate getTanggal() {
        return tanggal;
    }

    public void setTanggal(LocalDate tanggal) {
        this.tanggal = tanggal;
    }

    public int getTotalSehat() {
        return totalSehat;
    }

    public void setTotalSehat(int totalSehat) {
        this.totalSehat = totalSehat;
    }

    public int getTotalSakit() {
        return totalSakit;
    }

    public void setTotalSakit(int totalSakit) {
        this.totalSakit = totalSakit;
    }

    public int getTotalMati() {
        return totalMati;
    }

    public void setTotalMati(int totalMati) {
        this.totalMati = totalMati;
    }

    public int getTotalBaru() {
        return totalBaru;
    }

    public void setTotalBaru(int totalBaru) {
        this.totalBaru = totalBaru;
    }

    @Override
    public Map<String, Object> toTableModel() {
        Map<String, Object> map = new LinkedHashMap<>();
        
        map.put("Tanggal", getTanggal().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")));
        map.put("Total Sehat", getTotalSehat());
        map.put("Total Sakit", getTotalSakit());
        map.put("Total Mati", getTotalMati());
        map.put("Total Baru", getTotalBaru());
        
        return map;
    }
}
