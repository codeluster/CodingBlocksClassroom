package June27.OnlineLecture.BinaryTree;

import java.util.Scanner;

// A binary tree can have 0, 1 or 2 children.
public class BinaryTree {

    private class Node {
        int data;
        // Since a binary tree can only have upto two children instead of an array list of nodes
        // like in a generic tree we can explicitly create two nodes for each child.
        Node leftChild;
        Node rightChild;

        // Empty constructor
        public Node() {
            this.data = 0;
            this.leftChild = null;
            this.rightChild = null;
        }

        public Node(int data, Node leftChild, Node rightChild) {
            this.data = data;
            this.leftChild = leftChild;
            this.rightChild = rightChild;
        }

    }

    private Node root;

    public BinaryTree() {
        Scanner scanner = new Scanner(System.in);
        this.root = getTree(null, false, scanner, true);
    }

    public BinaryTree(String string) {
        Scanner scanner = new Scanner(string);
        this.root = getTree(null, false, scanner, false);
    }

    // @Param isLeft triggers the option to add a second child
    private Node getTree(Node parent, Boolean isLeft, Scanner scanner, boolean interactive) {

        if (parent == null && interactive) {
            System.out.println("Enter data for root node...");
        } else if (interactive) {
            System.out.println(isLeft ? "Enter data for first child of " + parent.data : "Enter data for second child of " + parent.data);
        }

        // Create a new child node
        Node child = new Node();

        // Give the child node data
        child.data = scanner.nextInt();

        if (interactive) System.out.printf("Does %d have a child?", child.data);

        if (scanner.nextBoolean()) {
            child.leftChild = getTree(child, true, scanner, interactive);
        } else return child;

        if (interactive) System.out.printf("Does %d have another child?", child.data);

        if (scanner.nextBoolean()) {
            child.rightChild = getTree(child, false, scanner, interactive);
        }

        return child;

    }

    public void display() {

        System.out.println();
        System.out.println("-----------------");

        display(this.root);

        System.out.println("-----------------");
        System.out.println();

    }

    private void display(Node parent) {

        if (parent == null) return;

        StringBuilder builder = new StringBuilder();

        if (parent.leftChild != null) {
            builder.append(parent.leftChild.data);
        } else builder.append("END");
        builder.append(" => ");
        builder.append(parent.data);
        builder.append(" <= ");
        if (parent.rightChild != null) {
            builder.append(parent.rightChild.data);
        } else builder.append("END");
        System.out.println(builder.toString());

        display(parent.leftChild);
        display(parent.rightChild);

    }

    public int getHeight() {
        return getHeight(this.root) - 1;
    }

    private int getHeight(Node parent) {

        if (parent == null) return 0;

        int height = 1;

        int lHeight = getHeight(parent.leftChild);
        int rHeight = getHeight(parent.rightChild);

        int maxChildHeight = Math.max(lHeight, rHeight);

        return height + maxChildHeight;
    }

}
