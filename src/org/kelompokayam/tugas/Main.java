/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package org.kelompokayam.tugas;

import java.util.Arrays;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import org.kelompokayam.tugas.controller.HomeController;
import org.kelompokayam.tugas.controller.LoginController;
import org.kelompokayam.tugas.seeder.UserSeeder;
import org.kelompokayam.tugas.view.HomeView;
import org.kelompokayam.tugas.view.KelolaKaryawanView;
import org.kelompokayam.tugas.view.SplashView;

/**
 *
 * @author raz
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        
        String[] recommendedLookAndFeel = new String[] {"Windows", "GTK+"};
        
        for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
            if (Arrays.binarySearch(recommendedLookAndFeel, info.getName()) != -1) {
                UIManager.setLookAndFeel(info.getClassName());
                break;
            }
        }
        
        Injection.Put(new UserSeeder()).call();
        
        Injection.Put(new LoginController());
        Injection.Put(new HomeController());
        Injection.LazyPut(KelolaKaryawanView.class, () -> new KelolaKaryawanView());
        
        new SplashView().setVisible(true);
    }
    
}
