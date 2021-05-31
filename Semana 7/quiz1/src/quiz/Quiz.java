/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quiz;

/**
 *
 * @author Sabrina Correia
 */
public class Quiz {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        LinkedList<Alumno> notas = new LinkedList();
        Funciones func = new Funciones();
        
        notas = func.leerTxt();
        ventana1 v1 = new ventana1(notas);
        v1.setVisible(true);
    }
    
}
