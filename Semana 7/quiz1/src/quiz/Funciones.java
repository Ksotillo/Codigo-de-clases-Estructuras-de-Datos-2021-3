/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quiz;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.Arrays;
import javax.swing.JOptionPane;

/**
 *
 * @author Sabrina Correia
 */
public class Funciones {
    
    public void escribirTxt(LinkedList lista){
        //No lo supe guardar en JSON. Meper-donas?
        String lista_actuales="";
        if(!lista.isEmpty()){
            Node aux = lista.getHead();
            for (int i = 0; i < lista.size(); i++) {
                Alumno data = (Alumno) aux.getData();
                lista_actuales += data.getCedula()+","+ data.getCarnet() +","+ data.getNombre() +","+ data.getApellido()+","+ data.getQuiz1() +","+ data.getParcial1() +","+ data.getProyecto1() +","+ data.getQuiz2() +","+ data.getParcial2() +","+ data.getProyecto2() +","+data.getTotal()+ "\n";
                aux = aux.getNext(); 
            }
        }   
        try{
            PrintWriter pw = new PrintWriter("test\\notas_datos_de_estructuras_2.csv");
            pw.print("Cedula,Carnet,Nombre,Apellido,Quiz #1,Parcial #1,Proyecto #1,Quiz #2,Parcial #2,Proyecto #2,Total\n");
            pw.print(lista_actuales);
            pw.close();
            JOptionPane.showMessageDialog(null, "Guardado exitoso");      
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public LinkedList leerTxt(){
        LinkedList lista = new LinkedList();
        String line;
        String lista_txt = "";
        String path = "test\\notas_datos_de_estructuras.csv";
        File file = new File(path);
        try{
            if (!file.exists()){
                file.createNewFile();
            }else{
                FileReader fr = new FileReader(file);
                BufferedReader br = new BufferedReader(fr);
                while((line = br.readLine()) != null){
                    if(!line.isEmpty()){
                        lista_txt += line + "\n"; 
                        //System.out.println(lista_txt);
                    }
                }
                
                if (!"".equals(lista_txt)){
                    
                    String[] lista_split = lista_txt.split("\n");
                    String[][] matriz = new String[lista_split.length][];
                    for (int i = 1; i < lista_split.length; i++) {
                        String[] palabras = lista_split[i].split(",");
                        matriz[i] = palabras;                        
                        //System.out.println(Arrays.toString(palabras));
                        Alumno alumno = new Alumno(Integer.parseInt(palabras[0]),palabras[1],palabras[2],palabras[3],Float.parseFloat(palabras[4]),Float.parseFloat(palabras[5]),Float.parseFloat(palabras[6]),Float.parseFloat(palabras[7]),Float.parseFloat(palabras[8]),Float.parseFloat(palabras[9]),Float.parseFloat(palabras[10]));
                        lista.addLast(alumno);
                    }
//                    for (int i = 0; i < matriz.length; i++) {
//                        for (int j = 0; j < matriz[0].length; j++) {
//                            matriz[i][]
//                        }
//                    }
                   
                }
                br.close();
                JOptionPane.showMessageDialog(null, "Lectura exitosa");
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        return lista;
    }
}
