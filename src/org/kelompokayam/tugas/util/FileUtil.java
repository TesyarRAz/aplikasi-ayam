/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.kelompokayam.tugas.util;

import java.io.File;

/**
 *
 * @author raz
 */
public class FileUtil {
    public static File getFileByCurrentDir(String fileName) {
        return new File(new File(".").getAbsolutePath(), fileName);
    }
}
