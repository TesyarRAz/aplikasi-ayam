/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.kelompokayam.tugas.controller;

import java.time.LocalDate;
import java.util.Arrays;
import org.kelompokayam.tugas.datasource.FileListStorage;
import org.kelompokayam.tugas.model.StatusAyam;
import org.kelompokayam.tugas.util.FileUtil;
import org.kelompokayam.tugas.util.TableTool;

/**
 *
 * @author raz
 */
public class LaporanAyamController {
    private final FileListStorage<StatusAyam> fileStorage = new FileListStorage<>();
    private final TableTool<StatusAyam> tableTool = new TableTool<>();
    
    // date filter
    private LocalDate filterFrom;
    private LocalDate filterTo;

    public LaporanAyamController() {
        fileStorage.setFile(FileUtil.getFileByCurrentDir(StatusAyam.FILE_NAME));
        
        tableTool.setHeaders(Arrays.asList("Tanggal", "Total Sehat", "Total Sakit", "Total Mati", "Total Baru"));
        tableTool.addFilter((model) -> {
            if (filterFrom != null && filterTo != null) {
                return model.getTanggal().isAfter(filterFrom) && model.getTanggal().isBefore(filterTo);
            }
            
            return true;
        });
        tableTool.setFileStorage(fileStorage);
    }

    public FileListStorage<StatusAyam> getFileStorage() {
        return fileStorage;
    }

    public TableTool<StatusAyam> getTableTool() {
        return tableTool;
    }

    public LocalDate getFilterFrom() {
        return filterFrom;
    }

    public void setFilterFrom(LocalDate filterFrom) {
        this.filterFrom = filterFrom;
    }

    public LocalDate getFilterTo() {
        return filterTo;
    }

    public void setFilterTo(LocalDate filterTo) {
        this.filterTo = filterTo;
    }
    
    public void reset() {
        filterFrom = null;
        filterTo = null;
        tableTool.setAfterLoads(null);
    }
}
