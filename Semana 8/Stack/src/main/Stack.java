/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

/**
 *
 * @author Ksotillo
 * @param <T>
 */
public class Stack<T> {
    
    private Node<T> head;
    
    /**
     *
     */
    public Stack(){
        this.head = null;
    }

    /**
     *
     * @param datum
     */
    public Stack(T datum) {
        Node<T> n = new Node(datum);
        this.head = n;
    }
    
    private boolean isEmpty() {
        return this.head == null;
    }
    
    /**
     * Adds a new element to the Stack
     * @param datum The element to be added to the Stack
     * @complexity O(1)
     */
    public void push(T datum) {
        Node<T> n = new Node(datum);
        if (isEmpty()) {
            this.head = n;
        } else {
            n.setNext(this.head);
            this.head = n;
        }
    }
    
    /**
     * Deletes the last element in the Stack and returns its data
     * @return The data of the last element in the Stack
     * @complexity O(1)
     */
    public T pop() {
        if (isEmpty()) {
            return null;
        }
        
        Node<T> temp = this.head;
        this.head = temp.getNext();
        temp.setNext(null);
        return temp.getData();
    }
    
    /**
     * Gets the data contained in the last element in the Stack
     * @return The Data of the last element in the Stack
     * @complexity O(1)
     */
    public T peek() {
        if (isEmpty()) {
            return null;
        }
        
        Node <T> temp = this.head;
        return temp.getData();
    }
    
    
}
