package July4.DynamicProgramming;

public class EditDistance {

    public static void main(String[] args) {

        String a = "abcdnknlkrlkefg";
        String b = "abcskznhjrbgdfge";

//        System.out.println(Recursion(a, b));
//        System.out.println(BottomUp(a, b));

    }

    private static int Recursion(String s1, String s2) {

        if (s1.length() == 0 || s2.length() == 0) return Math.max(s1.length(), s2.length());

        char c1 = s1.charAt(0);
        char c2 = s2.charAt(0);
        String ros1 = s1.substring(1);
        String ros2 = s2.substring(1);

        if (c1 == c2) {
            return Recursion(ros1, ros2);
        } else {
            int insertion = Recursion(ros1, s2);
            int deletion = Recursion(s1, ros2);
            int replacement = Recursion(ros1, ros2);

            return Math.min(insertion, Math.min(deletion, replacement)) + 1;
        }

    }

    private static int BottomUp(String s1, String s2) {

        int[][] table = new int[s1.length() + 1][s2.length() + 1];

        //fill last row of table
        for (int i = s2.length(); i >= 0; i--) {
            table[s1.length()][s2.length() - i] = i;
        }

        //fill last column of table
        for (int i = s1.length(); i >= 0; i--) {
            table[s1.length() - i][s2.length()] = i;
        }

        for (int row = s1.length() - 1; row >= 0; row--) {
            for (int col = s2.length() - 1; col >= 0; col--) {
                if (s1.charAt(row) == s2.charAt(col)) {
                    table[row][col] = table[row + 1][col + 1];
                } else {
                    table[row][col] = 1 + Math.min(table[row + 1][col + 1], Math.min(table[row + 1][col], table[row][col + 1]));
                }
            }
        }

//        For debugging purpose
//        prints the table

//        for (int[] x : table) {
//            for (int y : x) {
//                System.out.print(y + "\t");
//            }
//            System.out.println();
//        }

        return table[0][0];

    }
}
