package June27.OnlineLecture.BinaryTree;

public class BinaryTreeClient {

    public static void main(String[] args) {

//          For testing purposes only
//        String dummyTree = "50 true 25 true 38 false true 48 true 10 false false true 45 true 85 false true 60 false";
//        String dummyTree = "10 true 20 true 40 true 60 true 90 false false false true 50 true 70 true 80 false false false true 30 false";
//        BinaryTree binaryTree = new BinaryTree(dummyTree);
//        BinaryTree binaryTree = new BinaryTree();
//        binaryTree.display();
//        System.out.println(binaryTree.getHeight());
//        System.out.println(binaryTree.contains(26));
//        System.out.println(binaryTree.diameterN2());
//        System.out.println(binaryTree.diameterN());
//        System.out.println(binaryTree.getMax());
//        System.out.println(binaryTree.getMin());
//        System.out.println(binaryTree.balanced());

//        int[] preOrder = {10, 20, 40, 50, 60, 70, 30};
//        int[] inOrder = {40, 20, 70, 60, 50, 10, 30};
//        BinaryTree binaryTree = new BinaryTree(preOrder, inOrder);

        BinaryTree binaryTree = new BinaryTree();
        binaryTree.display();
        binaryTree.largestBST();
    }

}
