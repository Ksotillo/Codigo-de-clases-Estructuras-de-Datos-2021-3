
package main;

/**
 *
 * @author Ksotillo
 * @param <T>
 */
public class LinkedList<T> {
    private Node<T> head;
    private Node<T> tail;

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
        } else if (i >= (size() - 1)) {
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
    
    /**
     * Sorts list using insertion sort algorithm
     * @complexity O(n^2)
     */
    public void sortList() {
        // Auxiliary pointers
        Node<T> current = this.head;
        Node<T> next = null;
        // Auxiliary var
        T temp;
        // If list is empty we do nothing!
        if (isEmpty()) return;
        // For each element
        while (current != null) {
            // I will get the next for the current one
            next = current.getNext();
            // So I can move across the list looking for a value
            // which I can exchange the current with
            while (next != null) {
                // If I found tha value
                if (Node.comparator(current, next) > 0) {
                    // Then I exchange the values between those nodes
                    temp = current.getData();
                    current.setData(next.getData());
                    next.setData(temp);
                }
                // And go to teh next value to compare
                next = next.getNext();
            }
            // Then I move my comparassion pointer
            current = current.getNext();
        }
    }
    
    private Node sortedMerge(Node n1, Node n2) {
        if (n1 == null)
            return n2;
        else if (n2 == null)
            return n1;
        
        Node result;
        
        if (Node.comparator(n1, n2) <= 0) {
            result = n1;
            result.setNext(sortedMerge(n1.getNext(), n2));
        } else {
            result = n2;
            result.setNext(sortedMerge(n1, n2.getNext()));
        }
        
        return result;
        
    }
    
    private Node[] splitList(Node n) {
        if (n == null || n.getNext() == null)
            return new Node[]{ n, null };
        
        Node backward = n;
        Node forward = n.getNext();
        
        while (forward != null) {
            forward = forward.getNext();
            if (forward != null) {
                backward = backward.getNext();
                forward = forward.getNext();
            }
        }
        
        Node[] array = new Node[]{ n, backward.getNext() };
        backward.setNext(null);
        return array;
    }
    
    
    public Node mergeSort(Node head) { // O(n log n)
        if (head == null || head.getNext() == null)
            return head;
        
        Node[] array = splitList(head);
        Node first_half = array[0];
        Node second_half = array[1];
        
        first_half = mergeSort(first_half);
        second_half = mergeSort(second_half);
        
        return sortedMerge(first_half, second_half);
    }

    public Node<T> getHead() {
        return head;
    }

    public void setHead(Node<T> head) {
        this.head = head;
    }
    
    
    
}
