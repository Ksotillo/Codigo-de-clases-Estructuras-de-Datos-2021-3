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
public class CircularLinkedList<T> {
    private Node<T> tail;

    /**
     * Constructor for initially empty list
     */
    public CircularLinkedList() {
        this.tail = null;
    }

    /**
     * Constructor for list initially with one node
     * @param n
     */
    public CircularLinkedList(Node<T> n) {
        this.tail = n;
        this.tail.setNext(n);
    }

    public Node<T> getTail() {
        return tail;
    }

    public void setTail(Node<T> tail) {
        this.tail = tail;
    }

    
    
    /**
     * Checks whether list is empty or not
     * @return 
     */
    private boolean isEmpty() {
        return this.tail == null;
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
        
        Node<T> aux = this.tail.getNext();
        do {
            i++;
            aux = aux.getNext();
        } while (aux != this.tail.getNext());
        return i;
    }
    
    /**
     * Add datum to the first position of the list
     * @param datum Datum to be added
     */
    public void addFirst(T datum) {
        Node<T> n = new Node(datum);
        if (isEmpty()) {
            this.tail = n;
            this.tail.setNext(n);
        } else {
            n.setNext(this.tail.getNext());
            this.tail.setNext(n);
        }
    }
    
    /**
     * Add datum to the last position of the list
     * @param datum Datum to be added
     */
    public void addLast(T datum) {
        Node<T> n = new Node(datum);
        if (isEmpty()) {
            this.tail = n;
            this.tail.setNext(n);
        } else {
            n.setNext(this.tail.getNext());
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
        } else if (i >= (size() - 1)) {
            this.addLast(datum);
        } else if (i < 0) {
            this.add(datum, size() + i);
        }else {
            Node<T> n = new Node(datum);
            Node aux = this.tail.getNext(); // Nodo previo
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
        Node<T> temp = this.tail.getNext();
        this.tail.setNext(temp.getNext());
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
        Node<T> pre = this.tail.getNext();
        do {
            pre = pre.getNext();
        } while(pre.getNext().getNext() != this.tail.getNext());
//        while(pre.getNext().getNext() != null) {
//            pre = pre.getNext();
//        }
        Node<T> temp = pre.getNext();
        pre.setNext(this.tail.getNext());
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
            Node<T> aux = this.tail.getNext();
            int count = 0;
            while(count < i-1) {
                aux = aux.getNext();
                count++;
            }
            Node<T> del = aux.getNext();
            Node<T> temp = del.getNext();
            aux.setNext(temp);
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
            Node aux = this.tail.getNext();
            int i = 0;
            do {
                System.out.print(aux.getData() + "(" + i + ")" + " -> ");
                aux = aux.getNext();
                i++;
            } while(aux != this.tail);
            System.out.println("");
        }
    }
    
    public void sortList() {  
        //Node current will point to head  
        Node<T> current = this.tail.getNext(), index = null;  
        T temp;  
          
        if(isEmpty()) {  
            return;  
        }  
        else {  
            do {
                //Node index will point to node next to current  
                index = current.getNext(); 
                do {
                    //If current node's data is greater than index's node data, swap the data between them  
                    if(Node.comparator(current, index) > 0) {  
                        temp = current.getData();  
                        current.setData(index.getData());  
                        index.setData(temp);  
                    }  
                    index = index.getNext();  
                }  while(index != current.getNext());
                current = current.getNext();  
            } while (current != this.tail.getNext());
        }  
    }  
    
    // merging two linked list
//	public Node sortedMerge(Node n1, Node n2) {
//            // Base cases
//            if (n1 == null)
//                    return n2;
//
//            else if (n2 == null)
//                    return n1;
//
//            Node result;
//
//            if (Node.comparator(n1, n2) <= 0)
//            {
//                    result = n1;
//                    result.setNext(sortedMerge(n1.getNext(), n2));
//            }
//            else
//            {
//                    result = n2;
//                    result.setNext(sortedMerge(n1, n2.getNext()));
//            }
//
//            return result;
//    }
//
////splitting list into two halves
//    public Node[] splitList(Node n) {
//            // base case
//            if (n == null || n.getNext() == null) {
//                    return new Node[]{ n, null } ;
//            }
//
//            Node backward = n;
//            Node forward = n.getNext();
//
//            // Forward moves twice and backward moves once
//            while (forward != null)
//            {
//                    forward = forward.getNext();
//                    if (forward != null)
//                    {
//                            backward = backward.getNext();
//                            forward = forward.getNext();
//                    }
//            }
//
//    // splitting the linked list
//            Node[] arr = new Node[]{ n, backward.getNext() };
//            backward.setNext(null);
//
//            return arr;
//    }
//
//    // Sorting linked list using merge sort.
//    public Node mergeSort(Node head)
//    {
//            // Base case
//            if (head == null || head.getNext() == null) {
//                    return head;
//            }
//
//            Node[] arr = splitList(head);
//            Node first_half = arr[0];
//            Node second_half = arr[1];
//
//
//            first_half = mergeSort(first_half);
//            second_half = mergeSort(second_half);
//
//            // merge the two sorted list into single list.
//            return sortedMerge(first_half, second_half);
//    }
    
}
