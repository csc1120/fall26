/*
 * Course: CSC-1120
 * Assignment name
 * File name
 * Name: Sean Jones
 * Last Updated:
 */
package week9.section121;

public class TreeDriver {
    static void main() {
        BinaryTree<Integer> tree1 = new BinaryTree<>(5, null, null);
        BinaryTree<Integer> tree2 = new BinaryTree<>(8, null, null);
        BinaryTree<Integer> tree3 = new BinaryTree<>(9, tree1, tree2);
        BinaryTree<Integer> tree4 = new BinaryTree<>(1, tree3, null);
        System.out.println(tree4);
    }
}
