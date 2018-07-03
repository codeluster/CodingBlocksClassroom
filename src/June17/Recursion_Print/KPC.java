package June17.Recursion_Print;

import java.util.ArrayList;

public class KPC {

    public static void main(String[] args) {

        String question, answer;

        // Test case
        question = "145";
        answer = "";

        getCombinations(question, answer);

    }

    private static void getCombinations(String ques, String ans) {

        // base case
        if (ques.equals("")) {
            System.out.println(ans);
        } else {

            char firstInt = ques.charAt(0);
            ques = ques.substring(1);

            // Resolve leading digit with all posibilities
            for (Character x : getCharatersPossible(firstInt)) {
                getCombinations(ques, ans + x.toString());
            }
        }
    }

    private static ArrayList<Character> getCharatersPossible(char keypadIndex) {

        Character[] allChars = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's'};

        ArrayList<Character> result = new ArrayList<>();

        int indexFrom, indexTo;

        switch (keypadIndex) {

            case '1':

                indexFrom = 0;
                indexTo = indexFrom + 3;
                break;


            case '2':
                indexFrom = 3;
                indexTo = indexFrom + 3;
                break;

            case '3':
                indexFrom = 6;
                indexTo = indexFrom + 3;
                break;

            case '4':
                indexFrom = 9;
                indexTo = indexFrom + 2;
                break;

            case '5':
                indexFrom = 11;
                indexTo = indexFrom + 4;
                break;

            case '6':
                indexFrom = 15;
                indexTo = indexFrom + 4;
                break;


            default:
                indexFrom = 0;
                indexTo = 0;
                break;
        }

        for (int counter = indexFrom; counter < indexTo; counter++) {
            result.add(allChars[counter]);
        }

        return result;

    }

}
