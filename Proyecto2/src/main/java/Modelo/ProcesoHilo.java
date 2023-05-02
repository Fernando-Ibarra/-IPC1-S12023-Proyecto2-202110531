/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import Librerias.BmpHandlerCopy;
import Librerias.JPEGHandler;
import static Modelo.JPEGtoBMPImage.pathImagesBMP;
import static Modelo.Utils.converterdBMPtoJPEG;
import static Modelo.Utils.converterdJPEGtoBMP;
import static Modelo.Utils.thread;
import Vista.Editor;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author fi944
 */
public class ProcesoHilo extends Thread {

    private String path;
    private String nameFile;
    private String typeFile;
    private boolean op1 = false;
    private boolean op2 = false;
    private boolean op3 = false;
    private boolean op4 = false;
    private boolean op5 = false;

    public ProcesoHilo(String path, boolean op1, boolean op2, boolean op3, boolean op4, boolean op5) {
        this.path = path;
        String name2 = path.substring(44);
        String[] arrOfStr = name2.split("\\.", 2);
        nameFile = arrOfStr[0];
        typeFile = arrOfStr[1];
        this.op1 = op1;
        this.op2 = op2;
        this.op3 = op3;
        this.op4 = op4;
        this.op5 = op5;
    }

    public void run() {
        try {
            Thread.sleep(500);
            if (op1) {
                Thread.sleep(10);
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
            if (op3) {
                Thread.sleep(10);
                try {
                    if (typeFile.equals("jpg") || typeFile.equals("jpeg")) {
                        colorsImg(path, pathImagesBMP, nameFile);
                    }
                    if (typeFile.equals("bmp")) {
                        colorsImg(path, path, nameFile);
                    }
                } catch (Exception ex) {
                    Logger.getLogger(Editor.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (op4) {
                Thread.sleep(10);
                try {
                    if (typeFile.equals("jpg") || typeFile.equals("jpeg")) {
                        hvImg(path, pathImagesBMP, nameFile);
                    }
                    if (typeFile.equals("bmp")) {
                        hvImg(path, path, nameFile);
                    }
                } catch (Exception ex) {
                    Logger.getLogger(Editor.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (op5) {
                Thread.sleep(10);
                try {
                    if (typeFile.equals("jpg") || typeFile.equals("jpeg")) {
                        bwImg(path, pathImagesBMP, nameFile);
                    }
                    if (typeFile.equals("bmp")) {
                        bwImg(path, path, nameFile);
                    }
                } catch (Exception ex) {
                    Logger.getLogger(Editor.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (op2) {
                Thread.sleep(1000);
                try {
                    if (typeFile.equals("jpg") || typeFile.equals("jpeg")) {
                        copyImg(path, pathImagesBMP, nameFile);
                    }
                    if (typeFile.equals("bmp")) {
                        copyImg(path, path, nameFile);
                    }
                } catch (Exception ex) {
                    Logger.getLogger(Editor.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(ProcesoHilo.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void copyImg(String path, String path2, String nameFile) throws Exception {
        converterdJPEGtoBMP(nameFile, path, "bmp", ".bmp");
        BmpHandlerCopy bmpCopy = new BmpHandlerCopy(nameFile, path2, ".bmp", 2);
        JPEGHandler.runHandler(bmpCopy);
    }

    public void colorsImg(String path, String path2, String nameFile) throws Exception {
        converterdJPEGtoBMP(nameFile, path, "bmp", ".bmp");
        JPEGImageHandlerColors colorsImge = new JPEGImageHandlerColors(nameFile, path2, ".bmp", 2);
        JPEGImageHandlerSepia sepiaImge = new JPEGImageHandlerSepia(nameFile, path2, ".bmp", 2);
        JPEGHandler.runHandler(sepiaImge);
        JPEGHandler.runHandler(colorsImge);
    }

    public void hvImg(String path, String path2, String nameFile) throws Exception {
        converterdJPEGtoBMP(nameFile, path, "bmp", ".bmp");
        JPEGImageHandlerRotator hvImge = new JPEGImageHandlerRotator(nameFile, path2, ".bmp", 2);
        JPEGHandler.runHandler(hvImge);
    }

    public void bwImg(String path, String path2, String nameFile) throws Exception {
        converterdJPEGtoBMP(nameFile, path, "bmp", ".bmp");
        JPEGImageHandlerBN bwImge = new JPEGImageHandlerBN(nameFile, path2, ".bmp", 2);
        JPEGHandler.runHandler(bwImge);
    }
}
