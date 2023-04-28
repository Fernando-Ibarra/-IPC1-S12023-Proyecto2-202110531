package Librerias;

/* 
	Codigo creado para el curso de ipc1 
 */
import static Modelo.Utils.converterdBMPtoJPEG;
import static Modelo.Utils.outPath;
import static Modelo.Utils.outPath2;
import java.io.*;
import javax.imageio.ImageIO;
/**
*	BmpHandlerCopy class es una subclase de ImageHandler. A BmpHandlerCopy object 
* 	lets us handle an original bmp file by being able of making an exact copy of it.
*
*	@author Auxiliares
*	@version 1.0
**/
public class BmpHandlerCopy extends ImageHandler {
    
        private String path;
        private String typePath;
        private int value;
        private String outPathFile;

	/**
	*	Array of bytes that will allocate all header and data for original file
	**/
	protected byte[] filebytes;
	/**
	*	File name that will be given to the copy of the original file
	**/
	protected String copyname;
	
	/**
	*	Builds and returns a BmpHandlerCopy object which handles the file 
	* 	represented by the given name
	*	@param imagename Name of the original file being handled by this object
	**/
	public BmpHandlerCopy(String imagename, String path, String typePath, int value) {
		super(imagename);
		this.copyname = "copy-" + imagename;
                this.path = path;
                this.typePath = typePath;
                this.value = value; 
	}

	/**
	*	Reads handled file header and data in bytes
	**/
	public void readFile() throws Exception {
		FileInputStream input = new FileInputStream(path);
		filebytes = new byte[input.available()];
		input.read(filebytes);
		input.close();
		System.out.println("Imagen leida: " + path);
	}
	/**
	*	Generates a copy file from the original file. The name of the generated
	* 	file will be build by the same name preceeded of "copy-"
	**/	
	public void generateFiles() throws Exception {
                if(value == 1){
                    outPathFile = outPath + copyname + typePath;
                } 
                if(value == 2){
                    outPathFile = outPath2 + copyname + typePath;
                }
		FileOutputStream output = new FileOutputStream(outPathFile);
		output.write(filebytes);
                output.close();
                converterdBMPtoJPEG(copyname, outPathFile, "JPG", ".jpg");
		System.out.println("Imagen generada: " + copyname);
	}
}