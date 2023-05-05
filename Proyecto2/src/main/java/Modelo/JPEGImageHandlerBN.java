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
public class JPEGImageHandlerBN extends ImageHandler {

    protected String copyname;
    private final String path;
    private final String typePath;
    private FileInputStream input;
    private BufferedImage bufferedImage;
    private final String filename;
    private String outPathFile;
    private final int value;

    public JPEGImageHandlerBN(String filename, String path, String typePath, int value) {
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

        int Width = ((Datos[21] & 0xff) << 24) | ((Datos[20] & 0xff) << 16) | ((Datos[19] & 0xff) << 8) | (Datos[18] & 0xff);
        int Height = ((Datos[25] & 0xff) << 24) | ((Datos[24] & 0xff) << 16) | ((Datos[23] & 0xff) << 8) | (Datos[22] & 0xff);
        int padding = (4 - (Width * 3) % 4) % 4;

        if (value == 1) {
            outPathFile = outPath + "BlancoNegro" + copyname + typePath;
        }
        if (value == 2) {
            outPathFile = outPath2 + "BlancoNegro" + copyname + typePath;
        }
        FileOutputStream Imagen = new FileOutputStream(outPathFile);
        Imagen.write(Datos);

        for (int y = 0; y < Height; y++) {
            for (int x = 0; x < Width; x++) {
                int blue = input.read();
                int green = input.read();
                int red = input.read();

                // calculate the grayscale value of each pixel
                int gray = (int) (0.299 * red + 0.587 * green + 0.114 * blue);

                // write the grayscale value to the output BMP file
                Imagen.write(gray);
                Imagen.write(gray);
                Imagen.write(gray);
            }

            // skip over any padding bytes in the input BMP file
            input.skip(padding);

            // add any necessary padding bytes to the output BMP file
            for (int i = 0; i < padding; i++) {
                Imagen.write(0);
            }
        }

        input.close();
        Imagen.close();
        converterdBMPtoJPEG(filename, outPathFile, "jpg", ".jpg");
    }

}
