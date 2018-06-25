package June22.Stack;

import June19.Stack.Stack;

public class stockSpan {

    public static void main(String[] arhs) throws Exception {

        int[] prices = {1, 1, 34, 5, 3, 4, 5, 2};

        for (int k : getSpan(prices)) {

            System.out.print(k + "\t");

        }

    }

    private static int[] getSpan(int[] input) throws Exception {

        Stack prevHighIndex = new Stack();

        int[] spans = new int[input.length];

        prevHighIndex.push(0);
        spans[0] = 1;


        for (int i = 1; i < input.length; i++) {

            while (!prevHighIndex.isEmpty() && input[prevHighIndex.peek()] < input[i]) {
                prevHighIndex.pop();
            }

            if (prevHighIndex.isEmpty()) {
                spans[i] = i + 1;
            } else {
                spans[i] = i - prevHighIndex.peek();
            }

            prevHighIndex.push(i);

        }

        return spans;

    }

}
