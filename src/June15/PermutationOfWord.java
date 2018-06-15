package June15;

// This finds all the permutations of a string

import java.util.ArrayList;

public class PermutationOfWord {

    private static String userInput;

    public static void main(String args[]) {

        userInput = "abcd";

        System.out.println(getPermutations(userInput));

    }

    private static ArrayList<String> getPermutations(String input) {

        ArrayList<String> myResult = new ArrayList<>();

        // Base Condition
        if (input.length() == 0) {
            myResult.add("");
            return myResult;
        }

        // set Aside leading character
        char setAside = input.charAt(0);

        // run recursive method on remaining string
        ArrayList<String> recursionResult = getPermutations(input.substring(1));

        // pick one element of the recursionResult
        for (String x : recursionResult) {

            for (int counter = 0; counter <= x.length(); counter++) {

                // first break the string x into 2 parts
                String part1 = x.substring(0, counter);
                String part2 = x.substring(counter);

                // concatenate the string with setAside at counter position
                String concat = part1 + setAside + part2;

                myResult.add(concat);

            }
        }

        return myResult;

    }

}
