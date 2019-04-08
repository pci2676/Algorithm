package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class bj11399 {
    private static final String SPLITER = " ";

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.valueOf(br.readLine());

        String line = br.readLine();
        String[] lineArr = line.split(SPLITER);
        int[] arr = Arrays.stream(lineArr)
                .mapToInt(Integer::valueOf)
                .sorted()
                .toArray();

        for (int i = 1; i < n; i++) {
            arr[i] = arr[i] + arr[i - 1];
        }

        int answer = Arrays.stream(arr)
                .sum();

        System.out.println(answer);
    }
}
