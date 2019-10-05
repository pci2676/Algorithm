package self.binarysearch;

public class BinarySearch {

    public static void main(String[] args) {
        int[] sorted = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        int target = -1;

        for (int i = 1; i < 11; i++) {
            target = i;
            int start = 0;
            int end = sorted.length - 1;
            int mid = (start + end) / 2;
            int answer = -1;

            while (start <= end) {
                if (sorted[mid] < target) {
                    start = mid + 1;
                } else if (sorted[mid] > target) {
                    end = mid - 1;
                } else {
                    answer = mid;
                    break;
                }
                mid = (start + end) / 2;
            }

            System.out.println(answer);
        }


    }


}