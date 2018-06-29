package June29.BinarySearchTree;

public class BinarySearchTreeClient {

    public static void main(String[] args) {

        int[] in = {10, 20, 30, 40, 50, 60, 70};

        BinarySearchTree binarySearchTree = new BinarySearchTree(in);
        binarySearchTree.display();

        binarySearchTree.printRange(0, 60);
        binarySearchTree.replaceWithSumOfLarger();
        binarySearchTree.display();
    }

}
