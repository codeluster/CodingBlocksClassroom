package June22.Stack;

import June19.Stack.Stack;

public class stackOps {

    public static void main(String[] args) throws Exception {

        Stack originalStack = new Stack();
        originalStack.push(10);
        originalStack.push(20);
        originalStack.push(30);
        originalStack.push(40);

        Stack helperStack = new Stack();

        /*displayReverse(originalStack);
        originalStack.display();*/

        actualReverse(originalStack, new Stack());
        originalStack.display();


    }

    private static void displayReverse(Stack s) throws Exception {

        if (s.isEmpty()) {
            return;
        }

        int temp = s.pop();
        displayReverse(s);
        System.out.println(temp);
        s.push(temp);

    }

    private static void actualReverse(Stack s, Stack helper) throws Exception {

        if (s.isEmpty()) {

            if (helper.isEmpty()) {
                return;
            }

            int tempH = helper.pop();
            actualReverse(s, helper);
            s.push(tempH);

            return;
        }

        int temp = s.pop();
        helper.push(temp);
        actualReverse(s, helper);

    }

}
