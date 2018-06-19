package June17.Recursion_Print;

public class CoinTossWithPrintApproach {

    public static void main(String[] s) {

        int numToss = 3;
        String initial_answer = "";

        calcWays(numToss, initial_answer);

    }

    private static int calcWays(int tosses_left, String answer) {

        if (tosses_left == 0) {
            System.out.println(answer);
            return 0;
        }

        calcWays(tosses_left - 1, "H" + answer);
        calcWays(tosses_left - 1, "T" + answer);

        return 0;
    }

}
