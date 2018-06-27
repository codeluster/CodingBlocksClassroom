package June27.GenericTree;

public class GenericTreeClient {

    public static void main(String[] oio) {

        GenericTree genericTree = new GenericTree("10 3 20 2 50 0 60 0 30 0 40 1 70 0");
        genericTree.display();
        System.out.println(genericTree.getSize());
        System.out.println(genericTree.getMax());
        System.out.println(genericTree.contains(70));
        System.out.println(genericTree.contains(15));
        System.out.println(genericTree.height());
        genericTree.mirror();
        genericTree.display();
    }

}
