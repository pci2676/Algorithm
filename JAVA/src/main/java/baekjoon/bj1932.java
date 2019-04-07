//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//import java.util.Arrays;
//
//public class bj1932 {
//
//    static int[][] tri;
//    static int max = 0;
//    static int n;
//
//    public static void main(String[] args) throws Exception {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//        n = Integer.valueOf(br.readLine());
//
//        tri = new int[n][n];
//
//        for (int y = 0; y < n; y++) {
//            String line = br.readLine();
//            int[] arr = Arrays.stream(line.split(" "))
//                    .mapToInt(Integer::valueOf)
//                    .toArray();
//            for (int x = 0; x <= y; x++) {
//                tri[y][x] = arr[x];
//            }
//        }
//
//        for (int y = 0; y < n; y++) {
//            for (int x = 0; x <= y; x++) {
//                if (x == 0) {
//                    if (y != 0) {
//                        tri[y][0] += tri[y - 1][0];
//                    }
//                } else if (x == y) {
//                    tri[y][x] += tri[y - 1][x - 1];
//                } else {
//                    tri[y][x] += Math.max(tri[y - 1][x], tri[y - 1][x - 1]);
//                }
//            }
//        }
//
//        max = Arrays.stream(tri[n - 1])
//                .max()
//                .getAsInt();
//
//        System.out.println(max);
//    }
//}
