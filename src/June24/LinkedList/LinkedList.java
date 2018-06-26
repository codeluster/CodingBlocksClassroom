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

    public boolean isEmpty() {
        return this.size == 0;
    }

    public int getSize() {
        return this.size;
    }

    public int getItemAt(int index) throws Exception {
        if (this.size == 0) throw new Exception("The Linked List is Empty!");
        if (index < 0 || index >= this.size) throw new Exception("This index does not exist!");
        if (index == 0) return this.getFirst();
        if (index == this.size - 1) return this.getLast();
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

    public void RDI() throws Exception {

        int left = 0;
        int right = this.size - 1;

        while (left < right) {

            Node ln = getNodeAt(left);
            Node rn = getNodeAt(right);

            int temp = ln.data;
            ln.data = rn.data;
            rn.data = temp;

            left++;
            right--;
        }
    }

    public int getMideItem() {

        Node slow = this.head;
        Node fast = this.head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow.data;

    }

    public int getFromLast(int index) {

        Node slow = this.head;
        Node fast = this.head;

        //Move fast forward by index steps
        for (int i = 0; i < index; i++) {
            fast = fast.next;
        }

        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }

        return slow.data;

    }

    public void kReverse(int k) throws Exception {

        if (this.isEmpty()) throw new Exception("The Linked List is Empty!");

        LinkedList prev = null;
        LinkedList curr = null;

        while (this.size != 0) {

            curr = new LinkedList();

            for (int i = 0; i < k; i++) {
                curr.addFirst(this.removeFirst());

            }

            if (prev == null) {
                prev = curr;
            } else {
                prev.tail.next = curr.head;
                prev.tail = curr.tail;
                prev.size += curr.size;
            }

        }

        this.head = prev.head;
        this.tail = prev.tail;
        this.size = prev.size;

    }

    public void RPI() {

        Node prev = this.head;
        Node curr = this.head.next;

        while (curr != null) {

            Node ahead = curr.next;
            curr.next = prev;

            prev = curr;
            curr = ahead;

        }

        Node temp = this.head;
        this.head = this.tail;
        this.tail = temp;

        this.tail.next = null;

    }

    public void RPR() {
        RPR(this.head, this.head.next);

        Node temp = this.head;
        this.head = this.tail;
        this.tail = temp;

        this.tail.next = null;

    }

    private void RPR(Node prev, Node curr) {

        if (curr == null)
            return;

        RPR(curr, curr.next);

        curr.next = prev;
    }

    private class Mover {
        Node left;
    }

    public void RDR() {
        Mover mover = new Mover();
        mover.left = this.head;

        RDR(mover, this.head, 0);
    }

    private void RDR(Mover mover, Node right, int count) {

        if (right == null) {
            return;
        }

        RDR(mover, right.next, count + 1);

        if (count >= this.size / 2) {
            int temp = mover.left.data;
            mover.left.data = right.data;
            right.data = temp;
        }
        mover.left = mover.left.next;

    }

    public void fold() {

        Mover mover = new Mover();
        mover.left = this.head;

        fold(mover, this.head, 0);
    }

    private void fold(Mover mover, Node right, int count) {

        if (right == null) {
            return;
        }

        fold(mover, right.next, count + 1);

        if (count > size / 2) {
            Node temp = mover.left.next;
            mover.left.next = right;
            right.next = temp;
            mover.left = temp;
        }
        if (count == size / 2) {

            this.tail = right;
            this.tail.next = null;
        }

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
