package July1.HashMaps;

import java.util.ArrayList;
import java.util.HashMap;

public class IntersectionOfTwoArrays {

    public static void main(String[] args) {

        int[] a1 = {10, 20, 5, 30, 40, 30, 40, 5};
        int[] a2 = {5, 10, 10, 25, 30, 30, 40, 2};

        HashMap<Integer, Integer> array1 = new HashMap<>();
        HashMap<Integer, Integer> array2 = new HashMap<>();
        generateHashMap(array1, a1);
        generateHashMap(array2, a2);

        HashMap<Integer, Boolean> printed = new HashMap<>();
        HashMap<Integer, Integer> result = new HashMap<>();

        for (int x : a1) {
            if (!printed.containsKey(x) && array1.containsKey(x) && array2.containsKey(x)) {
                result.put(x, Math.min(array1.get(x), array2.get(x)));
                printed.put(x, true);
            }
        }

        ArrayList<Integer> arrayList = new ArrayList<>(result.keySet());

        for (Integer x : arrayList) {
            for (int i = 0; i < result.get(x); i++) {
                System.out.print(x + "\t");
            }
        }

    }

    private static void generateHashMap(HashMap hashMap, int[] array) {

        for (Integer x : array) {

            if (hashMap.containsKey(x)) {
                hashMap.put(x, (Integer) hashMap.get(x) + 1);
            } else {
                hashMap.put(x, 1);

            }

        }

    }

}
