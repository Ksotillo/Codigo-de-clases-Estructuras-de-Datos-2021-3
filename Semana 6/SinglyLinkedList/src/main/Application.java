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
        Node n = new Node(10);
        LinkedList list = new LinkedList(n);
        list.addFirst(45);
        list.addLast(90);
        list.add(80, 0);
        list.add(100, 2);
        list.add(70, 5);
        list.print();
        list.deleteFirst();
        list.deleteLast();
        list.print();
        list.delete(0);
        list.print();               
        list.delete(3);
        list.add(80, 0);
        list.add(100, 2);
        list.print(); 
        list.add(70, 5);
        list.print();  
        list.delete(4);
        list.print();  
        list.delete(-1);
        list.print(); 
        list.add(9000, -1);
        list.print(); 
        
    }
    
}
