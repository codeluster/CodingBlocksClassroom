package June24.LinkedList;

public class LinkedListClient {

    public static void main(String[] args) throws Exception {

        LinkedList linkedList = new LinkedList();

        linkedList.addFirst(6);
        linkedList.addItemAt(1, 9);
        linkedList.addLast(8);
        linkedList.display();
        linkedList.removeFirst();
        linkedList.display();

        linkedList.removeFirst();
        linkedList.display();

        System.out.println(linkedList.getSize());

        linkedList.removeLast();
    }

}
