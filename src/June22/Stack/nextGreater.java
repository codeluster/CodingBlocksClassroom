package June22.Stack;

import June19.Stack.Stack;

public class nextGreater {

    public static void main(String[] args) throws Exception {

        int[] input = {5, 6, 10, 30, 40};
        xNextGreater(input);

    }

    // My attempt
    private static void mNextGreater(int[] input) throws Exception {

        Stack stack = new Stack();

        stack.push(input[0]);

        Stack stack1 = new Stack();

        for (int i = 1; i < input.length; i++) {

            if (i == (input.length - 1)) {
                stack.push(input[i]);
                while (!stack.isEmpty()) {
                    System.out.println("(" + stack.pop() + ",-1)");
                }
            }
            while (!stack.isEmpty()) {
                if (stack.peek() < input[i]) {
                    System.out.println("(" + stack.pop() + "," + input[i] + ")");
                } else {
                    stack1.push(stack.pop());
                }
            }
            stack = stack1;
            stack.push(input[i]);
        }

    }

    //Actual Solution
    private static void xNextGreater(int[] input) throws Exception {

        Stack s = new Stack();

        for (int num : input) {

            while (!s.isEmpty() && s.peek() < num) {
                System.out.println("(" + s.pop() + "," + num + ")");
            }

            s.push(num);

        }

        while (!s.isEmpty()) {
            System.out.println("(" + s.pop() + ",-1)");
        }

    }
}
