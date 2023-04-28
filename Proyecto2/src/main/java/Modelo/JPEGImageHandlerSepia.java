/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import Librerias.ImageHandler;
import static Modelo.Utils.converterdBMPtoJPEG;
import static Modelo.Utils.outPath;
import static Modelo.Utils.outPath2;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 *
 * @author fi944
 */
public class JPEGImageHandlerSepia extends ImageHandler {

    protected String copyname;
    private String path;
    private String typePath;
    private FileInputStream input;
    private BufferedImage bufferedImage;
    private String filename;
    private int value;
    private String outPathFile;

    public JPEGImageHandlerSepia(String filename, String path, String typePath, int value) {
        super(filename);
        this.copyname = "-" + filename;
        this.filename = filename;
        this.path = path;
        this.typePath = typePath;
        this.value = value;
    }

    @Override
    public void readFile() throws Exception {
        input = new FileInputStream(path);
    }

    @Override
    public void generateFiles() throws Exception {
        byte[] Datos = new byte[54];
        input.read(Datos);

        int Width = ((Datos[21] & 0xFF) << 24) | ((Datos[20] & 0xFF) << 16) | ((Datos[19] & 0xFF) << 8) | (Datos[18] & 0xFF);
        int Height = ((Datos[25] & 0xFF) << 24) | ((Datos[24] & 0xFF) << 16) | ((Datos[23] & 0xFF) << 8) | (Datos[22] & 0xFF);
        int padding = (4 - (Width * 3) % 4) % 4;
        int imageSize = (Width * 3 + padding) * Height;
        byte[] image = new byte[imageSize];

        System.out.println("Width: " + Width);
        System.out.println("Height: " + Height);
        input.read(image);
        input.close();

        for (int i = 0; i < imageSize; i += 3) {
            int r = (int) image[i + 2] & 0xff;
            int g = (int) image[i + 1] & 0xff;
            int b = (int) image[i] & 0xff;
            int tr = (int) (0.393 * r + 0.769 * g + 0.189 * b);
            int tg = (int) (0.349 * r + 0.686 * g + 0.168 * b);
            int tb = (int) (0.272 * r + 0.534 * g + 0.131 * b);
            if (tr > 255) {
                tr = 255;
            }
            if (tg > 255) {
                tg = 255;
            }
            if (tb > 255) {
                tb = 255;
            }
            image[i + 2] = (byte) tr;
            image[i + 1] = (byte) tg;
            image[i] = (byte) tb;
        }

        if (value == 1) {
            outPathFile = outPath + "Sepia" + copyname + typePath;
        } 
        
        if (value == 2) {
            outPathFile = outPath2 + "Sepia" + copyname + typePath;
        }
        FileOutputStream Imagen = new FileOutputStream(outPathFile);
        Imagen.write(Datos);
        Imagen.write(image);
        Imagen.close();
        converterdBMPtoJPEG(filename, outPathFile, "jpg", ".jpg");
    }
}
