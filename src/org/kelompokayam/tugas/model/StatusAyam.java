/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.kelompokayam.tugas.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import org.kelompokayam.tugas.util.TableToolModel;

/**
 *
 * @author raz
 */
public class StatusAyam implements TableToolModel, Serializable {
    private LocalDate tanggal;
    private int totalSehat;
    private int totalSakit;
    private int totalMati;

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

    @Override
    public Map<String, Object> toTableModel() {
        Map<String, Object> map = new HashMap<>();
        
        return map;
    }
}
