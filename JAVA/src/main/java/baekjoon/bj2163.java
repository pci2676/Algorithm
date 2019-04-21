package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class bj2163 {

    public static void main(String[] args)  throws  Exception{
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String line = bufferedReader.readLine();
        String[] arr =line.split(" ");
        int m = Integer.valueOf(arr[0]);
        int n = Integer.valueOf(arr[1]);

        System.out.println(m*n-1);
    }
}
