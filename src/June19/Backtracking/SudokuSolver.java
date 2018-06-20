package June19.Backtracking;

public class SudokuSolver {

    public static void main(String[] __) {

        int[][] puzzle =
                {{3, 0, 6, 5, 0, 8, 4, 0, 0},
                        {5, 2, 0, 0, 0, 0, 0, 0, 0},
                        {0, 8, 7, 0, 0, 0, 0, 3, 1},
                        {0, 0, 3, 0, 1, 0, 0, 8, 0},
                        {9, 0, 0, 8, 6, 3, 0, 0, 5},
                        {0, 5, 0, 0, 9, 0, 6, 0, 0},
                        {1, 3, 0, 0, 0, 0, 2, 5, 0},
                        {0, 0, 0, 0, 0, 0, 0, 7, 4},
                        {0, 0, 5, 2, 0, 6, 3, 0, 0}};

        solver(puzzle, 0, 0);

    }

    private static void displayPuzzle(int[][] puzzle) {

        for (int row = 0; row < puzzle.length; row++) {
            for (int column = 0; column < puzzle[row].length; column++) {
                System.out.print(puzzle[row][column] + "\t");
            }
            System.out.println();
        }

    }

    private static boolean solver(int[][] puzzle, int row, int column) {

        // All rows have been filled
        if (row == puzzle.length) {

            //Print the solved puzzle
            displayPuzzle(puzzle);

            //Return true because a solution is possible
            return true;
        }

        //Last column has been filled
        //Reset to move to next row and start from first column
        if (column == puzzle[0].length) {
            return solver(puzzle, row + 1, 0);
        }

        for (int i = 1; i <= 9; i++) {

            //Only if the spot is not already filled and if it is safe to put this number here
            if (puzzle[row][column] == 0 && isItSafe(puzzle, row, column, i)) {
                //Fill the current space with a number from the loop
                puzzle[row][column] = i;
                //Move to the next spot
                return solver(puzzle, row, column + 1);
            } else {
                return solver(puzzle, row, column);
            }

        }

        return false;
    }


    private static boolean isItSafe(int[][] puzzle, int row, int column, int number) {

        return isItSafeRow(puzzle, row, number) && isItSafeColumn(puzzle, column, row);

    }

    private static boolean isItSafeRow(int[][] puzzle, int row, int number) {

        for (int column = 0; column < puzzle[row].length; column++) {
            if (puzzle[row][column] == number) return false;
        }

        return true;

    }

    private static boolean isItSafeColumn(int[][] puzzle, int column, int number) {

        for (int row = 0; column < puzzle.length; row++) {
            if (puzzle[row][column] == number) return false;
        }

        return true;

    }
}

