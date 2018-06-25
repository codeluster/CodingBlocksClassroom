package June22.Queues;

public class QueueClient {

    public static void main(String[] esionf) throws Exception {

        Queue queue = new Queue(5);

        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.enqueue(40);
        queue.display();
        queue.enqueue(50);
        queue.dequeue();
        queue.enqueue(60);
        queue.display();
        System.out.println(queue.getSize());
        System.out.println(queue.getFront());
        System.out.println(queue.isEmpty());

    }

}
