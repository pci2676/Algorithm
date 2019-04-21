package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class bj10797 {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int day = Integer.valueOf(br.readLine());

        long answer = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::valueOf)
                .filter(value -> value==day)
                .count();

        System.out.println(answer);
    }
}
