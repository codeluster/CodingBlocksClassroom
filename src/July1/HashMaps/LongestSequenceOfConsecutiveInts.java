package July1.HashMaps;

import java.util.HashMap;
import java.util.Set;

public class LongestSequenceOfConsecutiveInts {

    public static void main(String[] args) {

        int[] ndrio = {2, 12, 9, 16, 10, 3, 20, 25, 11, 1, 8, 6};

        printSeq(ndrio);
    }

    private static void printSeq(int[] array) {

        // The boolean attribute tells if a particular number is the start of a sequence
        HashMap<Integer, Boolean> hashMap = new HashMap<>();

        for (int i = 0; i < array.length; i++) {

            int val = array[i];

            if (hashMap.containsKey(val - 1)) {
                hashMap.put(val, false);
            } else hashMap.put(val, true);

            if (hashMap.containsKey(val + 1)) hashMap.put(val + 1, false);

        }

        Set<Integer> keys = hashMap.keySet();

        int maxSeqSize = 0;
        int maxSeqStarting = 0;

        for (Integer key : keys) {

            // If the key is start of longest sequence
            if (hashMap.get(key)) {

                int size = 0;
                int starting = key;

                while (hashMap.containsKey(key + size)) {
                    size++;
                }

                if (size >= maxSeqSize) {
                    maxSeqSize = size;
                    maxSeqStarting = starting;
                }

            }

        }

        for (int i = 0; i < maxSeqSize; i++) {
            System.out.println(maxSeqStarting + i);
        }

    }
}
