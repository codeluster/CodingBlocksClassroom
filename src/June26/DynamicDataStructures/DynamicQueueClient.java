package June26.DynamicDataStructures;

public class DynamicQueueClient {

    public static void main(String[] args) throws Exception {

        DynamicQueue queue = new DynamicQueue();

        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.enqueue(40);
        queue.enqueue(50);
        queue.enqueue(60);

        queue.display();

    }

}
