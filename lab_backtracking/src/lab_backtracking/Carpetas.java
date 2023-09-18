/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab_backtracking;

import java.io.File;
import java.util.Scanner;

public class Carpetas {

    public static void main(String[] args) {
        Carpetas findFile = new Carpetas();
        Scanner scan = new Scanner(System.in);
        System.out.println("Ingrese el archivo a buscar.. ");
        String nombreArchi = scan.next();
        File f = new File("src/resources/model.xml");

        System.out.println("-------------------------------");
        String file = findFile.encontrarArchivo(nombreArchi, new File("src/"));
        System.out.println("this: "+file);
        System.out.println(":"+f.toString());
        findFile.acomodarDireccion(file);
        
    }

    public String encontrarArchivo(String nombreArchivo, File direccion) {
        int bandera = 0;
        String file = "";
        File[] listaDirectorio = direccion.listFiles();
        if (listaDirectorio != null) {
            for (File dirArchivo : listaDirectorio) {
                if (dirArchivo.isDirectory()) {
                    file += encontrarArchivo(nombreArchivo, dirArchivo);
                } else if (nombreArchivo.equalsIgnoreCase(dirArchivo.getName())) {

                    System.out.println("La direccion es:");
                    System.out.println(dirArchivo.getPath());
                    file += dirArchivo.getPath().toString();
                    bandera++;
                    
                }
                
            }
        }
        return file;
    }
    
    public void acomodarDireccion(String directorio){
        String[] partesDir = directorio.split("/");
        for (int i = 0; i < partesDir.length; i++) {
            System.out.println(partesDir[i]);
        }
    }

}
