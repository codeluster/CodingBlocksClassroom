package June19.Backtracking;

public class nKnights {

    public static void main(String[] wjegn) {

        placeKnights(new boolean[4][4], 0, 0, "");

    }

    private static boolean placeKnights(boolean[][] board, int row, int column, String answer) {

        //Reached the last row
        if (row == board.length) {

            //Print the solution
            System.out.println(answer);

            //Since we reached here a solution is possible
            return true;
        }

        //Reached the last column
        if (column == board[0].length) {

            //move to next row
            return placeKnights(board, row + 1, 0, answer);

        }

        //Traverse all columns
        for (int i = column; i < board[row].length; i++) {
            //Place knight at the spot
            board[row][column] = true;
            //run with the knight at this place
            placeKnights(board, row, column + 1, "(" + row + "," + column + ")");
            //remove the knight
            board[row][column] = false;
        }

        return false;
    }

}
