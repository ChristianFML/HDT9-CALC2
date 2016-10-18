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

public class main {
    
    static Map<String,String> map= null;
    static String words;
     
   public static void main(String args[]){
       
        String[] options = {"RedBlackBSt", "TreeMap"};
        int option = JOptionPane.showOptionDialog(null, "¿Que estructura de datos desea probar?", "Opciones personalizadas", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, null);
        JOptionPane.showMessageDialog(null, "Ha escogido "+options[option]);
        
        //Implementation for Red Black BST
        if(option == 1 || option == 2)
            map = new RedBlackBST();
        //Implementation for TreeMap
        else if (option == 3)
            map = new TreeMap<>();
   
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(System.getProperty("user.dir") + "\\diccionary.txt"));
            String linea;
            while((linea = br.readLine()) != null)
            {
                linea = linea.replaceAll(",", "");
                String[] palabras = linea.split("\\s{1,}");
                map.put(palabras[0], palabras[1]);
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
        
        JOptionPane.showMessageDialog(null, words);
   
   }
    
}
