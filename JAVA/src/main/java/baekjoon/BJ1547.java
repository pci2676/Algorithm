package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BJ1547 {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {

        int m = Integer.parseInt(br.readLine());

        Map<Integer, Integer> cups = new HashMap<>();
        //컵의 번호, 현재 위치
        cups.put(1, 1);
        cups.put(2, 2);
        cups.put(3, 3);

        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            int temp = cups.get(x);
            cups.put(x, cups.get(y));
            cups.put(y, temp);
        }

        for (int i = 1; i <= 3; i++) {
            if(cups.get(i)==1){
                System.out.println(i);
            }
        }
    }
}
