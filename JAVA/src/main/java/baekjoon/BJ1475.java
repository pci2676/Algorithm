package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class BJ1475 {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {

        int answer = solution(br.readLine());

        System.out.println(answer);
    }

    private static int solution(String roomNumber) {
        Map<String, Integer> map = new HashMap<>();

        init(map, roomNumber);

        int max = Integer.MIN_VALUE;

        for (Integer amount : map.values()) {
            if (max < amount) {
                max = amount;
            }
        }

        return max;
    }

    private static void init(Map<String, Integer> map, String roomNumber) {
        String[] numbers = roomNumber.split("");
        for (int i = 0; i <= 9; i++) {
            map.put(String.valueOf(i), 0);
        }
        boolean sixAndNine = true;
        for (String number : numbers) {
            if (number.equals("9") || number.equals("6")) {
                if (sixAndNine) {
                    int value = map.get("6") + 1;
                    map.put("6", value);
                }
                sixAndNine = !sixAndNine;
                continue;
            }
            int value = map.get(number) + 1;
            map.put(number, value);
        }
    }
}
