package com.patrick.fundamentals.tree.bst;

import java.util.*;

/**
 * Binary Search Tree
 * Created by Patrick on 12/2/16.
 */

public class BST {
    Node root; // root node;

    private class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
        }
    }

    public BST() {
    }

    public void insert(int data) {
        if (root == null) {
            root = new Node(data);
        } else {
            insert(root, data);
        }
    }

    private Node insert(Node node, int data) {
        if (node == null) {
            return new Node(data);
        }
        if (data < node.data) {
            node.left = insert(node.left, data);
        } else if (data > node.data) {
            node.right = insert(node.right, data);
        } else {
            node.data = data;
        }
        return node;
    }

    public void delete(int data) {

    }

    public boolean find(int data) {
        return find(root, data);
    }


    private boolean find(Node node, int data) {
        if (node == null) {
            return false;
        }
        if (data == node.data) {
            return true;
        } else if (data < node.data) {
            return find(node.left, data);
        } else {
            return find(node.right, data);
        }
    }

    public void print() {
        print(root);
    }

    private void print(Node node) {
        if (node == null) {
            return;
        }
        print(node.left);
        System.out.print(node.data + "\t");
        print(node.right);
    }


    public static void main(String[] args) {
        BST bst = new BST();
        Random random = new Random();
        for (int i = 0; i < 50; i++) {
            bst.insert(random.nextInt(100));
        }
        bst.print();
    }
}