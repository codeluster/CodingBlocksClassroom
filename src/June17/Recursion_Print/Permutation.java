package June17.Recursion_Print;

public class Permutation {

    public static void main(String[] s) {

        getPerms("a", "");

    }

    private static void getPerms(String question, String answer) {

        if (question.length() == 0) {
            System.out.println(answer);
            return;
        }

        for (int i = 0; i < question.length(); i++) {

            char first = question.charAt(i);
            String rem = question.substring(0, i) + question.substring(i + 1);
            getPerms(rem, answer + first);

        }

    }

}
