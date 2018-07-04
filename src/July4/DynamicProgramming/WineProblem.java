package July4.DynamicProgramming;

public class WineProblem {

    public static void main(String[] args) {

        int[] prices = {2, 3, 5, 1, 4};
        int startIndex = 0;
        int endIndex = prices.length - 1;

//        System.out.println(Recursion(prices, startIndex, endIndex));
//        System.out.println(TopDown(prices, startIndex, endIndex));
        System.out.println(BottomUp(prices));

    }

    private static int Recursion(int[] prices, int startIndex, int endIndex) {

        int year = prices.length - (endIndex - startIndex);

        if (startIndex == endIndex) return prices[startIndex] * year;

        return Math.max((Recursion(prices, startIndex + 1, endIndex) + prices[startIndex] * year), (Recursion(prices, startIndex, endIndex - 1) + prices[endIndex] * year));

    }

    private static int TopDown(int[] prices, int startIndex, int endIndex) {

        int year = prices.length - (endIndex - startIndex);

        if (startIndex == endIndex) return prices[startIndex] * year;

        int n = prices.length;
        int[][] table = new int[n][n];

        if (table[startIndex][endIndex] != 0) {
            return table[startIndex][endIndex] * year;
        }

        int firstWine = TopDown(prices, startIndex + 1, endIndex) + prices[startIndex] * year;
        int lastWine = TopDown(prices, startIndex, endIndex - 1) + prices[endIndex] * year;

        int max = Math.max(firstWine, lastWine);

        table[startIndex][endIndex] = max;
        return max;

    }

    private static int BottomUp(int[] prices) {

        int n = prices.length;

        int[][] table = new int[n][n];

        for (int slider = 1; slider <= n; slider++) {

            for (int startIndex = 0; startIndex <= n - slider; startIndex++) {

                int endIndex = startIndex + slider - 1;

                int year = prices.length - (endIndex - startIndex);

                if (startIndex == endIndex) {

                    table[startIndex][endIndex] = prices[startIndex] * year;

                } else {
                    int firstWine = table[startIndex + 1][endIndex] + (prices[startIndex] * year);
                    int lastWine = table[startIndex][endIndex - 1] + (prices[endIndex] * year);

                    int max = Math.max(firstWine, lastWine);

                    table[startIndex][endIndex] = max;

                }

            }

        }

//        For debugging purpose
//        prints the table

        for (int[] x : table) {
            for (int y : x) {
                System.out.print(y + "\t");
            }
            System.out.println();
        }


        return table[0][n - 1];

    }

}
