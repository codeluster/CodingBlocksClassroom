package June24.Question;

public class MaxSubarray {

    public static void main(String[] args) {
        //int[] input = {8, 5, 10, 7, 9, 4, 15, 12, 90, 13};
        int[] input = {1, 2, 3, 1, 4, 5, 2, 3, 6};
        printResult(input, 0, 3);
    }

    //My method
    private static void printResult(int[] input, int starting, int increments) {

        if (input.length - starting < increments) return;

        int max = 0;

        //int rt = starting + increments <= input.length ? starting + increments : input.length;
        for (int i = starting; i < starting + increments; i++) {
            if (input[i] > max) {
                max = input[i];
            }
        }

        System.out.print(max + "\t");

        printResult(input, starting + 1, increments);
    }

}
