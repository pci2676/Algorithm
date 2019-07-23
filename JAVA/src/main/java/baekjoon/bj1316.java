package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class bj1316 {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int n = Integer.valueOf(br.readLine());
        int answer = 0;
        for (int t = 1; t <= n; t++) {
            String line = br.readLine();

            String[] arr = line.split("");
            String before = arr[0];

            int size = arr.length;

            Set<String> set = new HashSet<>();
            Set<String> sub = new HashSet<>();


            for (int i = 0; i < size; i++) {
                String now = arr[i];

                //이전것과 다른게 나오면
                if (!now.equals(before)) {
                    //이전게 이미 저장된애면
                    if (set.contains(before)) {
                        //뺄놈에 넣고
                        sub.add(before);
                    } else {
                        //아니면 저장하고
                        set.add(before);
                    }
                }

                before = now;
            }

            if (set.contains(before)) {
                sub.add(before);
            } else {
                set.add(before);
            }


            if (!sub.isEmpty()) {
                continue;
            }
            answer++;

        }
        System.out.println(answer);
    }
}
