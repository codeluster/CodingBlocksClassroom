package June19.Backtracking;

public class nQueens {

    public static void main(String[] args) {

        placeQueens(new boolean[4][4], 0, "");

    }

    private static void placeQueens(boolean[][] board, int row, String answer) {

        //base case
        //we reach last row
        if (row == board.length) {
            System.out.println(answer);
            return;
        }

        for (int column = 0; column < board[row].length; column++) {

            //only place queen if it is safe to do so
            if (isSafe(board, row, column)) {

                //place the queen
                board[row][column] = true;

                //send the modified board
                placeQueens(board, row + 1, answer + "(" + row + "," + column + ")");

                // remove the queen before next loop
                board[row][column] = false;
            }
        }


    }

    private static boolean isSafe(boolean[][] board, int row, int column) {


        //Checking vertically up for danger
        int mRow = row - 1;
        int mColumn = column;

        //Only keep moving row-- without changing column
        while (mRow >= 0) {
            //another queen is found
            if (board[mRow][mColumn]) {
                return false;
            }
            //if not move up another row
            mRow--;
        }

        //Checking left upward diagonal
        //Reset the values of mRow and mColumn for this case
        mRow = row - 1;
        mColumn = column - 1;

        //Move upwards diagonally left till edge of the board is hit
        while (mRow >= 0 && mColumn >= 0) {
            //another queen is found
            if (board[mRow][mColumn]) {
                return false;
            }
            //if not move up another row and column
            mRow--;
            mColumn--;
        }

        //Checking right upward diagonal
        //Reset the values of mRow and mColumn for this case
        mRow = row - 1;
        mColumn = column + 1;

        //Move upwards diagonally right till edge of the board is hit
        while (mRow >= 0 && mColumn <= board[row].length - 1) {
            //another queen is found
            if (board[mRow][mColumn]) {
                return false;
            }
            //if not move up another row and column
            mRow--;
            mColumn++;
        }

        return true;

    }

}
