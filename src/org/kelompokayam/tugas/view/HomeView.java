/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package org.kelompokayam.tugas.view;

import java.awt.CardLayout;
import java.awt.Color;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import org.kelompokayam.tugas.Injection;
import org.kelompokayam.tugas.model.User;
import org.kelompokayam.tugas.controller.HomeController;
import org.kelompokayam.tugas.controller.LoginController;
import org.kelompokayam.tugas.model.Auth;

/**
 *
 * @author raz
 */
public class HomeView extends javax.swing.JFrame {
    private Auth auth = Injection.Get(Auth.class);
    private HomeController controller = Injection.Get(HomeController.class);
    private Map<JPanel, JLabel> sideButtons = new HashMap<>();

    /**
     * Creates new form HomeView
     */
    public HomeView() {
        initComponents();
        
        sideButtons.put(btnKelolaKaryawan, lblKelolaKaryawan);
        sideButtons.put(btnInputAyam, lblInputAyam);
        sideButtons.put(btnLaporanAyam, lblLaporanAyam);
        sideButtons.put(btnLogout, lblLogout);
        
        setLocationRelativeTo(null);
        
        if (auth != null) {
            lblProfile.setText("Halo, " + auth.getUser().getName());
            
            if (auth.getUser().getRole().equalsIgnoreCase("admin")) {
                triggerSideButtons(btnKelolaKaryawan);
                changePage("kelola-karyawan");
            } else {
                sidebarList.remove(btnKelolaKaryawan.getParent());
                triggerSideButtons(btnInputAyam);
                changePage("input-ayam");
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jPanel4 = new javax.swing.JPanel();
        lblProfile = new javax.swing.JLabel();
        sidebarList = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        btnKelolaKaryawan = new javax.swing.JPanel();
        lblKelolaKaryawan = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        btnInputAyam = new javax.swing.JPanel();
        lblInputAyam = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        btnLaporanAyam = new javax.swing.JPanel();
        lblLaporanAyam = new javax.swing.JLabel();
        btnLogout = new javax.swing.JPanel();
        lblLogout = new javax.swing.JLabel();
        container = new javax.swing.JPanel();
        kelolaKaryawanView1 = new org.kelompokayam.tugas.view.KelolaKaryawanView();
        inputAyamView2 = new org.kelompokayam.tugas.view.InputAyamView();
        laporanAyamView1 = new org.kelompokayam.tugas.view.LaporanAyamView();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Aplikasi Peternakan Ayam");

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(82, 79, 218));

        jPanel1.setBackground(new java.awt.Color(82, 79, 218));

        jLabel1.setFont(new java.awt.Font("Ubuntu", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Peternakan Ayam");

        jLabel2.setFont(new java.awt.Font("Ubuntu", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Aplikasi");

        jSeparator1.setForeground(new java.awt.Color(255, 255, 255));

        jSeparator2.setForeground(new java.awt.Color(255, 255, 255));

        jPanel4.setBackground(new java.awt.Color(82, 79, 218));

        lblProfile.setFont(new java.awt.Font("Ubuntu", 1, 17)); // NOI18N
        lblProfile.setForeground(new java.awt.Color(255, 255, 255));
        lblProfile.setText("Halo, User");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblProfile, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblProfile)
                .addContainerGap())
        );

        sidebarList.setBackground(new java.awt.Color(82, 79, 218));
        sidebarList.setLayout(new javax.swing.BoxLayout(sidebarList, javax.swing.BoxLayout.Y_AXIS));

        jPanel5.setBackground(new java.awt.Color(82, 79, 218));

        btnKelolaKaryawan.setBackground(new java.awt.Color(82, 79, 218));
        btnKelolaKaryawan.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 2, true));
        btnKelolaKaryawan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnKelolaKaryawanMouseClicked(evt);
            }
        });

        lblKelolaKaryawan.setFont(new java.awt.Font("Ubuntu", 1, 24)); // NOI18N
        lblKelolaKaryawan.setForeground(new java.awt.Color(255, 255, 255));
        lblKelolaKaryawan.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblKelolaKaryawan.setText("Kelola Karyawan");

        javax.swing.GroupLayout btnKelolaKaryawanLayout = new javax.swing.GroupLayout(btnKelolaKaryawan);
        btnKelolaKaryawan.setLayout(btnKelolaKaryawanLayout);
        btnKelolaKaryawanLayout.setHorizontalGroup(
            btnKelolaKaryawanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblKelolaKaryawan, javax.swing.GroupLayout.DEFAULT_SIZE, 309, Short.MAX_VALUE)
        );
        btnKelolaKaryawanLayout.setVerticalGroup(
            btnKelolaKaryawanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblKelolaKaryawan, javax.swing.GroupLayout.DEFAULT_SIZE, 68, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnKelolaKaryawan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnKelolaKaryawan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        sidebarList.add(jPanel5);

        jPanel7.setBackground(new java.awt.Color(82, 79, 218));

        btnInputAyam.setBackground(new java.awt.Color(82, 79, 218));
        btnInputAyam.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 2, true));
        btnInputAyam.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnInputAyamMouseClicked(evt);
            }
        });

        lblInputAyam.setFont(new java.awt.Font("Ubuntu", 1, 24)); // NOI18N
        lblInputAyam.setForeground(new java.awt.Color(255, 255, 255));
        lblInputAyam.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblInputAyam.setText("Input Ayam");

        javax.swing.GroupLayout btnInputAyamLayout = new javax.swing.GroupLayout(btnInputAyam);
        btnInputAyam.setLayout(btnInputAyamLayout);
        btnInputAyamLayout.setHorizontalGroup(
            btnInputAyamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblInputAyam, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        btnInputAyamLayout.setVerticalGroup(
            btnInputAyamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblInputAyam, javax.swing.GroupLayout.DEFAULT_SIZE, 74, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnInputAyam, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnInputAyam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        sidebarList.add(jPanel7);

        jPanel6.setBackground(new java.awt.Color(82, 79, 218));

        btnLaporanAyam.setBackground(new java.awt.Color(82, 79, 218));
        btnLaporanAyam.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 2, true));
        btnLaporanAyam.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnLaporanAyamMouseClicked(evt);
            }
        });

        lblLaporanAyam.setFont(new java.awt.Font("Ubuntu", 1, 24)); // NOI18N
        lblLaporanAyam.setForeground(new java.awt.Color(255, 255, 255));
        lblLaporanAyam.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblLaporanAyam.setText("Laporan Ayam");

        javax.swing.GroupLayout btnLaporanAyamLayout = new javax.swing.GroupLayout(btnLaporanAyam);
        btnLaporanAyam.setLayout(btnLaporanAyamLayout);
        btnLaporanAyamLayout.setHorizontalGroup(
            btnLaporanAyamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblLaporanAyam, javax.swing.GroupLayout.DEFAULT_SIZE, 309, Short.MAX_VALUE)
        );
        btnLaporanAyamLayout.setVerticalGroup(
            btnLaporanAyamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblLaporanAyam, javax.swing.GroupLayout.DEFAULT_SIZE, 74, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnLaporanAyam, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnLaporanAyam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        sidebarList.add(jPanel6);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(sidebarList, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(sidebarList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        btnLogout.setBackground(new java.awt.Color(82, 79, 218));
        btnLogout.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 2, true));
        btnLogout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnLogoutMouseClicked(evt);
            }
        });

        lblLogout.setFont(new java.awt.Font("Ubuntu", 1, 24)); // NOI18N
        lblLogout.setForeground(new java.awt.Color(255, 255, 255));
        lblLogout.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblLogout.setText("Logout");

        javax.swing.GroupLayout btnLogoutLayout = new javax.swing.GroupLayout(btnLogout);
        btnLogout.setLayout(btnLogoutLayout);
        btnLogoutLayout.setHorizontalGroup(
            btnLogoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblLogout, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        btnLogoutLayout.setVerticalGroup(
            btnLogoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnLogoutLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lblLogout, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnLogout, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnLogout, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        container.setLayout(new java.awt.CardLayout());
        container.add(kelolaKaryawanView1, "kelola-karyawan");
        container.add(inputAyamView2, "input-ayam");

        javax.swing.GroupLayout laporanAyamView1Layout = new javax.swing.GroupLayout(laporanAyamView1);
        laporanAyamView1.setLayout(laporanAyamView1Layout);
        laporanAyamView1Layout.setHorizontalGroup(
            laporanAyamView1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 932, Short.MAX_VALUE)
        );
        laporanAyamView1Layout.setVerticalGroup(
            laporanAyamView1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 663, Short.MAX_VALUE)
        );

        container.add(laporanAyamView1, "laporan-ayam");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(container, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(container, javax.swing.GroupLayout.DEFAULT_SIZE, 663, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnKelolaKaryawanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnKelolaKaryawanMouseClicked
        triggerSideButtons(btnKelolaKaryawan);
        
        changePage("kelola-karyawan");
    }//GEN-LAST:event_btnKelolaKaryawanMouseClicked

    private void btnInputAyamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnInputAyamMouseClicked
        triggerSideButtons(btnInputAyam);
        
        changePage("input-ayam");
    }//GEN-LAST:event_btnInputAyamMouseClicked

    private void btnLaporanAyamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLaporanAyamMouseClicked
        triggerSideButtons(btnLaporanAyam);
        
        changePage("laporan-ayam");
    }//GEN-LAST:event_btnLaporanAyamMouseClicked

    private void btnLogoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLogoutMouseClicked
        dispose();
        
        triggerSideButtons(btnLogout);
        
        new LoginView().setVisible(true);
    }//GEN-LAST:event_btnLogoutMouseClicked

    private void triggerSideButtons(JPanel panel) {
        sideButtons.forEach((key, value) -> {
            if (key == panel) {
                key.setBackground(new Color(255, 255, 255));
                value.setForeground(new Color(82,79,218));
            } else {
                key.setBackground(new Color(82,79,218));
                value.setForeground(new Color(255, 255, 255));
            }
        });
    }
    
    private void changePage(String name) {
        CardLayout layout = (CardLayout) container.getLayout();
        
        layout.show(container, name);
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel btnInputAyam;
    private javax.swing.JPanel btnKelolaKaryawan;
    private javax.swing.JPanel btnLaporanAyam;
    private javax.swing.JPanel btnLogout;
    private javax.swing.JPanel container;
    private org.kelompokayam.tugas.view.InputAyamView inputAyamView2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private org.kelompokayam.tugas.view.KelolaKaryawanView kelolaKaryawanView1;
    private org.kelompokayam.tugas.view.LaporanAyamView laporanAyamView1;
    private javax.swing.JLabel lblInputAyam;
    private javax.swing.JLabel lblKelolaKaryawan;
    private javax.swing.JLabel lblLaporanAyam;
    private javax.swing.JLabel lblLogout;
    private javax.swing.JLabel lblProfile;
    private javax.swing.JPanel sidebarList;
    // End of variables declaration//GEN-END:variables
}
