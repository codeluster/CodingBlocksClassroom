package June15;

// To find all the paths that lead to 10 when a die is thrown
// Possible moves are from 1 to 6

import java.util.ArrayList;

public class BoardPath {

    public static void main(String[] args) {

        System.out.println(getMoves(0, 10));

    }

    private static ArrayList<String> getMoves(int startingPosition, int finalPosition) {

        ArrayList<String> myResult = new ArrayList<>();
        ArrayList<String> recursionResult = new ArrayList<>();

        // base case
        if (startingPosition == finalPosition) {

            myResult.add("");

        } else {

            for (int dice = 1; dice <= 6 && (dice + startingPosition <= finalPosition); dice++) {

                recursionResult = getMoves(startingPosition + dice, finalPosition);

                for (String x : recursionResult) {

                    myResult.add(dice + x);

                }

            }

        }

        return myResult;

    }

}
