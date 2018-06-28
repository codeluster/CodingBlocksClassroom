package June27.OnlineLecture.BinaryTree;

public class BinaryTreeClient {

    public static void main(String[] args) {

        String dummyTree = "50 true 25 true 38 false true 48 true 10 false false true 45 true 85 false true 60 false";

        BinaryTree binaryTree = new BinaryTree(dummyTree);
        binaryTree.display();
        System.out.println(binaryTree.getHeight());
    }

}
