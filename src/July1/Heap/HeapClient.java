package July1.Heap;

public class HeapClient {

    public static void main(String[] args) {

        Heap heap = new Heap();

        heap.insert(10);
        heap.insert(24);
        heap.insert(5);
        heap.insert(13);
        heap.insert(1);

        heap.display();

        System.out.println(heap.getMin());

        System.out.println(heap.remove());
        System.out.println(heap.remove());
        System.out.println(heap.remove());
        System.out.println(heap.remove());
        System.out.println(heap.remove());

    }

}
