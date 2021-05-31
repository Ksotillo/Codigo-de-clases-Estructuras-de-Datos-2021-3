/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quiz.ejercicio1;

import java.util.Arrays;

/**
 *
 * @author Sabrina Correia
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static int[][] desenfocar(int[][] m) {
        //If x < 1 or y < 1 or x + 1 == width or y + 1 == height
        int sum = 0;
        int[][] m2 = new int[m.length][m[0].length];
         
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[0].length; j++) {
                if(i >= 1 && j >= 1 && i  != m.length - 1 && j + 1 != m[0].length){
                    sum = m[i - 1][j + 1] + 
                          m[i + 0][j + 1] + 
                            m[i + 1][j + 1] + 
                            m[i - 1][j + 0] + 
                            m[i + 0][j + 0] + 
                            m[i + 1][j + 0] + 
                            m[i - 1][j - 1] + 
                            m[i + 0][j - 1] + 
                            m[i + 1][j - 1];
                    int cant = Math.round(sum/ 9 ) ;
                    m2[i][j] = cant;
                }
                
            }
        }
        return m2;

    }
    
    public static int[][] boxBlur(int[][] image, int blurSize) {
        // 3, 5, 7, 9
        // Columnas que voy a eliminar
        // 3 -> 2
        // 5 -> 4
        // 7 -> 6
        // Lo que yo voy a recorrer
        // 3 -> 3/2 -> 1.5 -> 1
        // 5 -> 5/2 -> 2.5 -> 2
        // 7 -> 7/2 -> 3.5 -> 3
        int bordersToDelete = blurSize - 1;
        int [][] result = new int[image.length - bordersToDelete][image[0].length - bordersToDelete];
        int size = (int) blurSize/2;
        for (int i = size; i < image.length - size; i++) {
            for (int j = size; j < image[0].length - size; j++) {
                result[i - size][j - size] = avg(image, i, j, size);
            }
        }
        return result;
    }
    
    public static int avg(int[][] image, int x, int y, int size) {
        int sum = 0;
        for (int i = x - size; i <= x+size; i++ ){
            for (int j = y - size; j <= y+size; j++ ){
                sum += image[i][j];
            }
        }
        
        return (int)(sum/Math.pow(size * 2 + 1, 2));
    }

    public static void main(String[] args) {
        int[][] image = {{1, 1, 1},
        {1, 7, 1},
        {1, 1, 1}};

        int[][] image2 = {{36,0,18,9}, {27,54,9,0}, {81,63,72,45}};
        int [][] image3  =  {{36,0,18,9,9,45,27}, {27,0,254,9,0,63,90}, {81,255,72,45,18,27,0}, {0,0,9,81,27,18,45}, {45,45,227,227,90,81,72}, {45,18,9,255,9,18,45}, {27,81,36,127,255,72,81}};
        int[][] mr = boxBlur(image3, 7);
        int[][] mr2 = boxBlur(image2, 3);
        for (int i = 0; i < mr.length; i++) {
            System.out.println(Arrays.toString(mr[i]));
        }
        System.out.println("");
        for (int i = 0; i < mr2.length; i++) {
            System.out.println(Arrays.toString(mr2[i]));
        }

    }

}
