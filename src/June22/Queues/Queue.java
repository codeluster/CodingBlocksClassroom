package June22.Queues;

public class Queue {

    private int size = 0;
    private int front = 0;
    private int[] data;

    public Queue(int capacity) {
        data = new int[capacity];
    }

    public int getSize() {
        return this.size;
    }

    public boolean isEmpty() {
        return getSize() == 0;
    }

    public void enqueue(int item) throws Exception {

        if (size == data.length) {
            throw new Exception("The queue is full!");
        }

        data[(this.front + size) % data.length] = item;
        size++;
    }

    public int dequeue() throws Exception {

        if (size == 0) {
            throw new Exception("The queue is empty!");
        }

        int returnValue = data[this.front];
        this.front++;
        size--;
        return returnValue;

    }

    public int getFront() throws Exception {
        if (size == 0) {
            throw new Exception("The queue is empty!");
        }
        return data[this.front];
    }

    public void display() {

        System.out.println("--------------");

        for (int i = 0; i < size; i++) {

            System.out.print(data[(i + this.front) % this.data.length] + " ");

        }

        System.out.println();
        System.out.println("--------------");

    }

}
