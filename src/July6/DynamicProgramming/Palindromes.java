package July6.DynamicProgramming;

public class Palindromes {

    public static void main(String[] beiuggr235) {

        String input = "ababbbabbababa";

        System.out.println(TopDown(input, 0, input.length() - 1, new int[input.length()][input.length()]));

    }

    private static boolean isPalindrome(String str, int si, int ei) {

        int left = si;
        int right = ei;

        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }

    private static int TopDown(String str, int si, int ei, int[][] strg) {

        if (isPalindrome(str, si, ei)) return 0;

        if (strg[si][ei] != 0) return strg[si][ei];

        int min = Integer.MAX_VALUE;

        for (int i = si; i < ei; i++) {

            int fp = TopDown(str, si,  i, strg);
            int bp = TopDown(str, i+1, ei, strg);

            int d3 = fp + bp + 1;

            min = d3 < min ? d3 : min;

        }

        strg[si][ei] = min;
        return min;

    }

}
