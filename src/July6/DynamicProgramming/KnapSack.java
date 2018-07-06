package July6.DynamicProgramming;

public class KnapSack {

    public static void main(String[] args) {

        int[] weight = {1, 3, 4, 5};
        int[] price = {1, 4, 5, 7};
        int capacity = 7;
        System.out.println(TopDown(0, capacity, price, weight, new int[price.length + 1][capacity + 1]));
        System.out.println(BottomUp(weight, price, capacity));

    }

    private static int TopDown(int vIndex, int capacity, int[] price, int[] weight, int[][] storage) {

        if (vIndex == price.length) {
            return 0;
        }

        int dui = storage[vIndex][capacity];
        if (dui != 0) return dui;

        int include = Integer.MIN_VALUE;
        if (weight[vIndex] <= capacity) {
            include = TopDown(vIndex + 1, capacity - weight[vIndex], price, weight, storage) + price[vIndex];
        }

        int exclude = TopDown(vIndex + 1, capacity, price, weight, storage);

        int profit = Math.max(include, exclude);

        storage[vIndex][capacity] = profit;
        return profit;

    }

    private static int BottomUp(int[] weight, int[] price, int capacity) {

        int nr = price.length + 1;
        int nc = capacity + 1;

        int[][] storage = new int[nr][nc];

        for (int row = 0; row < nr; row++) {
            for (int col = 0; col < nc; col++) {
                if (row != 0 && col != 0) {

                    int include = Integer.MIN_VALUE;
                    if (weight[row - 1] <= col) include = price[row - 1] + storage[row - 1][col - weight[row - 1]];

                    int exclude = storage[row - 1][col];

                    storage[row][col] = Math.max(include, exclude);

                }
            }
        }

        return storage[nr - 1][nc - 1];

    }

}
