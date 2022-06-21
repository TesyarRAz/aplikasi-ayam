/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.kelompokayam.tugas.controller;

import java.util.AbstractMap;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import org.kelompokayam.tugas.datasource.FileListStorage;
import org.kelompokayam.tugas.model.Karyawan;
import org.kelompokayam.tugas.model.User;
import org.kelompokayam.tugas.util.FileUtil;

/**
 *
 * @author raz
 */
public class DashboardController {
    private final FileListStorage<User> fileStorage = new FileListStorage<>();

    public DashboardController() {
        fileStorage.setFile(FileUtil.getFileByCurrentDir(User.FILE_NAME));
    }
    
    public Map<String, List<Karyawan>> getKaryawansByJadwal() throws Exception {
        List<Karyawan> karyawans = fileStorage.read().getData()
                .stream()
                .filter(model -> !model.getRole().equalsIgnoreCase("admin"))
                .map(e -> (Karyawan) e)
                .collect(Collectors.toList());
        
        List<String> jadwal = Arrays.asList("Senin", "Selasa", "Rabu", "Kamis", "Jumat", "Sabtu", "Minggu");
        
        return jadwal.stream().map(j -> {
            return new AbstractMap.SimpleEntry<>(j, karyawans.stream()
                    .filter(e -> e.getJadwal() != null)
                    .filter(e -> e.getJadwal().containsKey(j))
                    .filter(e -> e.getJadwal().get(j))
                    .collect(Collectors.toList())
            );
        })
        .collect(Collectors.toMap(e -> e.getKey(), e -> e.getValue()));
    }
}
