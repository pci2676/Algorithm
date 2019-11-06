package programers.practice.nextbignumber;

public class Main {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(78) == 83);
        System.out.println(solution.solution(15) == 23);
    }

}

class Solution {
    public int solution(int n) {
        int answer = 0;
        int size = Integer.bitCount(n);

        int next = n + 1;
        while (true) {
            int nextSize = Integer.bitCount(next);
            if (nextSize == size) {
                answer = next;
                break;
            }
            next++;
        }

        return answer;
    }
}
