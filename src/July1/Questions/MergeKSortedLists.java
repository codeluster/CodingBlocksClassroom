package July1.Questions;

import July1.Heap.Heap;

import java.util.ArrayList;

public class MergeKSortedLists {

    public static void main(String[] args) {

        ArrayList<ArrayList<Integer>> mList = new ArrayList<>();

        ArrayList<Integer> list1 = new ArrayList<>();
        list1.add(2);
        list1.add(3);
        list1.add(5);
        list1.add(10);
        list1.add(15);

        ArrayList<Integer> list2 = new ArrayList<>();
        list2.add(15);
        list2.add(100);
        list2.add(200);
        list2.add(300);

        ArrayList<Integer> list3 = new ArrayList<>();
        list3.add(6);
        list3.add(8);
        list3.add(9);
        list3.add(10);

        mList.add(list1);
        mList.add(list2);
        mList.add(list3);

        System.out.println(sorted(mList));

    }

    private static class Pair implements Comparable<Pair> {
        int data;
        int listNum;
        int elementIndex;

        public int compareTo(Pair o) {
            return o.data - this.data;
        }
    }

    private static ArrayList<Integer> sorted(ArrayList<ArrayList<Integer>> mList) {

        ArrayList<Integer> result = new ArrayList<>();

        Heap<Pair> heap = new Heap<>();

        //add first element of all lists
        for (int i = 0; i < mList.size(); i++) {
            Pair pair = new Pair();
            pair.data = mList.get(i).get(0);
            //System.out.println(pair.data);
            pair.elementIndex = 0;
            pair.listNum = i;
            heap.insert(pair);
        }

        while (heap.getSize() != 0) {

            Pair pair = heap.remove();
           // System.out.println(pair.data);
            result.add(pair.data);

            pair.elementIndex++;

            if (pair.elementIndex < mList.get(pair.listNum).size()) {
                pair.data = mList.get(pair.listNum).get(pair.elementIndex);
                heap.insert(pair);
            }

        }

        return result;
    }

}
