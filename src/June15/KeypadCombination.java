package June15;

// An arraylist containing all possible combinations when keypad is pressed

import java.util.ArrayList;

public class KeypadCombination {

    public static void main(String args[]) {

        ArrayList<Integer> userInput = new ArrayList<>();
        userInput.add(1);
        userInput.add(2);
        userInput.add(6);

        System.out.println(getString(userInput));

    }

    private static ArrayList<String> getString(ArrayList<Integer> input) {

        ArrayList<String> resultStringArray = new ArrayList<>();

        if (input.size() == 0) {

            resultStringArray.add("");

            return resultStringArray;

        }

        Integer setAside = input.get(0);

        input.remove(0);

        ArrayList<String> recursionResult = getString(input);

        ArrayList<Character> charsAtIndex = getCharatersPossible(setAside);

        for (int parentCounter = 0; parentCounter < charsAtIndex.size(); parentCounter++) {

            for (String x : recursionResult) {
                resultStringArray.add(charsAtIndex.get(parentCounter) + x);
            }
        }


        return resultStringArray;

    }

    private static ArrayList<Character> getCharatersPossible(int keypadIndex) {

        Character[] allChars = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's'};

        ArrayList<Character> result = new ArrayList<>();

        int indexFrom, indexTo;

        switch (keypadIndex) {

            case 1:

                indexFrom = 0;
                indexTo = indexFrom + 3;
                break;


            case 2:
                indexFrom = 3;
                indexTo = indexFrom + 3;
                break;

            case 3:
                indexFrom = 6;
                indexTo = indexFrom + 3;
                break;

            case 4:
                indexFrom = 9;
                indexTo = indexFrom + 2;
                break;

            case 5:
                indexFrom = 11;
                indexTo = indexFrom + 4;
                break;

            case 6:
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
