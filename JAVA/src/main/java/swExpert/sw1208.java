package swExpert;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class sw1208 {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {

        for (int test = 0; test < 10; test++) {

            int dumps = Integer.valueOf(br.readLine());

            int[] heights = Arrays.stream(br.readLine()
                    .split(" "))
                    .mapToInt(Integer::valueOf)
                    .toArray();


            for (int t = 0; t < dumps; t++) {

                int max = Arrays.stream(heights).max().getAsInt();
                int min = Arrays.stream(heights).min().getAsInt();

                if (max == min) {
                    break;
                }

                boolean maxFlag = true;
                boolean minFlag = true;

                for (int i = 0; i < 100; i++) {
                    if (!maxFlag && !minFlag) {
                        break;
                    }
                    if (heights[i] == max && maxFlag) {
                        heights[i]--;
                        maxFlag = false;
                    }
                    if (heights[i] == min && minFlag) {
                        heights[i]++;
                        minFlag = false;
                    }
                }
            }

            int finalMax = Arrays.stream(heights).max().getAsInt();
            int finalMin = Arrays.stream(heights).min().getAsInt();

            System.out.println("# " + (test+1) + " " + (finalMax - finalMin));

        }


    }
}
