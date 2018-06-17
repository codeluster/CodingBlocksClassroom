package June17;

import java.util.ArrayList;
import java.util.Scanner;

public class CoinToss {

    public static void main(String[] s) {

        int number_of_tosses = new Scanner(System.in).nextInt();

        System.out.println(possibleTosses(number_of_tosses));

    }

    private static ArrayList<String> possibleTosses(int tosses) {


        ArrayList<String> myResult = new ArrayList<>();

        if (tosses == 0) {

            myResult.add("");
            return myResult;

        }

        ArrayList<String> recursionResult = possibleTosses(tosses - 1);

        for (String x : recursionResult) {
            myResult.add("H" + x);
            myResult.add("T" + x);
        }

        return myResult;

    }

}
