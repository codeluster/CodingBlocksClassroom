package June15;

import java.util.ArrayList;

public class SubsequenesWithASCII {

    public static void main(String[] args) {

        System.out.println(getSS("abc"));

    }


    private static ArrayList<String> getSS(String str) {

        ArrayList<String> myResult = new ArrayList<>();

        if (str.length() == 0) {
            myResult.add("");
            return myResult;
        }

        char setAside = str.charAt(0);

        ArrayList<String> recursionResult = getSS(str.substring(1));

        for (String x : recursionResult) {

            myResult.add(x);
            myResult.add(setAside + x);
            myResult.add((int)setAside + x);

        }

        return myResult;

    }

}
