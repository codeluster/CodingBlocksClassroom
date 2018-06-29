package June29.BinarySearchTree;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 */

public class BinarySearchTreeClient {

    public static void main(String[] args) {

        int[] in = {10, 20, 30, 40, 50, 60, 70};

        BinarySearchTree bst = new BinarySearchTree(in);
        bst.display();
//
//        System.out.println(bst.find(10));
//        System.out.println(bst.max());
//        bst.add(55);
//        bst.display();
//
//        bst.remove(55);
//        bst.display();
//
//        bst.remove(80);
//        bst.display();

        bst.printRange(0, 60);
    }


}
