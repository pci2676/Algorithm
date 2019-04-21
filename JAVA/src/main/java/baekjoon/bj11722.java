package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class bj11722 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int count = Integer.valueOf(br.readLine());

        String line = br.readLine();
        String[] sArr = line.split(" ");

        int[] arr = new int[count];
        int[] dp = new int[count];

        for (int i = 0; i < count; i++) {
            arr[i] = Integer.valueOf(sArr[i]);
            dp[i] = 1;
        }


        //자기에서 끝나는걸 저장하고 앞에있는걸 참조하자
        for (int i = 1; i < count; i++) {
            //i가 끝나는 위치
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[i]) {
                    if (dp[i] < dp[j] + 1) {
                        dp[i] = dp[j] + 1;
                    }
                }
            }
        }

        int answer = 1;
        for (int i = 0; i < count; i++) {
            if (answer < dp[i]) {
                answer = dp[i];
            }
        }

        System.out.println(answer);
    }
}
