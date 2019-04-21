package swExpert;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class sw2805 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int test = Integer.valueOf(br.readLine());

        for (int t = 1; t <= test; t++) {
            int size = Integer.valueOf(br.readLine());
            int[][] map = new int[size][size];

            for (int y = 0; y < size; y++) {
                String line = br.readLine();
                int[] crop = Arrays.stream(line.split(""))
                        .mapToInt(Integer::valueOf)
                        .toArray();
                map[y] = crop;
            }

            int mid = size / 2;
            int sum = 0;

            for (int y = 0; y <= mid; y++) {
                for (int x = mid; x >= mid - y; x--) {
                    sum += map[y][x];
                }

                for (int x = mid + 1; x <= mid + y; x++) {
                    sum += map[y][x];
                }
            }


            for (int y = mid + 1; y < size; y++) {
                for (int x = mid; x >= y - mid; x--) {
                    sum += map[y][x];
                }
                for (int x = mid + 1; x < size - (y - mid); x++) {
                    sum += map[y][x];
                }
            }

            System.out.println(String.format("#%d %d", t, sum));
        }
    }
}
