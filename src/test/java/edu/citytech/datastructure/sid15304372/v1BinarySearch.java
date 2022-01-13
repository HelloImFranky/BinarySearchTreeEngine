package edu.citytech.datastructure.sid15304372;

import edu.citytech.datastructure.sid15304372.bst.BinarySearchTree;

public class v1BinarySearch {

    public static void main(String[] args) {
        var bst = new BinarySearchTree();
        bst.insert(75);
        bst.insert(40);
        bst.insert(10);
        bst.insert(65);
        System.out.println(bst);

        var bstABC = new BinarySearchTree();
        bstABC.insert("z");
        bstABC.insert("a");
        bstABC.insert("b");
        bstABC.insert("c");
        System.out.println("Test");
    }
}
