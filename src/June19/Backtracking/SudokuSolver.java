package June19.Backtracking;

import java.util.Scanner;

public class SudokuSolver {

    public static void main(String[] defParams) {

        Scanner scanner = new Scanner(System.in);

        int size = scanner.nextInt();

        int[][] puzzle =
                new int[size][size];

        for (int row = 0; row < size; row++) {

            for (int column = 0; column < size; column++) {

                puzzle[row][column] = scanner.nextInt();

            }

        }

        if (solver(puzzle, 0, 0)) {
            displayPuzzle(puzzle);
        } else {
            System.out.println("It is not possible to solve this puzzle.");
        }

    }

    private static void displayPuzzle(int[][] puzzle) {

        for (int row = 0; row < puzzle.length; row++) {
            for (int column = 0; column < puzzle[row].length; column++) {
                System.out.print(puzzle[row][column] + "\t");
            }
            System.out.println();
        }

    }

    private static boolean solver(int[][] puzzle, int current_row, int current_column) {

        // All rows have been filled
        if (current_row == puzzle.length) {
            //Return true because a solution is possible
            return true;
        }

        //Last column has been filled
        //Reset to move to next row and start from first column
        if (current_column == puzzle[0].length) {
            return solver(puzzle, current_row + 1, 0);
        }

        //If the spot is filled then move to the next spot
        if (puzzle[current_row][current_column] != 0) {
            return solver(puzzle, current_row, current_column + 1);
        }

        for (int i = 1; i <= puzzle.length; i++) {

            //If it is safe to put this number here
            if (isItSafe(puzzle, current_row, current_column, i)) {
                //Fill the current space with a number from the loop
                puzzle[current_row][current_column] = i;
                //Move to the next spot
                boolean result = solver(puzzle, current_row, current_column + 1);

                //If an arrangement with this number was possible stop the loop
                if (result) return result;

                //Restore the value to 0 for the next number to be tried
                puzzle[current_row][current_column] = 0;

            }

        }

        //If all fails
        return false;

    }


    private static boolean isItSafe(int[][] puzzle, int row, int column, int number) {

        return isItSafeRow(puzzle, row, number) && isItSafeColumn(puzzle, column, number) && isItSafeGrid(puzzle, row, column, number);

    }

    private static boolean isItSafeRow(int[][] puzzle, int row, int number) {

        for (int column = 0; column < puzzle[row].length; column++) {
            if (puzzle[row][column] == number) return false;
        }

        return true;

    }

    private static boolean isItSafeColumn(int[][] puzzle, int column, int number) {

        for (int row = 0; row < puzzle.length; row++) {
            if (puzzle[row][column] == number) return false;
        }

        return true;

    }

    private static boolean isItSafeGrid(int[][] puzzle, int row, int column, int number) {

        int rowCounter = 0;
        int rowStopper = 0;
        int columnCounter = 3 * (column / 3);
        int columnStopper = 3 * ((column / 3) + 1);

        if (puzzle.length == 9) {
            rowCounter = 3 * (row / 3);
            rowStopper = 3 * ((row / 3) + 1);
        } else if (puzzle.length == 6) {
            rowCounter = 2 * (row / 2);
            rowStopper = 2 * ((row / 2) + 1);
        }

        for (int loop_row = rowCounter; loop_row < rowStopper; loop_row++) {

            for (int loop_column = columnCounter; loop_column < columnStopper; loop_column++) {

                if (puzzle[loop_row][loop_column] == number) return false;
            }

        }

        return true;

    }

}

