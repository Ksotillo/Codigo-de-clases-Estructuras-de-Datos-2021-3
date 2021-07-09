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
        BST tree = new BST();
        tree.insert(tree.getRoot(), new TreeNode(25));
        tree.insert(tree.getRoot(), new TreeNode(15));
        tree.insert(tree.getRoot(), new TreeNode(50));
        tree.insert(tree.getRoot(), new TreeNode(10));
        tree.insert(tree.getRoot(), new TreeNode(22));
        tree.insert(tree.getRoot(), new TreeNode(4));
        tree.insert(tree.getRoot(), new TreeNode(12));
        tree.insert(tree.getRoot(), new TreeNode(18));
        tree.insert(tree.getRoot(), new TreeNode(24));
        tree.insert(tree.getRoot(), new TreeNode(35));
        tree.insert(tree.getRoot(), new TreeNode(31));
        tree.insert(tree.getRoot(), new TreeNode(44));
        tree.insert(tree.getRoot(), new TreeNode(70));
        tree.insert(tree.getRoot(), new TreeNode(66));
        tree.insert(tree.getRoot(), new TreeNode(90));
        
        // Buscar un elemento que exista
        TreeNode element = tree.search(tree.getRoot(), 90);
        System.out.println("Busqueda de elemento: ");
        element.printNode();
        
        // Buscar un elemento que NO exista
        element = tree.search(tree.getRoot(), 100);
        System.out.println("Busqueda de elemento: ");
        if (element != null) {
            element.printNode();        
        } else {
            System.out.println("No existe");
        }
        
        // Nivel de un dato en el árbol
        int level = tree.getNodeLevel(tree.getRoot(), 18, 0);
        System.out.println("Nivel del elemento 18: " + level);
        
        // Nivel de un dato que no esta en el árbol
        level = tree.getNodeLevel(tree.getRoot(), 7, 0);
        System.out.println("Nivel del elemento 7: " + ((level == -1) ? "No está en el arbol" : "level"));
        
        // Recorrido In Order
        System.out.print("Recorrido In Order: ");
        System.out.println(tree.getRoot().getLeft().getData());
        tree.inOrder(tree.getRoot());
        System.out.println("");
        // Recorrido Pre Order
        System.out.print("Recorrido Pre Order: ");
        tree.preOrder(tree.getRoot());
        System.out.println("");
//        // Recorrido Post Order
        System.out.print("Recorrido Post Order: ");
        tree.postOrder(tree.getRoot());
    }
    
}
