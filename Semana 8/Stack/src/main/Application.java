/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

/**
 *
 * @author Ksotillo
 */
public class Application {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Stack<Integer> stack = new Stack<>(5);

        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);

        int lastElement = stack.peek();
        System.out.println("El último elemento es " + lastElement);
        int deletedElement = stack.pop();
        System.out.println("Elemento eliminado: " + deletedElement);
        lastElement = stack.peek();
        System.out.println("El último elemento es " + lastElement);
        stack.push(1000);
        lastElement = stack.peek();
        System.out.println("El último elemento es " + lastElement);
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();
        lastElement = stack.peek();
        System.out.println("El último elemento es " + lastElement);
    }
    
    
    
    
    
    
    
    
    
    
    
}
