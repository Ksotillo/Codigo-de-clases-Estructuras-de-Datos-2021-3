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
        Node n = new Node<Integer>(10);
        Node n1 = new Node<String>("Hola");
        CircularDoublyLinkedList<Integer> list = new CircularDoublyLinkedList<>(n);
        list.addFirst(45);
        list.addLast(90);
        list.print();
        list.add(80, 0);
        list.add(100, 2);
        list.add(70, 5);
        list.print();
        list.deleteFirst();
        list.deleteLast();
        list.print();
        System.out.println("----------");
        list.delete(0);
        list.print();     
        list.add(8, 0);
        list.add(150, 2);
        list.add(2, 4);          
        System.out.println("----------");
        list.sortList();
        list.print();  
    }
    
}
