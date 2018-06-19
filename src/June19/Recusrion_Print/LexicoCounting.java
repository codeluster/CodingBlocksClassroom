package June19.Recusrion_Print;

public class LexicoCounting {

    public static void main(String[] eoiehgoiuhgio) {

        getCounting(0, 1000);

    }

    private static void getCounting(int initial, int mfinal) {

        System.out.println(initial);

        if (initial > mfinal) {
            return;
        }

        if (initial == 0) {
            for (int i = 1; i <= 9; i++) {
                getCounting(initial * 10 + i, mfinal);
            }
        } else {
            for (int i = 0; i <= 9; i++) {
                getCounting(initial * 10 + i, mfinal);
            }
        }

    }

}
