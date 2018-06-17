package June17;

import java.util.ArrayList;
import java.util.Scanner;

public class MazePath {

    public static void main(String[] raeeeeenog) {

        Scanner scanner = new Scanner(System.in);
        System.out.println(getPath(scanner.nextInt(), scanner.nextInt(), scanner.nextInt(), scanner.nextInt()));

    }

    private static ArrayList<String> getPath(int x, int y, int edgeX, int edgeY) {

        ArrayList<String> myResult = new ArrayList<>();

        if (x == edgeX && y == edgeY) {
            myResult.add("");
            return myResult;
        }


        if (x > edgeX || y > edgeY) {
            return myResult;
        }


        ArrayList<String> recResultX = getPath(x + 1, y, edgeX, edgeY);
        ArrayList<String> recResultY = getPath(x, y + 1, edgeX, edgeY);

        for (String h : recResultX) {
            myResult.add("H" + h);
        }

        for (String k : recResultY) {
            myResult.add("V" + k);
        }

        return myResult;

    }

}
