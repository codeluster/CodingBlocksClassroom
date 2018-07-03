package July3.DynamicProgramming;

import java.util.Arrays;

public class MazePath {

    public static void main(String[] args) {

//        System.out.println(TopDown(0, 0, 2, 2, new int[3][3]));
        System.out.println(BottomUpSpaceEffWithDiagonal(0, 0, 3, 3));
    }

    private static int BottomUp(int cr, int cc, int er, int ec) {

        int[][] storage = new int[er + 1][ec + 1];

        //Create a new array with edges containing 1
        for (int row = er; row >= cr; row--) {
            for (int column = ec; column >= cc; column--) {
                if (row == er || column == ec) {
                    storage[row][column] = 1;
                } else {
                    storage[row][column] = storage[row][column + 1] + storage[row + 1][column];
                }
            }
        }

        return storage[0][0];

    }

    private static int BottomUpSpaceEff(int cr, int cc, int er, int ec) {

        int[] storage = new int[ec + 1];

        Arrays.fill(storage, 1);

        for (int row = er - 1; row >= cr; row--) {

            for (int col = ec; col >= cc; col--) {

                if (col == ec) {
                    storage[col] = 1;
                } else {
                    storage[col] += storage[col + 1];
                }

            }

        }

        return storage[0];

    }

    private static int BottomUpSpaceEffWithDiagonal(int cr, int cc, int er, int ec) {

        int[] storage = new int[ec + 1];

        Arrays.fill(storage, 1);

        int diagonal = 1;

        for (int row = er - 1; row >= cr; row--) {

            for (int col = ec; col >= cc; col--) {

                if (col == ec) {
                    storage[col] = 1;
                    diagonal = 1;
                } else {
                    int newDiagonal = storage[col];
                    storage[col] = diagonal + newDiagonal + storage[col + 1];
                    diagonal = newDiagonal;
                }

            }

        }

        return storage[0];

    }

    private static int TopDown(int cr, int cc, int er, int ec, int[][] storage) {

        if (cr == er && cc == ec) {
            return 1;
        } else if (cr > er || cc > ec) {
            return 0;
        }

        if (storage[cr][cc] != 0) {
            return storage[cr][cc];
        }

        int hc = TopDown(cr, cc + 1, er, ec, storage);
        int vc = TopDown(cr + 1, cc, er, ec, storage);

        storage[cr][cc] = hc + vc;

        return storage[cr][cc];

    }

}
