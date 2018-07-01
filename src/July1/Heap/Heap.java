package July1.Heap;

import java.util.ArrayList;

public class Heap<J extends Comparable<J>> {

    private ArrayList<J> data = new ArrayList<>();

    public int getSize() {
        return this.data.size();
    }

    public void display() {
        System.out.println(this.data);
    }

    public void insert(J item) {

        if (this.data.contains(item)) {
            return;
        }

        this.data.add(item);
        upheapify(this.data.size() - 1);

    }

    private void upheapify(int childIndex) {

        J childData = this.data.get(childIndex);
        int parentIndex = (childIndex - 1) / 2;
        J parenData = this.data.get(parentIndex);

        // At base case child's data == parent's data hence recursion terminates
        if (isLarger(parenData, childData)) {
            swap(parentIndex, childIndex);
            upheapify(parentIndex);
        }

    }

    private void swap(int index1, int index2) {

        J data1 = this.data.get(index1);
        J data2 = this.data.get(index2);

        this.data.set(index1, data2);
        this.data.set(index2, data1);

    }

    public J remove() {

        J returnValue = this.data.get(0);
        swap(0, this.data.size() - 1);
        this.data.remove(this.data.size() - 1);
        downheapify(0);
        return returnValue;
    }

    private void downheapify(int parentIndex) {

        int leftChIndex = (2 * parentIndex) + 1;
        int rightChIndex = leftChIndex + 1;

        int minIndex = parentIndex;

        if ((!(leftChIndex >= this.data.size())) && isLarger(this.data.get(minIndex), this.data.get(leftChIndex))) {
            minIndex = leftChIndex;
        }
        if ((!(rightChIndex >= this.data.size())) && isLarger(this.data.get(minIndex), this.data.get(rightChIndex))) {
            minIndex = rightChIndex;
        }

        if (minIndex != parentIndex) {
            swap(minIndex, parentIndex);
            downheapify(minIndex);
        }

    }

    public J getMin() {
        return this.data.get(0);
    }

    private boolean isLarger(J obj1, J obj2) {
        return obj1.compareTo(obj2) < 0;
    }

}
