package Librerias;

import static Vista.Convertidor.consolaConvertidor;

public class JPEGHandler {
            
	public static void runHandler(ImageHandler imgh) throws Exception {
		/** NO CAMBIE ESTE CODIGO **/
		System.out.println("--------------------------------------");
                consolaConvertidor.append("-------------------------------------- \n");
		System.out.println(imgh.getClass().getTypeName().toUpperCase() + ": ");
                consolaConvertidor.append("\n"+imgh.getClass().getTypeName().toUpperCase() + ": \n");
		System.out.println("\nLeyendo imagen : " + imgh.getFileName());
                consolaConvertidor.append("\nLeyendo imagen : " + imgh.getFileName() + "\n");
		imgh.readFile();
		System.out.println("Proceso de lectura de imagen terminado!");
                consolaConvertidor.append("Proceso de lectura de imagen terminado! \n");
		System.out.println("\nGenerando imagenes : ");
                consolaConvertidor.append("\nGenerando imagenes : \n");
		imgh.generateFiles();
		System.out.println("Proceso de generacion de archivos terminado!");
                consolaConvertidor.append("\nProceso de generacion de archivos terminado! \n");
		System.out.println("\n--------------------------------------");
                consolaConvertidor.append("\n-------------------------------------- \n");
		/** --------------------- **/
	}
}