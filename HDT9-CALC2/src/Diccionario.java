/*
 * Universidad del Valle de Guatemala
 * Algoritmos y Estructuras de Datos
 * Ing. Douglas Barrios
 * Integrantes:
 *      Christian Morales - 15015
 *      José Luis Méndez - 1504
 * HDT 9 -> Diccionario 2
 * Fecha: 17 de octubre del 2016
 */

import java.util.*;
import java.io.*;
import javax.swing.*;

public class Diccionario {
    
    static Map<String,String> map= null;
    static String words;
     
   public static void main(String args[]){
       
        String[] options = {"RedBlackBSt", "TreeMap"};
        int option = JOptionPane.showOptionDialog(null, "¿Que estructura de datos desea probar?", "Opciones personalizadas", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, null);
        JOptionPane.showMessageDialog(null, "Ha escogido "+options[option]);
        
        //Implementation for Red Black BST
        if(option == 1)
            map = new RedBlackBST();
        //Implementation for TreeMap
        else if (option == 2)
            map = new TreeMap<>();
   
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(System.getProperty("user.dir") + "\\diccionario.txt"));
            String linea;
            while((linea = br.readLine()) != null)
            {
                linea = linea.replaceAll(",", ""); //esto sirve para eliminar las comas unidas a las palabras
                String[] palabras = linea.split("\\s{1,}");
                if (palabras.length>2){
                    if (palabras[1].equals("la") || palabras[1].equals("el")){
                        map.put(palabras[0], palabras[2]);
                    }
                    else {
                        map.put(palabras[0],palabras[1]);
                    }
                }
                else if (palabras.length>1){
                    map.put(palabras[0], palabras[1]);
                }                
            }
        } catch (IOException e) {
                e.printStackTrace();
        } finally {
            try {
                if (br != null)
                    br.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
   
   
   }
    
}
