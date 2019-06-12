package programers.practice;

public class Fibonacci {
    //n번째 피보나치 수를 1234567로 나눈수
    public static void main(String[] args) {
        int n = 5;
        int answer;
        int[] fibonacci = new int[100001];
        fibonacci[0] = 0;
        fibonacci[1] = 1;
        for (int i = 2; i <= n; i++) {
            fibonacci[i] = (fibonacci[i - 2] + fibonacci[i - 1]) % 1234567;
        }

        answer = fibonacci[n] % 1234567;
    }

    class Solution {
        public int solution(int n) {
            int answer = 0;
            return answer;
        }
    }
}
