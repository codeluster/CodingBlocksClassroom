package July4.DynamicProgramming;

public class WineProblem {

    public static void main(String[] args) {

        int[] prices = {2, 3, 5, 1, 4};
        int startIndex = 0;
        int endIndex = prices.length - 1;

        System.out.println(Recursion(prices, startIndex, endIndex));
        System.out.println(TopDown(prices, startIndex, endIndex));

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




        return table[0][0];

    }

}
