package July1.Heap;

import java.util.ArrayList;

public class Heap {

    private ArrayList<Integer> data = new ArrayList<>();

    public int getSize() {
        return this.data.size();
    }

    public void display() {
        System.out.println(this.data);
    }

    public void insert(int item) {

        this.data.add(item);
        upheapify(this.data.size() - 1);

    }

    private void upheapify(int childIndex) {

        int childData = this.data.get(childIndex);
        int parentIndex = (childIndex - 1) / 2;
        int parenData = this.data.get(parentIndex);

        // At base case child's data == parent's data hence recursion terminates
        if (childData < parenData) {
            swap(parentIndex, childIndex);
            upheapify(parentIndex);
        }

    }

    private void swap(int index1, int index2) {

        int data1 = this.data.get(index1);
        int data2 = this.data.get(index2);

        this.data.set(index1, data2);
        this.data.set(index2, data1);

    }

    public int remove() {

        int returnValue = this.data.get(0);
        swap(0, this.data.size() - 1);
        this.data.remove(this.data.size() - 1);
        downheapify(0);
        return returnValue;
    }

    private void downheapify(int parentIndex) {

        int leftChIndex = (2 * parentIndex) + 1;
        int rightChIndex = leftChIndex + 1;

        int minIndex = parentIndex;

        if ((!(leftChIndex >= this.data.size())) && this.data.get(leftChIndex) < this.data.get(parentIndex)) {
            minIndex = leftChIndex;
        }
        if ((!(rightChIndex >= this.data.size())) && this.data.get(rightChIndex) < this.data.get(parentIndex)) {
            minIndex = rightChIndex;
        }

        if (minIndex != parentIndex) {
            swap(minIndex, parentIndex);
            downheapify(minIndex);
        }

    }

    public int getMin() {
        return this.data.get(0);
    }

}
