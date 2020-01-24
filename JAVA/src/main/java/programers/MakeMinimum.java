package programers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MakeMinimum {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(new int[]{1, 4, 2}, new int[]{5, 4, 4}) == 29);
        System.out.println(solution.solution(new int[]{1, 2}, new int[]{3, 4}) == 10);
    }
}

class Solution {

    public int solution(int[] A, int[] B) {
        int answer = 0;

        List<Integer> minList = new ArrayList<>();
        for (int a : A) {
            minList.add(a);
        }
        Collections.sort(minList);

        List<Integer> maxList = new ArrayList<>();
        for (int b : B) {
            maxList.add(b);
        }
        maxList.sort(Comparator.reverseOrder());

        for (int i = 0; i < minList.size(); i++) {
            answer += minList.get(i) * maxList.get(i);
        }

        return answer;
    }
}
