package July6.DynamicProgramming;

public class HarryPotter {

    public static void main(String[] dkjbs) {

        int[] colors = {40, 60, 20};
//        System.out.println(TopDown(0, colors.length - 1, colors));
        System.out.println(BottomUp(colors));
    }

    private static int Recursion(int startIndex, int endIndex, int[] colors) {

        if (startIndex + 1 == endIndex) return 0;

        int minSmoke = Integer.MAX_VALUE;

        for (int k = startIndex + 1; k < endIndex; k++) {

            int smokeFront = Recursion(startIndex, k, colors);
            int smokeBack = Recursion(k, endIndex, colors);
            int colorFront = 0;
            for (int f = startIndex; f < k; f++) {
                colorFront = (colorFront + colors[f]) % 100;
            }
            int colorBack = 0;
            for (int f = k; f < endIndex; f++) {
                colorBack = (colorBack + colors[f]) % 100;
            }

            int selfSmoke = (colorFront * colorBack) + smokeBack + smokeFront;

            if (selfSmoke < minSmoke) {
                minSmoke = selfSmoke;
            }

        }

        return minSmoke;

    }

    private static int TopDown(int startIndex, int endIndex, int[] colors) {

        if (startIndex + 1 == endIndex) return 0;

        int[][] table = new int[colors.length + 1][colors.length + 1];

        int minSmoke = Integer.MAX_VALUE;

        for (int k = startIndex + 1; k < endIndex; k++) {
            int selfSmoke = 0;

            if (table[startIndex][endIndex] != 0) {

                selfSmoke = table[startIndex][endIndex];

            } else {

                int smokeFront = TopDown(startIndex, k, colors);
                int smokeBack = TopDown(k, endIndex, colors);

                int colorFront = 0;
                for (int f = startIndex; f < k; f++) {
                    colorFront = (colorFront + colors[f]) % 100;
                }

                int colorBack = 0;
                for (int f = k; f < endIndex; f++) {
                    colorBack = (colorBack + colors[f]) % 100;
                }

                selfSmoke = (colorFront * colorBack) + smokeBack + smokeFront;
            }

            if (selfSmoke < minSmoke) {
                minSmoke = selfSmoke;
            }

            table[startIndex][endIndex] = minSmoke;

        }

        return table[startIndex][endIndex];

    }

    private static int BottomUp(int[] colors) {

        int n = colors.length;
        int[][] table = new int[n][n];

        for (int slide = 1; slide <= n - 1; slide++) {

            for (int startIndex = 0; startIndex <= n - slide - 1; startIndex++) {

                int endIndex = startIndex + slide;

                int minSmoke = Integer.MAX_VALUE;

                for (int k = startIndex + 1; k < endIndex; k++) {

                    int selfSmoke = 0;

                    if (table[startIndex][endIndex] != 0) {

                        selfSmoke = table[startIndex][endIndex];

                    } else {

                        int smokeFront = table[startIndex][k];
                        int smokeBack = table[k][endIndex];

                        int colorFront = 0;
                        for (int f = startIndex; f < k; f++) {
                            colorFront = (colorFront + colors[f]) % 100;
                        }

                        int colorBack = 0;
                        for (int f = k; f < endIndex; f++) {
                            colorBack = (colorBack + colors[f]) % 100;
                        }

                        selfSmoke = (colorFront * colorBack) + smokeBack + smokeFront;
                    }

                    if (selfSmoke < minSmoke) {
                        minSmoke = selfSmoke;
                    }

                    table[startIndex][endIndex] = minSmoke;

                }
            }

        }

        return table[0][n - 1];

    }

}
