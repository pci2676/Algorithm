//package baekjoon;
//
//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//
//public class bj11507 {
//
//    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//    private static int n;
//    private static int[][] dp;
//
//    public static void main(String[] args) throws Exception {
//        n = Integer.valueOf(br.readLine());
//        init();
//
//        //n자릿수까지 검사를 하자
//        for (int position = 2; position <= n; position++) {
//
//            //n자리의 number라는 숫자가 온다고 가정 후 고정하면
//            //number -> dp[position][number]
//            for (int number = 0; number < 10; number++) {
//
//                //number가 왔을때 점화식
//                for (int compare = 0; compare <= number; compare++) {
//                    dp[position][number] = (dp[position][number] + dp[position - 1][compare]) % 10007;
//                }//compare end
//
//            }//number end
//
//        }//position end
//
//
//        System.out.println(getAnswer());
//    }
//
//    private static void init() {
//        dp = new int[n + 2][10];
//        for (int i = 0; i < 10; i++) {
//            dp[1][i] = 1;
//        }
//    }
//
//    private static long getAnswer() {
//        long answer = 0;
//
//        for (int number = 0; number < 10; number++) {
//            answer = (answer + dp[n][number]) % 10007;
//        }
//
//        return answer % 10007;
//    }
//}
