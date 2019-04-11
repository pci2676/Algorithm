//package baekjoon;
//
//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//
//public class bj2960 {
//    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//    public static void main(String[] args) throws Exception {
//        String input = br.readLine();
//        String[] splited = input.split(" ");
//        int n = Integer.valueOf(splited[0]);
//        int k = Integer.valueOf(splited[1]);
//
//        int count = 0;
//
//        int[] numbers = new int[n + 1];
//
//        for (int i = 2; i <= n; i++) {
//            numbers[i] = i;
//        }
//        int answer = 0;
//        for (int i = 2; i <= n; i++) {
//            if (numbers[i] == 0) {
//                continue;
//            } else {
//                count++;
//                if (count == k) {
//                    answer = numbers[i];
//                }
//                numbers[i] = 0;
//            }
//            for (int j = i * 2; j <= n; j = j + i) {
//                if (numbers[j] == 0) {
//                    continue;
//                }
//
//                count++;
//                if (count == k) {
//                    answer = numbers[j];
//                }
//                numbers[j] = 0;
//            }
//        }
//
//        System.out.println(answer);
//    }
//}
