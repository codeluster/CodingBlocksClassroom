package July3.DynamicProgramming;

import java.util.Scanner;

public class FibBottomUp {

    public static void main(String[] args) {
        System.out.println(getFib(new Scanner(System.in).nextInt()));
    }

    private static long getFib(int n) {

        long[] storage = new long[2];
        storage[0] = 0;
        storage[1] = 1;

        if (n == 0 || n == 1) return storage[n];

        for (int i = 1; i < n; i++) {
            long temp = storage[0] + storage[1];
            storage[0] = storage[1];
            storage[1] = temp;
        }

        return storage[1];

    }

}
