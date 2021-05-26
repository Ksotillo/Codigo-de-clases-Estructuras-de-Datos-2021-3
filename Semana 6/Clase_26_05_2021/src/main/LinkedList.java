/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.util.concurrent.TimeUnit;

/**
 *
 * @author Ksotillo
 * @param <T>
 */
public class LinkedList<T> {
    private Node<T> head;
    private Node<T> tail;

    public Node<T> getHead() {
        return this.head;
    }
    /**
     * Constructor for initially empty list
     */
    public LinkedList() {
        this.head = this.tail = null;
    }

    /**
     * Constructor for list initially with one node
     * @param n
     */
    public LinkedList(Node<T> n) {
        this.head = this.tail = n;
    }

    public void setHead(Node<T> head) {
        this.head = head;
    }
    
    public void setTail(Node<T> tail) {
        this.tail = tail;
    }
    
    /**
     * Checks whether list is empty or not
     * @return 
     */
    private boolean isEmpty() {
        return this.head == null;
    }
    
    /**
     *  Get the current size of the list
     * @return 
     */
    public int size() {
        int i = 0;
        
        if (isEmpty()) {
            return 0;
        }
        
        Node<T> aux = this.head;
        while(aux != null) {
            aux = aux.getNext();
            i++;
        }
        return i;
    }
    
    /**
     * Add datum to the first position of the list
     * @param datum Datum to be added
     */
    public void addFirst(T datum) {
        Node<T> n = new Node(datum);
        if (isEmpty()) {
            this.head = n;
            this.tail = n;
            this.head.setNext(this.tail);
            this.tail.setNext(null);
        } else {
            n.setNext(this.head);
            this.head = n;
        }
    }
    
    /**
     * Add datum to the last position of the list
     * @param datum Datum to be added
     */
    public void addLast(T datum) {
        Node<T> n = new Node(datum);
        if (isEmpty()) {
            this.head = n;
            this.tail = n;
            this.head.setNext(this.tail);
            this.tail.setNext(null);
        } else {
            this.tail.setNext(n);
            this.tail = n;
        }
    }
    
    /**
     * Add datum to the specified position
     * @param datum Datum to be added
     * @param i Position to be added in
     */
    public void add(T datum, int i) {
        if (isEmpty() || i == 0) {
            this.addFirst(datum);
        } else if (i >= size()) {
            this.addLast(datum);
        } else if (i < 0) {
            this.add(datum, size() + i);
        }else {
            Node<T> n = new Node(datum);
            Node aux = this.head; // Nodo previo
            int count = 0;
            while(count < i -1) {
                aux = aux.getNext();
                count++;
            }
            n.setNext(aux.getNext());
            aux.setNext(n);
        }
    }

    /**
     * Deletes first element of the list
     * @return The data of the first element
     */
    public T deleteFirst() {
        if (isEmpty()) {
            return null;
        }
        Node<T> temp = this.head;
        this.head= this.head.getNext();
        temp.setNext(null);
        return temp.getData();
    }
    
    /**
     * Deletes last element of the list
     * @return The data of the last element
     */
    public T deleteLast() {
        if (isEmpty()) {
            return null;
        }
        Node<T> pre = this.head;
        while(pre.getNext().getNext() != null) {
            pre = pre.getNext();
        }
        Node<T> temp = pre.getNext();
        pre.setNext(null);
        this.tail = pre;
        temp.setNext(null);
        return temp.getData();
        
    }
    
    /**
     * Deletes the element at the specified position
     * @param i The position to be deleted
     * @return The data of the deleted element
     */
    public T delete(int i) {
        if (isEmpty()) {
            return null;
        } else if (i == 0) {
            return deleteFirst();
        } else if (i == size() -1) {
            return deleteLast();
        } else if (i < 0)  {
            return delete(size() + i);
        } else if (i > size() - 1) {
            System.out.println("\nError");
            return null;
        } else {
            Node<T> aux = this.head;
            int count = 0;
            while(count < i-1) {
                aux = aux.getNext();
                count++;
            }
            Node<T> del = aux.getNext();
            aux.setNext(del.getNext());
            del.setNext(null);
            return del.getData();
        }
    }
    
    /**
     * Prints the list in a pretty format
     */
    public void print() {
        if (isEmpty()) {
            System.out.println("Vacia");
        } else {
            Node aux = this.head;
            int i = 0;
            while (aux != null) {
                System.out.print(aux.getData() + "(" + i + ")" + " -> ");
                aux = aux.getNext();
                i++;
            }
            System.out.println("");
        }
    }
    
    public void sortList() {  
        //Node current will point to head  
        Node<T> current = head, index = null;  
        T temp;  
          
        if(head == null) {  
            return;  
        }  
        else {  
            while(current != null) {  
                //Node index will point to node next to current  
                index = current.getNext();  
                  
                while(index != null) {  
                    //If current node's data is greater than index's node data, swap the data between them  
                    if(Node.comparator(current, index) > 0) {  
                        temp = current.getData();  
                        current.setData(index.getData());  
                        index.setData(temp);  
                    }  
                    index = index.getNext();  
                }  
                current = current.getNext();  
            }      
        }  
    }  
    
    // merging two linked list
	public Node SortedMerge(Node lst1, Node lst2)
	{
            // Base cases
            if (lst1 == null)
                    return lst2;

            else if (lst2 == null)
                    return lst1;

            Node result;

            if (Node.comparator(lst1, lst2) <= 0)
            {
                    result = lst1;
                    result.setNext(SortedMerge(lst1.getNext(), lst2));
            }
            else
            {
                    result = lst2;
                    result.setNext(SortedMerge(lst1, lst2.getNext()));
            }

            return result;
    }

//splitting list into two halves
    public Node[] FrontBackSplit(Node ptr)
    {
            // base case
            if (ptr == null || ptr.getNext() == null) {
                    return new Node[]{ ptr, null } ;
            }

            Node backward = ptr;
            Node forward = ptr.getNext();

            // Forward moves twice and backward moves once
            while (forward != null)
            {
                    forward = forward.getNext();
                    if (forward != null)
                    {
                            backward = backward.getNext();
                            forward = backward.getNext();
                    }
            }

    // splitting the linked list
            Node[] arr = new Node[]{ ptr, backward.getNext() };
            backward.setNext(null);

            return arr;
    }

    // Sorting linked list using merge sort.
    public Node MergeSort(Node head)
    {
            // Base case
            if (head == null || head.getNext() == null) {
                    return head;
            }

            Node[] arr = FrontBackSplit(head);
            Node first_half = arr[0];
            Node second_half = arr[1];


            first_half = MergeSort(first_half);
            second_half = MergeSort(second_half);

            // merge the two sorted list into single list.
            return SortedMerge(first_half, second_half);
    }
    
    public void reverse() {
        Node prev = null;
        Node current = this.head;
        Node next = null;
        this.setTail(current);
        while(current != null) {
            next = current.getNext();
            current.setNext(prev);
            prev = current;
            current = next;
        }
        
        this.setHead(prev);
        
    }
    
//    public void completeList() {
//        Node current = this.head;
//        int index = 0;
//        // 7, 8, 10, 13
//        while (current != null) {
//            if (current.getData() + 1 != current.getNext().getData()) {
//                this.add(current.getData() + 1, index+1);
//            }
//            current = current.getNext();
//            index++;
//        }
//    }
//    
    
        
    public void completeList() throws InterruptedException {
        Node current = this.head;
        int index = 1;
        // 7, 8, 10, 13
        while (current.getNext() != null) {
            if (Node.getValueAsInteger(current) + 1 != Node.getValueAsInteger(current.getNext())) {
                Integer a = Node.getValueAsInteger(current) + 1;
                this.add((T) a, index);
            }
            this.print();
            current = current.getNext();
            index++;
        }
    }
//    
}
