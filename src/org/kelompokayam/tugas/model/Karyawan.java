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

    public Karyawan() {
        setRole("karyawan");
    }
}
