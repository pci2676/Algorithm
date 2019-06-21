package programers.sort;

import java.util.Arrays;

public class Hindex {
    public static void main(String[] args) {
        int[] citations = {1, 2, 3, 4, 5, 5, 5, 5, 6, 7, 7, 7, 7, 7};

        int answer = 0;

        Arrays.sort(citations);

        int hIndex = 0;

        for (int i = 0; i < citations[citations.length - 1]; i++) {
            int small = 0;
            int big;
            int before = hIndex;

            hIndex = i;

            for (int j = 0; j < citations.length; j++) {
                if (hIndex == citations[j]) {
                    continue;
                }
                if (hIndex > citations[j]) {
                    small++;
                }
            }

            big = citations.length - small;

            if (big < hIndex || hIndex < small) {
                hIndex = before;
                break;
            }
        }

        answer = hIndex;

        System.out.println(answer);

    }

    class Solution {
        public int solution(int[] citations) {
            int answer = 0;
            return answer;
        }
    }

}
