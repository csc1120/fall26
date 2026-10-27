/*
 * Course: CSC-1120
 * Assignment name
 * File name
 * Name: Sean Jones
 * Last Updated:
 */
package week9.section111;

public class TreeDriver {
    static void main() {
        BinaryTree<Integer> tree = new BinaryTree<>(5, null, null);
        System.out.println(tree.isLeaf());
        BinaryTree<Integer> tree2 = new BinaryTree<>(8, null, null);
        // root is 3, left 5, right 8
        BinaryTree<Integer> tree3 = new BinaryTree<>(3, tree, tree2);
        System.out.println(tree3);
    }
}
