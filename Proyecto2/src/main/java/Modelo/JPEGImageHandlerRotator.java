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
public class JPEGImageHandlerRotator extends ImageHandler {

    protected String copyname;
    private String path;
    private String typePath;
    private FileInputStream input;
    private BufferedImage bufferedImage;
    private String filename;
    private int value;
    private String outHorizontalPathFile;
    private String outVerticalPathFile;

    public JPEGImageHandlerRotator(String filename, String path, String typePath, int value) {
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

        int Width = byteArrayToInt(Datos, 18);
        int Height = byteArrayToInt(Datos, 22);

        int rowSize = (Width * 3 + 3) / 4 * 4;

        byte[] imageData = new byte[rowSize * Height];
        input.read(imageData);

        byte[] rotatedImageData = new byte[imageData.length];
        byte[] rotatedImageData2 = new byte[imageData.length];

        for (int row = 0; row < Height; row++) {
            for (int col = 0; col < Width; col++) {
                int srcIndex = row * rowSize + col * 3;
                int destIndex = row * rowSize + (Width - col - 1) * 3;
                rotatedImageData[destIndex] = imageData[srcIndex];
                rotatedImageData[destIndex + 1] = imageData[srcIndex + 1];
                rotatedImageData[destIndex + 2] = imageData[srcIndex + 2];
            }
        }

        for (int row = 0; row < Height; row++) {
            for (int col = 0; col < Width; col++) {
                int srcIndex = row * rowSize + col * 3;
                int destIndex = (Height - row - 1) * rowSize + col * 3;
                rotatedImageData2[destIndex] = imageData[srcIndex];
                rotatedImageData2[destIndex + 1] = imageData[srcIndex + 1];
                rotatedImageData2[destIndex + 2] = imageData[srcIndex + 2];
            }
        }

        if (value == 1) {
            outHorizontalPathFile = outPath + "HRotation" + copyname + typePath;
            outVerticalPathFile = outPath + "VRotation" + copyname + typePath;
        }
        if (value == 2) {
            outHorizontalPathFile = outPath2 + "HRotation" + copyname + typePath;
            outVerticalPathFile = outPath2 + "VRotation" + copyname + typePath;
        }

        FileOutputStream Imagen = new FileOutputStream(outHorizontalPathFile);

        FileOutputStream Imagen2 = new FileOutputStream(outVerticalPathFile);

        Imagen.write(Datos);
        Imagen2.write(Datos);

        Imagen.write(rotatedImageData);
        Imagen2.write(rotatedImageData2);

        Imagen.close();
        Imagen2.close();
        input.close();
        converterdBMPtoJPEG("HRotation" + filename, outHorizontalPathFile, "jpg", ".jpg");
        converterdBMPtoJPEG("VRotation" + filename, outVerticalPathFile, "jpg", ".jpg");

    }

    private static int byteArrayToInt(byte[] bytes, int offset) {
        return (bytes[offset + 3] & 0xFF) << 24
                | (bytes[offset + 2] & 0xFF) << 16
                | (bytes[offset + 1] & 0xFF) << 8
                | (bytes[offset] & 0xFF);
    }

}
