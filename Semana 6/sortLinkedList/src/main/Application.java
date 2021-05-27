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
        LinkedList<Integer> list = new LinkedList();
        LinkedList<String> list2 = new LinkedList();
        LinkedList<Integer> listMergeSort = new LinkedList();
        long startTime, endTime, timeElapsed;
//        boolean a = true;
//        String klass = ((Object) a).getClass().getSimpleName();
//        System.out.println(klass);

        for (int i = 0; i < 1000; i++) {
            int randomNumber = (int)Math.round(Math.random()*(100)+1);
            list.addLast(randomNumber);
        }
        
        list.print();
        startTime = System.nanoTime();
        list.sortList();
        endTime = System.nanoTime();
        list.print();
        
        timeElapsed = endTime - startTime;
        System.out.println("Tiempo de ejecición de Insertion Sort en milisegundos: " + timeElapsed / 1000000);
        
//        list2.addLast("Prueba");
//        list2.addLast("Universidad");
//        list2.addLast("Estructuras");
//        list2.addLast("Hola");
//        list2.addLast("Kevin");
        
//        list2.print();
//        list2.sortList();
//        list2.print();

        for (int i = 0; i < 1000; i++) {
            int randomNumber = (int)Math.round(Math.random()*(100)+1);
            listMergeSort.addLast(randomNumber);
        }
        
        listMergeSort.print();
        startTime = System.nanoTime();
        Node head = listMergeSort.mergeSort(listMergeSort.getHead());
        listMergeSort.setHead(head);
        endTime = System.nanoTime();
        listMergeSort.print();

        timeElapsed = endTime - startTime;
        System.out.println("Tiempo de ejecición de Merge Sort en milisegundos: " + timeElapsed / 1000000);
        
        
        
        
        
    }
    
}
