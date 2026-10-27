/*
 * Course: CSC-1120
 * Assignment name
 * File name
 * Name: Sean Jones
 * Last Updated:
 */
package week9.section111;

public class BinaryTree<E> {
    protected static class Node<E> {
        protected E data;
        protected Node<E> left;
        protected Node<E> right;

        protected Node(E data) {
            this.data = data;
            left = null;
            right = null;
        }

        @Override
        public String toString() {
            return String.valueOf(this.data);
        }
    }

    protected Node<E> root;

    public BinaryTree() {
        this.root = null;
    }

    public BinaryTree(E data, BinaryTree<E> left, BinaryTree<E> right) {
        this.root = new Node<>(data);
        this.root.left = left == null ? null : left.root;
        this.root.right = right == null ? null : right.root;
    }

    protected BinaryTree(Node<E> root) {
        this.root = root;
    }

    public BinaryTree<E> getLeftSubTree() {
        return this.root == null || this.root.left == null ? null :
                new BinaryTree<>(this.root.left);
    }

    public BinaryTree<E> getRightSubTree() {
        return this.root == null || this.root.right == null ? null :
                new BinaryTree<>(this.root.right);
    }

    public E getData() {
        return this.root == null ? null : this.root.data;
    }

    public boolean isLeaf() {
        return this.root != null && this.root.left == null && this.root.right == null;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        toString(this.root, 1, sb);
        return sb.toString();
    }

    private void toString(Node<E> node, int level, StringBuilder sb) {
        // new level
        sb.append(" ".repeat(Math.max(0, level - 1)));
        // base case
        if(node == null) {
            sb.append("null\n");
        } else {
            // preorder
            // visit
            sb.append(node).append("\n");
            // left
            toString(node.left, level + 1, sb);
            //right
            toString(node.right, level + 1, sb);
        }
    }














}
