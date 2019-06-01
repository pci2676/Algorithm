package programers.dfs_bfs;

class Solution {
    public int solution(int[] numbers, int target) {
        int answer = 0;

        return answer;
    }
}

public class TargetNumber {

    private static int answer = 0;

    public static void main(String[] args) {
        int[] numbers = {1, 1, 1, 1, 1};
        int target = 3;


        dfs(numbers,target,0,0);
        System.out.println(answer);
    }

    private static void dfs(int[] numbers, int target, int sum, int index) {
        if (index == numbers.length) {
            if (sum == target) {
                answer++;
            }
            return;
        }
        for (int i = 0; i < 2; i++) {
            int temp = sum;
            if (i == 0) {
                temp += numbers[index];
            } else {
                temp -= numbers[index];
            }
            dfs(numbers, target, temp, index + 1);
        }
    }
}
