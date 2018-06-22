package June22;

import June19.Stack.Stack;

public class nextGreater {

    public static void main(String[] aribfe) throws Exception {

        Stack input = new Stack();
        input.push(2);
        input.push(5);
        input.push(13);
        input.push(1);
        input.push(6);
        input.push(25);

        getGreater(input, new Stack());

    }

    private static void getGreater(Stack s, Stack remaining) throws Exception {

        if (s.isEmpty()) {
            return;
        }

        int temp = s.pop();
        getGreater(s, remaining);
        Stack remaining2 = new Stack();
        while (!remaining.isEmpty()) {
            int fdio = remaining.pop();
            if (temp > fdio) {
                System.out.println("(" + temp + "," + fdio + ")");
            } else {
                remaining2.push(fdio);
            }
        }
        remaining = remaining2;


    }


}
