//package baekjoon;
//
//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//import java.util.LinkedList;
//import java.util.List;
//import java.util.stream.Collectors;
//
//public class bj2675 {
//    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//    private static final String REG = "[A-Z0-9]0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ\\$%*+-./:";
//
//    public static void main(String[] args) throws Exception {
//        int t = Integer.valueOf(br.readLine());
//        List<String> answer = new LinkedList<>();
//        for (int i = 0; i < t; i++) {
//            String line = br.readLine();
//            String[] arr = line.split(" ");
//            int r = Integer.valueOf(arr[0]);
//            String input = arr[1];
//
//            String[] each = input.split("");
//
//
//            String temp = "";
//            for (int j = 0; j < each.length; j++) {
//                for (int k = 0; k < r; k++) {
//                    temp = temp + each[j];
//                }
//            }
//            answer.add(temp);
//        }
//        System.out.println(answer.stream().collect(Collectors.joining("\n")));
//    }
//}
