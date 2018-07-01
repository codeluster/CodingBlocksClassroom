package June27.OnlineLecture.BinaryTree;

import java.nio.charset.IllegalCharsetNameException;
import java.util.Scanner;

// A binary tree can have 0, 1 or 2 children.
public class BinaryTree {

    private class Node {
        int data;
        // Since a binary tree can only have max two children instead of an array list of nodes
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

    public BinaryTree(int[] preOrder, int[] inOrder) {

        this.root = construct(0, preOrder.length - 1, 0, inOrder.length - 1, preOrder, inOrder);

    }

    private Node construct(int pLow, int pHigh, int iLow, int iHigh, int[] pOrd, int[] iOrd) {

        if (pLow > pHigh) return null;

        Node node = new Node();

        int p0 = pOrd[pLow];

        node.data = p0;

        int index = -1;

        for (int i = iLow; i <= iHigh; i++) {

            if (iOrd[i] == p0) {

                index = i;
                break;

            }

        }

        int consec = index - iLow;

        node.leftChild = construct(pLow + 1, pLow + consec, iLow, iLow + index - 1, pOrd, iOrd);
        node.rightChild = construct(pLow + consec + 1, pHigh, index + 1, iHigh, pOrd, iOrd);

        return node;
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
        return getHeight(this.root);
    }

    private int getHeight(Node node) {
        return getHp1(node) - 1;
    }

    private int getHp1(Node parent) {

        if (parent == null) return 0;

        int height = 1;

        int lHeight = getHp1(parent.leftChild);
        int rHeight = getHp1(parent.rightChild);

        int maxChildHeight = Math.max(lHeight, rHeight);

        return height + maxChildHeight;

    }

    public int getMax() {
        return getMax(this.root);
    }

    private int getMax(Node parent) {

        if (parent == null) {
            return Integer.MIN_VALUE;
        }
        return Math.max(parent.data, Math.max(getMax(parent.leftChild), getMax(parent.rightChild)));
    }

    public int getMin() {
        return getMin(this.root);
    }

    private int getMin(Node parent) {

        if (parent == null) {
            return Integer.MAX_VALUE;
        }
        return Math.min(parent.data, Math.min(getMin(parent.leftChild), getMin(parent.rightChild)));
    }

    public boolean contains(int item) {
        return contains(this.root, item);
    }

    private boolean contains(Node parent, int item) {

        if (parent == null) {
            return false;
        }

        if (parent.data == item) {
            return true;
        }

        return contains(parent.leftChild, item) || contains(parent.rightChild, item);

    }

//    public void printIsNodeBalanced() {
//
//        printIsNodeBalanced(this.root);
//
//    }
//
//    private void printIsNodeBalanced(Node node) {
//
//        if (node == null) return;
//
//        System.out.println(node.data + "\t" + isNodeBalancedBool(node));
//
//        printIsNodeBalanced(node.leftChild);
//        printIsNodeBalanced(node.rightChild);
//
//    }
//
//    private boolean isNodeBalancedBool(Node node) {
//
//        int balancingFactor = isNodeBalancedInt(node);
//        return (balancingFactor == -1 || balancingFactor == 0 || balancingFactor == 1);
//
//    }
//
//    private int isNodeBalancedInt(Node parent) {
//
//        if (parent == null) return 0;
//
//        int lHeight = getHeight(parent.leftChild);
//        int rHeight = getHeight(parent.rightChild);
//
//        return lHeight - rHeight;
//
//    }

//     Diameter is the largest distance between any two nodes in the tree.

    public int diameterN2() {
        return diameterN2(this.root);
    }

//     Complexity is N^2
//     Considers three cases in which the max dia is found in left branch,
//     max dia is in right branch or the max dia involves the parent node
//     which is why +2 is added in sum of heights

    private int diameterN2(Node parent) {

        if (parent == null) return 0;

        int leftDia = diameterN2(parent.leftChild);
        int rightDia = diameterN2(parent.rightChild);

        int selfInv = getHeight(parent.leftChild) + getHeight(parent.rightChild) + 2;

        return Math.max(selfInv, Math.max(leftDia, rightDia));

    }

    public int diameterN() {
        return diameterN(this.root).diameter;
    }

    private class Pair {
        int diameter;
        int height;
    }

    private Pair diameterN(Node parent) {

        if (parent == null) {
            Pair basePair = new Pair();
            basePair.diameter = 0;
            basePair.height = getHeight(parent);
            return basePair;
        }

        Pair leftPair = diameterN(parent.leftChild);
        Pair rightPair = diameterN(parent.rightChild);

        Pair pair = new Pair();
        pair.height = Math.max(leftPair.height, rightPair.height) + 1;

        int selfPart = leftPair.height + rightPair.height + 2;
        pair.diameter = Math.max(selfPart, Math.max(leftPair.diameter, rightPair.diameter));

        return pair;

    }

    private class BalPair {
        boolean isBalanced;
        int height;
    }

    public boolean balanced() {
        return this.balanced(this.root).isBalanced;
    }

    private BalPair balanced(Node parent) {

        if (parent == null) {
            BalPair pair = new BalPair();
            pair.height = -1;
            pair.isBalanced = true;
            return pair;
        }

        BalPair left = balanced(parent.leftChild);
        BalPair right = balanced(parent.rightChild);

        BalPair pair = new BalPair();
        pair.height = Math.max(left.height, right.height) + 1;

        int bal = left.height - right.height;

        if (left.isBalanced && right.isBalanced && bal > -2 && bal < 2) {
            pair.isBalanced = true;
        } else pair.isBalanced = false;

        return pair;
    }

    private class BSTPair {

        Node largestBSTRoot = null;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int size = 0;
        boolean isBST = true;

    }

    public void largestBST() {
        BSTPair bstPair = largestBST(this.root);
        System.out.println(bstPair.largestBSTRoot.data);
        System.out.println(bstPair.size);
    }

    private BSTPair largestBST(Node parent) {

        if (parent == null) return new BSTPair();

        BSTPair bstPair = new BSTPair();

        BSTPair left = largestBST(parent.leftChild);
        BSTPair right = largestBST(parent.rightChild);

        if (left.isBST && right.isBST && parent.data > left.max && parent.data < right.min) {

            bstPair.isBST = true;
            bstPair.max = Math.max(parent.data, Math.max(left.max, right.max));
            bstPair.min = Math.min(parent.data, Math.min(left.min, right.min));
            bstPair.largestBSTRoot = parent;
            bstPair.size = left.size + right.size + 1;

        } else {
            if (left.size >= right.size) {
                bstPair = left;
                bstPair.isBST = false;
                bstPair.isBST = false;
                bstPair.isBST = false;
            } else {
                bstPair = right;
                bstPair.isBST = false;
            }
        }

        return bstPair;

    }

}
