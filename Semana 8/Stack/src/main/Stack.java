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
public class Stack<T> {
    
    private Node<T> head;
    
    public Stack(){
        this.head = null;
    }

    public Stack(T datum) {
        Node<T> n = new Node(datum);
        this.head = n;
    }
    
    private boolean isEmpty() {
        return this.head == null;
    }
    
    public void push(T datum) {
        Node<T> n = new Node(datum);
        if (isEmpty()) {
            this.head = n;
        } else {
            n.setNext(this.head);
            this.head = n;
        }
    }
    
    public T pop() {
        if (isEmpty()) {
            return null;
        }
        
        Node<T> temp = this.head;
        this.head = temp.getNext();
        temp.setNext(null);
        return temp.getData();
    }
    
    
    public T peek() {
        if (isEmpty()) {
            return null;
        }
        
        Node <T> temp = this.head;
        return temp.getData();
    }
    
    
}
