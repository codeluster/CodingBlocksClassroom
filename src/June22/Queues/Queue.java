package June22.Queues;

public class Queue {

    protected int size = 0;
    protected int front = 0;
    protected int[] data;

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
        if (this.size == this.data.length) {
            throw new Exception("The queue is full!");
        }
        this.data[(this.front + size) % data.length] = item;
        this.size++;
    }

    public int dequeue() throws Exception {
        if (this.size == 0) throw new Exception("The queue is empty!");
        int returnValue = this.data[this.front];
        this.front = (this.front + 1) % this.data.length;
        this.size--;
        return returnValue;
    }

    public int getFront() throws Exception {
        if (this.size == 0) throw new Exception("The queue is empty!");
        return this.data[this.front];
    }

    public void display() {
        System.out.println("--------------");
        for (int i = 0; i < this.size; i++) {
            System.out.print(this.data[(i + this.front) % this.data.length] + " ");
        }
        System.out.println();
        System.out.println("--------------");
    }

}
