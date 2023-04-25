/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import Librerias.BmpHandlerCopy;
import Librerias.JPEGHandler;
import static Modelo.JPEGtoBMPImage.pathImagesBMP;
import Vista.Editor;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author fi944
 */
public class Utils {

    public static String outPath = "C:/Users/fi944/OneDrive/Escritorio/ImagenesProyecto2/";
    public static int indexMostrar;
    public static ListaUsuario myList = new ListaUsuario();
    public static ListaImagenes myImages = new ListaImagenes();
    public static LinkedList<Categoria> myCategories = new LinkedList<>();
    
    public static void converterdJPEGtoBMP(String nameFile, String path, String type, String typePath) throws Exception {
        JPEGtoBMPImage jpegToBmp = new JPEGtoBMPImage(path, nameFile, type, typePath);
        try {
            JPEGHandler.runHandler(jpegToBmp);
        } catch (IOException ex) {
            Logger.getLogger(Editor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void converterdBMPtoJPEG(String nameFile, String path, String type, String typePath) throws Exception {
        BMPtoJPEGImage bmpToJpeg = new BMPtoJPEGImage(path, nameFile, type, typePath);
        try {
            JPEGHandler.runHandler(bmpToJpeg);
        } catch (IOException ex) {
            Logger.getLogger(Editor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
