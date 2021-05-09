/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.util.Arrays;

/**
 *
 * @author Ksotillo
 */
public class Application {
    
    public static int adjacentElementsProduct(int[] array) {
        int max = array[0] * array[1];
        for (int i = 1; i < array.length - 1; i++) {
            int current = array[i];
            int next = array[i + 1];
            int product = current * next;
            if (max < product){
                max = product;
            }
        }
        
        return max;
    }
    
    public static boolean arrayContainsElement(int[] array, int searchElement) {
        for (int element : array) {
            if (element == searchElement) return true;
        }
        return false;
    }
    
    public static int getStatuesRemaining(int[] array) {
        int max  = array[0], min = array[0];
        
        for (int i = 1; i < array.length; i++) {
            int current = array[i];
            if (current > max) {
                max = current;
            }
            if (current < min) {
                min = current;
            }
        }
        System.out.println("Max: " + max);
        System.out.println("Min: " + min);
        
        int counter = 0;
        for (int possibleMissingElement = min; possibleMissingElement < max; possibleMissingElement++) {
            if (!arrayContainsElement(array, possibleMissingElement)) {
                System.out.println("Elemento que falta: " + possibleMissingElement);
                counter++;
            }
        }
        
        return counter;
    }

    public static int getStatuesRemaining2(int[] array) {
        int max  = array[0], min = array[0];
        
        for (int i = 1; i < array.length; i++) {
            int current = array[i];
            if (current > max) {
                max = current;
            }
            if (current < min) {
                min = current;
            }
        }
        System.out.println("Max: " + max);
        System.out.println("Min: " + min);
        //4, 5,  7,
        return max - min + 1 - array.length;
    }
    
    public static int getStatuesRemaining3(int[] array) {
        Arrays.sort(array);
        int max  = array[array.length - 1], min = array[0];
        
        System.out.println("Max: " + max);
        System.out.println("Min: " + min);
        //4, 5,  7,
        return max - min + 1 - array.length;
    }
    
    
    public static int matrixElementsSum(int[][] matrix) {
        int sum = 0;
        
        for (int j = 0; j < matrix[0].length; j++) {
            for (int i = 0; i < matrix.length; i++) {
                if (matrix[i][j] > 0) sum+= matrix[i][j];
                else break;
            }
        }
        
        return sum;
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//        int[] array = new int[5];
//        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        
//        for (int i = 0; i < array.length; i++) {
//            System.out.println(array[i]);
//        }
        
//        for (int i : array) {
//            System.out.println(i);
//        }
        // [ 1,2 ,3 , 4 , 5 ]
//        System.out.print("[");
//        for (int i = 0; i < array.length; i++) {
//            System.out.print(array[i] + (i < array.length - 1 ? ", " : "") );
//        }
//        System.out.print("]");

//        int accumulator = 0;
//        for (int i = 0; i < array.length; i++) {
//            accumulator += array[i];
//        }
//        System.out.println(accumulator);
//        sum()

//        int[] array = {8, 75, 6, 268, 36, 309, 28, 3, 35, 176, 59, 88, 15, 16, 79, 48};
//        int max = array[0];
//        for (int i = 1; i < array.length; i++) {
//            int current = array[i];
//            if (current > max) {
//                max = current;
//            }
//        }
//        System.out.println(max);
//        int min = array[0];
//        for (int i = 1; i < array.length; i++) {
//            int current = array[i];
//            if (current < min) {
//                min = current;
//            }
//        }
//        System.out.println(min);
                     // 0  1  2   3  4  5  6
//        int[] array = { 3, 6, -2, -5, 7, 3, 10 };
        
//        int max = array[0] * array[1];
//        for (int i = 1; i < array.length - 1; i++) {
//            int current = array[i];
//            int next = array[i + 1];
//            int product = current * next;
//            if (max < product){
//                max = product;
//            }
//        }
//        
//        System.out.println(max);
//        int maxProduct = adjacentElementsProduct(array);
//        System.out.println(maxProduct);
//        int[] statues = { 6, 2, 3, 8 };
//        // 2 , 3, 4, 5, 6, 7, 8
//        int statuesRemaining  = getStatuesRemaining3(statues);
//        System.out.println("Total que faltan: " + statuesRemaining);

//        int[][] m = new int[1][5];
//        int[][] matrix = {{8, 75, 6, 268}, 
//                          {36, 309, 28, 35}, 
//                          {176, 59, 88, 15}, 
//                          {16, 79, 48, 0}};
//        for (int i = 0; i < matrix.length * 8; i++) {
//            System.out.print("_");
//        }
//        System.out.println("");
//        for (int i = 0; i < matrix.length; i++) {
//            for (int j = 0; j < matrix.length; j++) {
//                System.out.print("| " + matrix[i][j] + "\t");
//                if (j == matrix[0].length - 1) System.out.print("|");
//            }
//            System.out.println("");
//        }
//        for (int i = 0; i < matrix.length * 11; i++) {
//            System.out.print("‾");
//        }
        int[][] hotelRooms =  { { 0, 1, 1, 2, 0, 5 },
                                { 0, 5, 0, 0, 10, 0 },
                                { 2, 0, 3, 3, 5, 20 } };
        
        int totalSum = matrixElementsSum(hotelRooms);
        System.out.println(totalSum);
        
    }
    
}
