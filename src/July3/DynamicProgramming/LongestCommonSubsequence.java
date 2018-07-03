package July3.DynamicProgramming;

public class LongestCommonSubsequence {

    public static void main(String[] args) {

        String a = "abcd";
        String b = "agchd";

//        System.out.println(Recursion(a, b));
        System.out.println(BottomUp(a, b));

    }

    private static int Recursion(String s1, String s2) {

        if (s1.length() == 0 || s2.length() == 0) return 0;

        char c1 = s1.charAt(0);
        char c2 = s2.charAt(0);
        String ros1 = s1.substring(1);
        String ros2 = s2.substring(1);

        if (c1 == c2) {
            return Recursion(ros1, ros2) + 1;
        } else {
            return Math.max(Recursion(s1, ros2), Recursion(ros1, s2));
        }

    }

    private static int BottomUp(String s1, String s2) {

        int[][] table = new int[s1.length() + 1][s2.length() + 1];

        for (int row = s1.length(); row >= 0; row--) {
            for (int col = s2.length(); col >= 0; col--) {

                if (row == s1.length() || col == s2.length()) {
                    table[row][col] = 0;
                } else {
                    if (s1.charAt(row) == s2.charAt(col)) {
                        table[row][col] = table[row + 1][col + 1] + 1;
                    } else {
                        table[row][col] = Math.max(table[row + 1][col], table[row][col + 1]);
                    }
                }

            }
        }

        return table[0][0];
    }

}
