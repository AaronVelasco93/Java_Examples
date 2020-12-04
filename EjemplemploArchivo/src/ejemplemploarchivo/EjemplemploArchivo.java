/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplemploarchivo;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 *
 * @author Aaron
 */
public class EjemplemploArchivo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        try {
            File file = new File("entrada_salida.txt");

            boolean success = file.createNewFile();

            if (success) {
                //Si el fichero no existe se crea 

                System.out.println("El fichero no existe y se crea.");
                //comrprueba que el fichero se pueda leer y escribir
                System.out.println("El fichero se puede escribir" + file.canWrite());
                System.out.println("El Fichero se puede leer" + file.canRead());

                // Se le asocia al fichero un bufer de escritura
                BufferedWriter file_escribir = new BufferedWriter(new FileWriter(file));

                //Lanza la exepcion
                //Escriben las cadenas de caracteres en el fichero 
                //Separadas por saltos de lineas
                file_escribir.write("Una primera sentencia");
                file_escribir.newLine();
                file_escribir.write("8.5");
                file_escribir.newLine();
                file_escribir.write("6");
                file_escribir.newLine();

                file_escribir.flush();
                file_escribir.close();

                // se abre el fichero para leer el contenido con Scanner
                Scanner file_lectura = new Scanner(file);

                //leemos el contenido del archivo
                String leer = file_lectura.nextLine();

                String leer2 = file_lectura.nextLine();

                String leer3 = file_lectura.nextLine();

                //tratar de leer los datos conversion parseo
                double double_leer;
                int int_leer;

                double_leer = Double.parseDouble(leer2);
                int_leer = Integer.parseInt(leer3);
                //mostramos los diferentes textos insertados 

                System.out.println("La cadena leida" + leer);
                System.out.println("El double leeido" + leer2);
                System.out.println("El int leeido" + leer3);

            } else {
                System.out.println("EL fiche no existe");
            }

        } catch (FileNotFoundException f_exepcion) {
            //operacion que suceda en el caso no encontrar el fichero
            //al crear el scanner
            System.out.println("Las operaciones de lectura no se han podido realizar");
            System.out.println("Problema al buscar el fichero");
            System.out.println(f_exepcion);
        }catch(IOException io_exeption){
            //algun error de escritura
            System.out.println("Algun error de entrada o salida");
            System.out.println(io_exeption);
        }catch(NumberFormatException nb_exepcion){
             //error al generar un combersion de cadena
            System.out.println("ocurrio un error al la combersion de cadenas  a numeros");
            System.out.println(nb_exepcion);
        }catch(NoSuchElementException nse_exeption){
            //error cuando el metodo netline(); no encuentra una cadena 
            System.out.println("no se a podico encontrar el siguiente elemento scanner");
            System.out.println(nse_exeption);
        
        }catch(Exception e_exeption){
            //el utimo bloque que nos permite capturar cualquier excepcion
            System.out.println(e_exeption.toString());
        }

    }

}
