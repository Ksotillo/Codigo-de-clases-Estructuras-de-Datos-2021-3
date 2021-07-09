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
public class TreeNode {
    
    private int data;
    private TreeNode left;
    private TreeNode right;
    
    
    public TreeNode(int data) {
        this.data = data;
        this.left = left;
        this.right = right;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }
    
    /**
     * Checks whether a node is leaf or not
     *
     * @return
     */
    public boolean isLeaf() {
        return (this.left == null && this.right == null);
    }

    /**
     * Prints the node content
     */
    public void printNode() {
        System.out.println(this.data);
    }
    
}
