package June27.GenericTree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class GenericTree {

    private class Node {
        int data;
        ArrayList<Node> children = new ArrayList<>();
    }

    private Scanner scanner;
    private Node root;

    //Constructor
    public GenericTree(String str) {

        scanner = new Scanner(str);
        this.root = takeInput(null, -1);

    }

    private Node takeInput(Node parent, int childIndex) {

        Node child = new Node();

        System.out.println(parent == null ? "Enter data for root node..." : "Enter data for child number" + (childIndex + 1) + " of " + parent.data + " ...");
        child.data = scanner.nextInt();

        System.out.println("How many children will this node have?");

        // get child's children
        int number_of_children = scanner.nextInt();
        for (int i = 0; i < number_of_children; i++) {
            child.children.add(takeInput(child, i));
        }

        return child;

    }

    public void display() {

        System.out.println("-------------");
        display(root);
        System.out.println("-------------");

    }

    private void display(Node parent) {

        StringBuilder builder = new StringBuilder();

        builder.append(parent.data);
        builder.append(" -> ");

        //add all children to the string
        for (Node child : parent.children) {

            builder.append(child.data);
            builder.append(" ");
        }

        builder.append(".");

        //Print all children
        System.out.println(builder.toString());

        //call all children to do so
        for (Node child : parent.children) {
            display(child);
        }

    }

    public int getSize() {
        return getSize(this.root);
    }

    private int getSize(Node parent) {
        int count = 0;
        for (Node child : parent.children) {
            count += getSize(child);
        }
        return count + 1;
    }

//
//    Solution using a "mover"
//
//    private class Mover {
//        int moverInt;
//        boolean moverBoolean;
//    }
//
//    public int getMax() {
//        Mover mover = new Mover();
//        mover.moverInt = this.root.data;
//        getMax(this.root, mover);
//        return mover.moverInt;
//    }
//
//    private void getMax(Node parent, Mover mover) {
//        int content = parent.data;
//        if (content > mover.moverInt) {
//            mover.moverInt = content;
//        }
//
//        for (Node child : parent.children) {
//            getMax(child, mover);
//        }
//
//    }
//
//    public int getMin() {
//        Mover mover = new Mover();
//        mover.moverInt = this.root.data;
//        getMin(this.root, mover);
//        return mover.moverInt;
//    }
//
//    private void getMin(Node parent, Mover mover) {
//        int content = parent.data;
//        if (content < mover.moverInt) {
//            mover.moverInt = content;
//        }
//
//        for (Node child : parent.children) {
//            getMin(child, mover);
//        }
//
//    }
//
//    public boolean contains(int item) {
//        Mover mover = new Mover();
//        mover.moverInt = item;
//        mover.moverBoolean = false;
//        contains(this.root, mover);
//        return mover.moverBoolean;
//    }
//
//    private void contains(Node parent, Mover mover) {
//
//        mover.moverBoolean = parent.data == mover.moverInt;
//
//        if (mover.moverBoolean) return;
//
//        for (Node child : parent.children) {
//            contains(child, mover);
//        }
//
//    }
//
//    public int height() {
//        Mover mover = new Mover();
//        mover.moverInt = 0;
//        height(this.root, 0, mover);
//        return mover.moverInt + 1;
//    }
//
//    private void height(Node parent, int branchHeight, Mover mover) {
//
//        if (parent.children.isEmpty()) {
//            mover.moverInt = branchHeight > mover.moverInt ? branchHeight : mover.moverInt;
//        }
//
//        for (Node child : parent.children) {
//            height(child, branchHeight + 1, mover);
//        }
//
//    }
//

    public int getMax() {
        return getMax(this.root, this.root).data;
    }

    private Node getMax(Node parent, Node globalMax) {

        Node localMax = globalMax;

        if (parent.data > localMax.data) {
            localMax = parent;
        }

        Node childMax = new Node();

        for (Node child : parent.children) {
            childMax = getMax(child, localMax);
        }

        if (childMax.data > localMax.data) {
            return childMax;
        } else return localMax;

    }

    public boolean contains(int item) {
        return contains(this.root, item);
    }

    private boolean contains(Node parent, int item) {

        Boolean answer = false;

        if (parent.data == item) {
            return true;
        }

        for (Node child : parent.children) {
            answer = answer || contains(child, item);
        }

        return answer;

    }

    public int height() {
        return height(this.root);
    }

    private int height(Node parent) {

        int height = 1;

        int maxChildHeight = 0;

        for (Node child : parent.children) {
            int x = height(child);
            if (x > maxChildHeight) {
                maxChildHeight = x;
            }
        }

        return height + maxChildHeight;
    }

    public void mirror() {
        mirror(this.root);
    }

    private void mirror(Node parent) {

        Collections.reverse(parent.children);

        for (Node child : parent.children) {
            mirror(child);
        }

    }

}
