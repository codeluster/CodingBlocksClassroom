package June24.LinkedList;

public class LinkedList {

    private class Node {

        int data;
        Node next;

    }

    private Node head;
    private Node tail;
    private int size;

    public int getFirst() throws Exception {
        if (this.size == 0) throw new Exception("The Linked List is Empty!");
        return this.head.data;
    }

    public int getLast() throws Exception {
        if (this.size == 0) throw new Exception("The Linked List is Empty!");
        return this.tail.data;
    }

    public int getSize() {
        return this.size;
    }

    public int getItemAt(int index) throws Exception {
        if (this.size == 0) throw new Exception("The Linked List is Empty!");
        if (index < 0 || index >= this.size) throw new Exception("This index does not exist!");
        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp.data;
    }

    private Node getNodeAt(int index) throws Exception {
        if (this.size == 0) throw new Exception("The Linked List is Empty!");
        if (index < 0 || index >= this.size) throw new Exception("This index does not exist!");
        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp;
    }

    public void display() throws Exception {

        if (this.size == 0) throw new Exception("The Linked List is Empty!");

        Node temp = this.head;

        System.out.println("------------");

        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }

        System.out.println();
        System.out.println("------------");

    }

    public void addFirst(int item) {
        Node node = new Node();
        node.data = item;
        node.next = this.head;
        this.head = node;
        if (this.size == 0) this.tail = node;
        this.size++;
    }

    public void addLast(int item) {
        Node temp = new Node();
        temp.data = item;
        temp.next = null;

        if (this.size == 0) this.head = temp;
        if (this.size > 0) this.tail.next = temp;

        this.tail = temp;
        this.size++;
    }

    public void addItemAt(int index, int item) throws Exception {

        if (index < 0 || index > size) throw new Exception("This index in not valid");

        if (index == 0) {
            addFirst(item);
        } else if (index == size) {
            addLast(item);
        } else {
            Node node = new Node();
            node.data = item;

            Node previous = getNodeAt(index - 1);
            node.next = previous.next;
            previous.next = node;

            this.size++;
        }
    }

    public int removeFirst() throws Exception {

        if (this.size == 0) throw new Exception("The Linked List is Empty!");

        if (this.size == 1) {
            //this.head = null;
            this.tail = null;
        }

        int returnValue = this.head.data;
        this.head = this.head.next;
        this.size--;
        return returnValue;
    }

    public int removeLast() throws Exception {

        if (this.size == 0) throw new Exception("The Linked List is Empty!");

        if (this.size == 1) return removeFirst();

        Node tailNode = this.tail;
        int returnValue = tailNode.data;
        Node previous = getNodeAt(size - 2);
        previous.next = null;
        this.size--;

        return returnValue;
    }

    public int removeItemAt(int index) throws Exception {
        if (index < 0 || index >= size) throw new Exception(("This index in not valid"));
        else if (index == 0) return removeFirst();
        else if (index == size - 1) return removeLast();

        Node previous = getNodeAt(index - 1);
        Node node = previous.next;
        previous.next = node.next;

        this.size--;
        return node.data;

    }

}
