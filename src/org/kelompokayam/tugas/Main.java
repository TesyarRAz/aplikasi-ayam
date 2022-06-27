/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package org.kelompokayam.tugas;

import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import org.kelompokayam.tugas.controller.ChangePasswordController;
import org.kelompokayam.tugas.controller.DashboardController;
import org.kelompokayam.tugas.controller.InputAyamController;
import org.kelompokayam.tugas.controller.KelolaKaryawanController;
import org.kelompokayam.tugas.controller.LaporanAyamController;
import org.kelompokayam.tugas.controller.LoginController;
import org.kelompokayam.tugas.seeder.UserSeeder;
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
        
        String[] recommendedLookAndFeel = new String[] {"Windows", "Nimbus"};
        
        // Set Look And Feel
        for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
            for (String lookAndFeel : recommendedLookAndFeel) {
                if (lookAndFeel.equalsIgnoreCase(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        }
        
        // Dependency Injection
        Injection.Put(new UserSeeder()).call();
        
        Injection.Put(new LoginController());
        Injection.LazyPut(KelolaKaryawanController.class, () -> new KelolaKaryawanController());
        Injection.LazyPut(InputAyamController.class, () -> new InputAyamController());
        Injection.LazyPut(LaporanAyamController.class, () -> new LaporanAyamController());
        Injection.Put(new ChangePasswordController());
        Injection.Put(new DashboardController());
        
        // Show Splash View Saat Pertama Kali Dijalankan
        new SplashView().setVisible(true);
    }
    
}
