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
        LinkedList list = new LinkedList();
//        LinkedList<String> list = new LinkedList();
//        LinkedList<Student> list = new LinkedList();
//        
        list.addLast(1);
//        list.addLast(2);
//        list.addLast(3);
//        list.addLast(4);
        list.addLast(5);
//        
//        list.print();
//        
//        list.reverse();
        list.print();

//        int a = 10;
//        String className = ((Object) a).getClass().getSimpleName();
//        System.out.println(className);
        list.completeList();
        list.print();

    }

}
