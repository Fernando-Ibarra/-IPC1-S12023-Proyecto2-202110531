/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import Librerias.ImageHandler;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import javax.imageio.ImageIO;

/**
 *
 * @author fi944
 */
public class BMPtoJPEGImage extends ImageHandler{
    
    private String path;
    private String filename;
    private String typeFile;
    private String typePath;
    private BufferedImage bufferedImage;
    
    String outPath = "C:/Users/fi944/OneDrive/Escritorio/ImagenesProyecto2/";

    public BMPtoJPEGImage(String path, String filename, String typeFile, String typePath) {
        super(filename);
        this.path = path;
        this.filename = filename;
        this.typeFile = typeFile;
        this.typePath = typePath;
    }

    @Override
    public void readFile() throws Exception {
        bufferedImage = ImageIO.read(new File(path));
    }
    

    @Override
    public void generateFiles() throws Exception {
        try {
            String outFile = outPath + "converted-" + filename + typePath;
            System.out.println(outFile);
            FileOutputStream output = new FileOutputStream(outFile);
            ImageIO.write(bufferedImage, typeFile, output);
            output.close();
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }
    
}