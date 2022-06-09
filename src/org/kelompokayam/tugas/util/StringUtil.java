/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.kelompokayam.tugas.util;

/**
 *
 * @author raz
 */
public class StringUtil {
    public static String Repeat(String str, int count) {
        String result = "";
        for (int i=0; i<count; ++i) {
            result += str;
        }
        
        return result;
    }
}
