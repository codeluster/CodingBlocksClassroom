package June17.Recursion_Print;

// Since the previous approach consumes a lot of memory this question reduces the problem instad of building on the answer

public class Subsequences {

    public static void main(String[] sfji) {

        getSubSequences("abcd", "");

    }

    private static void getSubSequences(String question, String answer) {

        if (question.equals("")) {
            System.out.println(answer);
            return;
        }

        char first = question.charAt(0);
        question = question.substring(1);

        getSubSequences(question, answer);
        getSubSequences(question, first + answer);

    }

}
