//package baekjoon;
//
//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//import java.util.Arrays;
//
//public class bj1912 {
//
//    private static final String SPLITTER = " ";
//
//    public static void main(String[] args) throws Exception {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int n = Integer.valueOf(br.readLine());
//
//        long[] dp = new long[n];
//
//        String line = br.readLine();
//        long[] numbers = Arrays.stream(line.split(SPLITTER))
//                .mapToLong(Long::valueOf)
//                .toArray();
//
//        dp[0] = numbers[0];
//
//        for (int i = 1; i < n; i++) {
//            dp[i] = Math.max(dp[i - 1] + numbers[i], numbers[i]);
//        }
//
//        dp = Arrays.stream(dp)
//                .sorted()
//                .toArray();
//
//        System.out.println(dp[n - 1]);
//    }
//
//}