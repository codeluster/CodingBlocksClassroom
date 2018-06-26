package June26.DynamicDataStructures;

import June22.Queues.Queue;

public class DynamicQueue extends Queue {

    public DynamicQueue(int cap) {
        super(cap);
    }

    public DynamicQueue() {
        super(5);
    }

    @Override
    public void enqueue(int item) throws Exception {

        if (this.data.length == this.size) {

            int x = this.data.length;

            int[] newData = new int[x * 2];

            for (int i = 0; i < x; i++) {
                newData[i] = this.dequeue();
            }

            this.data = newData;
            this.front = 0;
            this.size = x;


        }

        super.enqueue(item);
    }
}
