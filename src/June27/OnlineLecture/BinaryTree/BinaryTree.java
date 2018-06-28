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
        this.root = getTree(null, false, scanner);
    }

    // @Param isLeft triggers the option to add a second child
    private Node getTree(Node parent, Boolean isLeft, Scanner scanner) {

        if (parent == null) {
            System.out.println("Enter data for root node...");
        } else {
            System.out.println(isLeft ? "Enter data for first child of " + parent.data : "Enter data for second child of " + parent.data);
        }

        // Create a new child node
        Node child = new Node();

        // Give the child node data
        child.data = scanner.nextInt();

        System.out.printf("Does %d have a child?", child.data);

        if (scanner.nextBoolean()) {
            child.leftChild = getTree(child, true, scanner);
        } else return child;

        System.out.printf("Does %d have another child?", child.data);

        if (scanner.nextBoolean()) {
            child.rightChild = getTree(child, false, scanner);
        }

        return child;

    }

    public void display() {
        display(this.root);
    }

    private void display(Node parent) {

        if (parent == null) return;

        System.out.println();
        System.out.println("-----------------");

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

        System.out.println("-----------------");
        System.out.println();
    }

}
