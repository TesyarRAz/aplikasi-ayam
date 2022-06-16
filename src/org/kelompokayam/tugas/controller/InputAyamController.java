/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.kelompokayam.tugas.controller;

import java.time.LocalDate;
import java.util.function.Predicate;
import org.kelompokayam.tugas.datasource.FileListStorage;
import org.kelompokayam.tugas.model.StatusAyam;
import org.kelompokayam.tugas.model.User;
import org.kelompokayam.tugas.util.FileUtil;

/**
 *
 * @author raz
 */
public class InputAyamController {
    private final FileListStorage<StatusAyam> fileStorage = new FileListStorage<>();

    public InputAyamController() {
        fileStorage.setFile(FileUtil.getFileByCurrentDir("ayam.dat"));
    }
    
    public boolean simpan(LocalDate date, int sehat, int sakit, int mati) throws Exception {
        StatusAyam statusAyam = new StatusAyam();
        statusAyam.setTanggal(date);
        statusAyam.setTotalSehat(sehat);
        statusAyam.setTotalSakit(sakit);
        statusAyam.setTotalMati(mati);
        
        Predicate<StatusAyam> filter = (status) -> status.getTanggal().isEqual(date);
        
        if (fileStorage.find(filter) != null) {
            return fileStorage.update(statusAyam, filter);
        }
        
        return fileStorage.add(statusAyam);
    }
    
    public StatusAyam cari(LocalDate date) throws Exception {
        return fileStorage.find(status -> status.getTanggal().isEqual(date));
    }
}
