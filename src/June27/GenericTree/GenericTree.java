package June27.GenericTree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
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
        return getMax(this.root);
    }

    private int getMax(Node parent) {

        int max = parent.data;

        for (Node child : parent.children) {
            int cm = getMax(child);
            if (cm > max) {
                max = cm;
            }
        }

        return max;

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

        int maxChildHeight = -1;

        for (Node child : parent.children) {
            int x = height(child);
            if (x > maxChildHeight) {
                maxChildHeight = x;
            }
        }

        return maxChildHeight + 1;
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

    public void printRightmost() {
        Node superNode = new Node();
        superNode.children.add(this.root);
        printRightmost(superNode);
    }

    private void printRightmost(Node parent) {

        if (parent.children.size() > 0) {
            System.out.println(parent.children.get(parent.children.size() - 1).data + "");

            for (Node child : parent.children) {
                printRightmost(child);
            }
        }
    }

    // In pre-order traversal the parent gets printed before the child
    public void preOrderTraversal() {
        System.out.println("-------------");
        preOrderTraversal(this.root);
        System.out.println();
        System.out.println("-------------");
    }

    private void preOrderTraversal(Node parent) {

        System.out.print(parent.data + "\t");

        for (Node child : parent.children) {
            preOrderTraversal(child);
        }

    }

    // In post-order traversal the children get printed before the parent
    public void postOrderTraversal() {
        System.out.println("-------------");
        postOrderTraversal(this.root);
        System.out.println();
        System.out.println("-------------");
    }

    private void postOrderTraversal(Node parent) {

        for (Node child : parent.children) {
            postOrderTraversal(child);
        }

        System.out.print(parent.data + "\t");

    }

    public void printLevel(int level) {

        for (Node node : getLevel(level)) {
            System.out.print(node.data + "\t");
        }

    }

    public void traverseByLevelRecursive() {
        traverseByLevelRecursive(this.root);
    }

    private void traverseByLevelRecursive(Node parent) {
        for (int i = 0; i < getSize(); i++) {
            ArrayList<Node> arrayList = getLevel(i);
            for (Node x : arrayList) {
                System.out.print(x.data + "\t");
            }
        }
    }

    public void traverseByLevelIterative() {
        traverseByLevelIterative(this.root);
    }

    private void traverseByLevelIterative(Node parent) {

        LinkedList<Node> queue = new LinkedList<>();
        queue.addLast(parent);

        while (!queue.isEmpty()) {

            Node removedNode = queue.getFirst();

            for (Node child : removedNode.children) {
                queue.addFirst(child);
            }

            System.out.print(removedNode.data + "\t");

        }
    }

    private ArrayList<Node> getLevel(int level) {
        ArrayList<Node> result = new ArrayList<>();
        Node superNode = new Node();
        superNode.children.add(this.root);
        getLevel(superNode, 0, level, result);
        return result;
    }

    private void getLevel(Node parent, int currLevel, int targetLevel, ArrayList<Node> result) {

        if (currLevel == targetLevel) {
            result.addAll(parent.children);
            return;
        }

        for (Node child : parent.children) {
            getLevel(child, currLevel + 1, targetLevel, result);
        }

    }

}
