/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quiz;

/**
 *
 * @author Sabrina Correia
 */
public class Node<T> {

    private T data;
    private Node next;

    /**
     *
     * @param datum
     */
    public Node(T datum) {
        this.data = datum;
        this.next = null;
    }

    /**
     * Get Node's data
     *
     * @return the data inside Node
     */
    public T getData() {
        return data;
    }

    /**
     * Sets new data to Node
     *
     * @param data
     */
    public void setData(T data) {
        this.data = data;
    }

    /**
     *
     * @return a reference to the next Node
     */
    public Node getNext() {
        return next;
    }

    /**
     * Sets new Node to reference to
     *
     * @param next
     */
    public void setNext(Node next) {
        this.next = next;
    }

    /**
     *
     * @param firstNode
     * @param secondNode
     * @return
     */
    public static int comparator(Node firstNode, Node secondNode, int op) {
        Alumno data1 = (Alumno) firstNode.getData();
        Alumno data2 = (Alumno) secondNode.getData();
        switch (op) {
            case 0:
                int firstDataInteger = data1.getCedula();
                int secondDataInteger = data2.getCedula();
                if (firstDataInteger > secondDataInteger) {
                    
                    return 1;
                } else if (secondDataInteger > firstDataInteger) {
                    return -1;
                } else {
                    return 0;
                }
            case 1:
            {
                String firstDataString = data1.getNombre();
                String secondDataString = data2.getNombre();
                if (firstDataString.compareToIgnoreCase(secondDataString) > 0) {
                    return 1;
                } else if (firstDataString.compareToIgnoreCase(secondDataString) < 0) {
                    return -1;
                } else {
                    return 0;
                }
            }
            case 2:
            {
                String firstDataString = data1.getApellido();
                String secondDataString = data2.getApellido();
                if (firstDataString.compareToIgnoreCase(secondDataString) > 0) {
                    return 1;
                } else if (firstDataString.compareToIgnoreCase(secondDataString) < 0) {
                    return -1;
                } else {
                    return 0;
                }
            }
            case 3:
            {
                float firstDatafloat = data1.getTotal();
                float secondDatafloat = data2.getTotal();
                if (firstDatafloat < secondDatafloat) {
                    
                    return 1;
                } else if (secondDatafloat < firstDatafloat) {
                    return -1;
                } else {
                    return 0;
                }
            }
            default:
                break;
        }

//        if (!firstClass.equals(secondClass)) {
//            throw new Error("Nodes does not have same data or are not the same class");
//        }

//        switch (firstClass) {
//            case "Integer":
//                Integer firstDataInteger = (Integer) firstNode.getData();
//                Integer secondDataInteger = (Integer) secondNode.getData();
//                if (firstDataInteger > secondDataInteger) {
//                    return 1;
//                } else if (secondDataInteger > firstDataInteger) {
//                    return -1;
//                } else {
//                    return 0;
//                }
//            case "Double":
//                Double firstDataDouble = (Double) firstNode.getData();
//                Double secondDataDouble = (Double) secondNode.getData();
//                if (firstDataDouble > secondDataDouble) {
//                    return 1;
//                } else if (secondDataDouble > firstDataDouble) {
//                    return -1;
//                } else {
//                    return 0;
//                }
//            case "String":
//                String firstDataString = (String) firstNode.getData();
//                String secondDataString = (String) secondNode.getData();
//                if (firstDataString.length() > secondDataString.length()) {
//                    return 1;
//                } else if (secondDataString.length() > firstDataString.length()) {
//                    return -1;
//                } else {
//                    return 0;
//                }
//            case "String":
//                String firstDataString = (String) firstNode.getData();
//                String secondDataString = (String) secondNode.getData();
//                if (firstDataString.compareToIgnoreCase(secondDataString) > 0) {
//                    return 1;
//                } else if (firstDataString.compareToIgnoreCase(secondDataString) < 0) {
//                    return -1;
//                } else {
//                    return 0;
//                }
//        }

        return 0;
    }
}
