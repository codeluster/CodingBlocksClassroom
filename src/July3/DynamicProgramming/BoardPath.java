package July3.DynamicProgramming;

public class BoardPath {

    public static void main(String[] args) {

        int curr = 0;
        int end = 10;

        System.out.println(BottomUpSpaceEff(curr, end));

//        int[] storage = new int[end + 6];
//        storage[end] = 1;
//
//        for (int coutner = end - 1; coutner >= 0; coutner--) {
//            storage = BottomUp(coutner, storage);
//        }
//
//        System.out.println(storage[0]);

    }

    private static int BottomUpSpaceEff(int curr, int end) {

        int dice = 6;

        int[] storage = new int[dice];

        storage[0] = 1;

        for (int counter = curr; counter < end; counter++) {

            int sum = 0;

            for (int i = 0; i < storage.length; i++) {
                sum += storage[i];
            }

            for (int i = storage.length - 1; i > 0; i--) {
                storage[i] = storage[i - 1];
            }

            storage[0] = sum;

        }

        return storage[0];

    }

    private static int[] BottomUp(int curr, int[] storage) {

        int x = 0;

        for (int i = curr + 1; i <= curr + 6; i++) {
            x += storage[i];
        }

        storage[curr] = x;
        return storage;
    }

    private static int TopDown(int curr, int end, int[] storage) {

        if (curr == end) {
            return 1;
        } else if (curr > end) {
            return 0;
        }

        if (storage[curr] != 0) {
            return storage[curr];
        }

        int count = 0;

        for (int dice = 1; dice <= 6; dice++) {

            count += TopDown(curr + dice, end, storage);

        }

        storage[curr] = count;
        return count;

    }
}
