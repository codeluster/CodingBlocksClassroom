package June26.LinkedListRevOps;

import June24.LinkedList.LinkedList;

public class LinkedListClient {

    public static void main(String[] args) throws Exception {

        LinkedList linkedList = new LinkedList();

        linkedList.addLast(10);
        linkedList.addLast(20);
        linkedList.addLast(30);
        linkedList.addLast(40);
        linkedList.addLast(50);
        linkedList.addLast(60);
        linkedList.addLast(70);
        linkedList.addLast(80);
        linkedList.addLast(90);
        linkedList.display();
        linkedList.kReverse(3);
        linkedList.display();

    }

}
