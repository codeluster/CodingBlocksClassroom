package June17.Recursion_Print;

public class BoardPath {

    public static void main(String[] strings) {

        System.out.print(getBoardPath(0, 10, ""));

    }

    private static int getBoardPath(int curr, int end, String ans) {

        if (curr == end) {
            System.out.println(ans);
            return 1;
        } else if (curr > end) {
            return 0;
        } else {

            int count = 0;

            for (int dice = 1; dice <= 6; dice++) {
                count += getBoardPath(curr + dice, end, ans + dice);
            }
            return count;
        }
    }

}
