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
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import javax.imageio.ImageIO;

/**
 *
 * @author fi944
 */
public class JPEGImageHandlerColors extends ImageHandler {

    protected String copyname;
    private String path;
    private String typePath;
    private FileInputStream input;
    private BufferedImage bufferedImage;
    private String filename;
    private int value;
    private String outRedPathFile;
    private String outGreenPathFile;
    private String outBluePathFile;

    public JPEGImageHandlerColors(String filename, String path, String typePath, int value) {
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

        int Width = Datos[18] & 0xFF | ((Datos[19] & 0xFF) << 8) | ((Datos[20] & 0xFF) << 16) | ((Datos[21] & 0xFF) << 24);
        int Height = Datos[22] & 0xFF | ((Datos[23] & 0xFF) << 8) | ((Datos[24] & 0xFF) << 16) | ((Datos[25] & 0xFF) << 24);
        int padding = (4 - (Width * 3) % 4) % 4;

        System.out.println("Width: " + Width);
        System.out.println("Height: " + Height);

        try {
            if (value == 1) {
                outRedPathFile = outPath + "Red" + copyname + typePath;
                outGreenPathFile = outPath + "Green" + copyname + typePath;
                outBluePathFile = outPath + "Blue" + copyname + typePath;
            }
            if (value == 2) {
                outRedPathFile = outPath2 + "Red" + copyname + typePath;
                outGreenPathFile = outPath2 + "Green" + copyname + typePath;
                outBluePathFile = outPath2 + "Blue" + copyname + typePath;
            }
            FileOutputStream ImagenRed = new FileOutputStream(outRedPathFile);
            ImagenRed.write(Datos);

            FileOutputStream ImagenGreen = new FileOutputStream(outGreenPathFile);
            ImagenGreen.write(Datos);

            FileOutputStream ImagenBlue = new FileOutputStream(outBluePathFile);
            ImagenBlue.write(Datos);

            for (int y = 0; y < Height; y++) {
                for (int x = 0; x < Width; x++) {
                    int blue = input.read();
                    int green = input.read();
                    int red = input.read();

                    ImagenRed.write(0);
                    ImagenRed.write(0);
                    ImagenRed.write(red);

                    ImagenGreen.write(0);
                    ImagenGreen.write(green);
                    ImagenGreen.write(0);

                    ImagenBlue.write(blue);
                    ImagenBlue.write(0);
                    ImagenBlue.write(0);
                }
                input.skip(padding);
                for (int i = 0; i < padding; i++) {
                    ImagenRed.write(0);
                    ImagenGreen.write(0);
                    ImagenBlue.write(0);
                }
            }

            input.close();
            ImagenRed.close();
            ImagenGreen.close();
            ImagenBlue.close();

            converterdBMPtoJPEG("Red" + copyname, outRedPathFile, "jpg", ".jpg");
            converterdBMPtoJPEG("Green" + copyname, outGreenPathFile, "jpg", ".jpg");
            converterdBMPtoJPEG("Blue" + copyname, outBluePathFile, "jpg", ".jpg");
        } catch (Exception e) {
            System.out.println("ERROR" + e);
        }
    }
}
