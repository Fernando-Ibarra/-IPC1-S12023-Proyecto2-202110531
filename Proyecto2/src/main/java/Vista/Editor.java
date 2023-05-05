/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vista;

import Librerias.BmpHandlerCopy;
import Librerias.JPEGHandler;
import Modelo.BMPtoJPEGImage;
import Modelo.JPEGImageHandlerBN;
import Modelo.JPEGImageHandlerColors;
import Modelo.JPEGImageHandlerRotator;
import Modelo.JPEGImageHandlerSepia;
import Modelo.JPEGtoBMPImage;
import static Modelo.JPEGtoBMPImage.pathImagesBMP;
import static Modelo.Utils.converterdBMPtoJPEG;
import static Modelo.Utils.converterdJPEGtoBMP;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author fi944
 */
public class Editor extends javax.swing.JFrame {

    private String path;
    private String nameFile;
    private String typeFile;
    private String[] colors = {"Red", "Green", "Blue", "Sepia"};

    /**
     * Creates new form Editor
     */
    public Editor() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jCheckBox1 = new javax.swing.JCheckBox();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jCheckBox2 = new javax.swing.JCheckBox();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jCheckBox3 = new javax.swing.JCheckBox();
        jCheckBox4 = new javax.swing.JCheckBox();
        jLabel3 = new javax.swing.JLabel();
        jCheckBox5 = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jCheckBox1.setText("JPEG a BMP / BMP a JPEG");

        jButton1.setText("Seleccionar Imagen");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Ejecutar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Salir");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jCheckBox2.setText("Copia JEPG");

        jLabel1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel1.setText("Seleccione acciones:");

        jLabel2.setText(" ");

        jCheckBox3.setText("Rojo Verde Azul Sepia");

        jCheckBox4.setText("Modificar Imagen");

        jLabel3.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel3.setText("EDITOR");

        jCheckBox5.setText("Blanco y Negro ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(181, 181, 181))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(270, 270, 270))
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 405, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton1)
                                .addGap(137, 137, 137)
                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 18, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jCheckBox5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jCheckBox3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jCheckBox1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCheckBox2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jCheckBox4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(40, 40, 40))))
            .addGroup(layout.createSequentialGroup()
                .addGap(139, 139, 139)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCheckBox1)
                    .addComponent(jCheckBox2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCheckBox3)
                    .addComponent(jCheckBox4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jCheckBox5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        MenuInicial menuI = new MenuInicial();
        menuI.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            JFileChooser browseImageFile = new JFileChooser();
            FileNameExtensionFilter filter = new FileNameExtensionFilter("IMAGES", "jpg", "jpeg", "bmp");
            browseImageFile.addChoosableFileFilter(filter);
            int showOpenDialogue = browseImageFile.showOpenDialog(null);
            if (showOpenDialogue == JFileChooser.APPROVE_OPTION) {
            File selectedImageFile = browseImageFile.getSelectedFile();
            path = selectedImageFile.getAbsolutePath();
            String name = selectedImageFile.getName();
            String name2 = path.substring(44);
            String[] arrOfStr = name.split("\\.", 2);
            nameFile = arrOfStr[0];
            typeFile = arrOfStr[1];
            jLabel2.setText(path);
            System.out.println(typeFile);
        }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "IMAGEN NO SELECCIONADA");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if (jCheckBox1.isSelected()) {
            try {
                if (typeFile.equals("jpg") || typeFile.equals("jpeg")) {
                    converterdJPEGtoBMP(nameFile, path, "bmp", ".bmp");
                }
                if (typeFile.equals("bmp")) {
                    converterdBMPtoJPEG(nameFile, path, "jpg", ".jpg");
                }
            } catch (Exception ex) {
                Logger.getLogger(Editor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        if (jCheckBox2.isSelected()) {
            try {
                if (typeFile.equals("jpg") || typeFile.equals("jpeg")) {
                    copyImg(path, pathImagesBMP);
                }
                if (typeFile.equals("bmp")) {
                    copyImg(path, path);
                }
            } catch (Exception ex) {
                Logger.getLogger(Editor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        if (jCheckBox3.isSelected()) {
            try {
                if (typeFile.equals("jpg") || typeFile.equals("jpeg")) {
                    colorsImg(path, pathImagesBMP);
                }
                if (typeFile.equals("bmp")) {
                    colorsImg(path, path);
                }
            } catch (Exception ex) {
                Logger.getLogger(Editor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        if(jCheckBox4.isSelected()){
            try {
                if (typeFile.equals("jpg") || typeFile.equals("jpeg")) {
                    hvImg(path, pathImagesBMP);
                }
                if (typeFile.equals("bmp")) {
                    hvImg(path, path);
                }
            } catch (Exception ex) {
                Logger.getLogger(Editor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        if(jCheckBox5.isSelected()){
            try {
                if (typeFile.equals("jpg") || typeFile.equals("jpeg")) {
                    bwImg(path, pathImagesBMP);
                }
                if (typeFile.equals("bmp")) {
                    bwImg(path, path);
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "IMAGEN NO SELECCIONADA");
            }
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    public void copyImg(String path, String path2) throws Exception {
        converterdJPEGtoBMP(nameFile, path, "bmp", ".bmp");
        BmpHandlerCopy bmpCopy = new BmpHandlerCopy(nameFile, path2, ".bmp", 1);
        JPEGHandler.runHandler(bmpCopy);
    }
    
    public void colorsImg(String path, String path2) throws Exception{
        converterdJPEGtoBMP(nameFile, path, "bmp", ".bmp");
        JPEGImageHandlerColors colorsImge = new JPEGImageHandlerColors(nameFile, path2, ".bmp", 1);
        JPEGImageHandlerSepia sepiaImge= new JPEGImageHandlerSepia(nameFile, path2, ".bmp", 1);
        JPEGHandler.runHandler(sepiaImge);
        JPEGHandler.runHandler(colorsImge);
    }
    
    public void hvImg(String path, String path2) throws Exception{
        converterdJPEGtoBMP(nameFile, path, "bmp", ".bmp");
        JPEGImageHandlerRotator hvImge = new JPEGImageHandlerRotator(nameFile, path2, ".bmp", 1);
        JPEGHandler.runHandler(hvImge);
    }
    
    public void bwImg(String path, String path2) throws Exception{
        converterdJPEGtoBMP(nameFile, path, "bmp", ".bmp");
        JPEGImageHandlerBN bwImge = new JPEGImageHandlerBN(nameFile, path2, ".bmp", 1);
        JPEGHandler.runHandler(bwImge);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Editor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Editor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Editor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Editor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Editor().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JCheckBox jCheckBox3;
    private javax.swing.JCheckBox jCheckBox4;
    private javax.swing.JCheckBox jCheckBox5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    // End of variables declaration//GEN-END:variables
}
