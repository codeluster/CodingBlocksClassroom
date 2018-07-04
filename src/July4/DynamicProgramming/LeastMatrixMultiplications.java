package July4.DynamicProgramming;

public class LeastMatrixMultiplications {

    public static void main(String[] args) {

        int[] input = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        long start = System.currentTimeMillis();

        System.out.println(Recursion(0, input.length - 1, input));
        System.out.println(TopDown(0, input.length - 1, input, new int[input.length][input.length]));
        System.out.println(BottomUp(input));

        System.out.println(System.currentTimeMillis() - start);
    }

    private static int Recursion(int startIndex, int endIndex, int[] input) {

        if (startIndex + 1 == endIndex) return 0;

        int min = Integer.MAX_VALUE;

        for (int k = startIndex + 1; k < endIndex; k++) {

            int fp = Recursion(startIndex, k, input);
            int sp = Recursion(k, endIndex, input);
            int sw = input[startIndex] * input[k] * input[endIndex] + fp + sp;

            if (sw < min) {
                min = sw;
            }

        }

        return min;

    }

    private static int TopDown(int startIndex, int endIndex, int[] input, int[][] storage) {

        if (startIndex + 1 == endIndex) return 0;

        if (storage[startIndex][endIndex] != 0) return storage[startIndex][endIndex];

        int min = Integer.MAX_VALUE;

        for (int k = startIndex + 1; k < endIndex; k++) {

            int fp = TopDown(startIndex, k, input, storage);
            int sp = TopDown(k, endIndex, input, storage);
            int sw = input[startIndex] * input[k] * input[endIndex] + fp + sp;

            if (sw < min) {
                min = sw;
            }

        }

        storage[startIndex][endIndex] = min;
        return min;

    }

    private static int BottomUp(int[] input) {

        int n = input.length;
        int[][] storage = new int[n][n];

        for (int slide = 1; slide < n - 1; slide++) {

            for (int startIndex = 0; startIndex < n - slide - 1; startIndex++) {

                int endIndex = startIndex + slide + 1;

                //for a particular startIndex and endIndex
                int min = Integer.MAX_VALUE;

                for (int k = startIndex + 1; k < endIndex; k++) {

                    int fp = storage[startIndex][k];
                    int sp = storage[k][endIndex];
                    int sw = (input[startIndex] * input[k] * input[endIndex]) + fp + sp;

                    if (sw < min) {
                        min = sw;
                    }

                }

                storage[startIndex][endIndex] = min;

            }

        }

        return storage[0][n - 1];
    }

}
