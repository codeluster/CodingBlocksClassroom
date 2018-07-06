package July6.DynamicProgramming;

public class CuttingProblem {

    public static void main(String[] P90pj) {

        int[] options = {0, 1, 2, 3, 4, 5, 6, 7, 8};
        int[] price = {0, 3, 5, 8, 9, 10, 17, 17, 20};

        System.out.println(TopDown(price.length - 1, new int[price.length], price));
        System.out.println(BottomUp2D(options, price));
        System.out.println(BottomUp1D(price));

    }

    private static int TopDown(int length, int[] storage, int[] prices) {

        if (length == 0) return 0;
        if (storage[length] != 0) return storage[length];

        int MAX = prices[length];

        int left = 1;
        int right = length - 1;

        while (left <= right) {

            int front = TopDown(left, storage, prices);
            int back = TopDown(right, storage, prices);

            front += back;
            MAX = front > MAX ? front : MAX;

            left++;
            right--;

        }

        storage[length] = MAX;
        return MAX;

    }

    private static int BottomUp2D(int[] lOptions, int[] price) {

        int N = lOptions.length;

        int[][] storage = new int[N][N];

        for (int row = 0; row < N; row++) {
            for (int col = 0; col < N; col++) {
                if (row != 0 && col != 0) {

                    int include = Integer.MIN_VALUE;
                    if (lOptions[row - 1] <= col) include = price[row - 1] + storage[row][col - lOptions[row - 1]];

                    int exclude = storage[row - 1][col];

                    storage[row][col] = Math.max(include, exclude);

                }
            }
        }

        return storage[N - 1][N - 1];

    }

    // Doesn't work
    private static int BottomUp1D(int[] prices) {

        int[] storage = new int[prices.length];
        int length = prices.length - 1;
        storage[0] = prices[0];

        for (int i = 1; i < storage.length; i++) {

//            int include;
//
//            if (i > (length - i)) {
//                include = prices[i] + prices[length - i];
//            } else {
//                include = prices[i] + prices[i - 1];
//            }

//            int include = prices[i];

//            int exclude = storage[i - 1] + storage[1];

            int max = Integer.MIN_VALUE;

            int a = i, b = 0;

            while (a > b) {

                int df = storage[a - 1] + storage[b];
                max = Math.max(max, df);
                a--;
                b++;
            }

            storage[i] = max;

        }

        return storage[prices.length - 1];

    }
}
