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
        Queue<Integer> queue = new Queue<>(5);

        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);

        int firstElement = queue.peek();
        System.out.println("El primer elemento es " + firstElement);
        int deletedElement = queue.dequeue();
        System.out.println("Elemento eliminado: " + deletedElement);
        firstElement = queue.peek();
        System.out.println("El primer elemento es " + firstElement);
        queue.enqueue(1000);
        firstElement = queue.dequeue();
        firstElement = queue.peek();
        System.out.println("El primer elemento es " + firstElement);
        queue.dequeue();
        int size = queue.getSize();
        System.out.println("El temaño de la lista ahora es: " + size);
        queue.dequeue();
        queue.dequeue();
        size = queue.getSize();
        System.out.println("El temaño de la lista ahora es: " + size);
        firstElement = queue.peek();
        System.out.println("El primer elemento es " + firstElement);
    }
    
    
    
    
    
    
    
    
    
    
    
}
