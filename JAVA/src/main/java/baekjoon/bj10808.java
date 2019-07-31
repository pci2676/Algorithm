package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class bj10808 {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {

        String word = br.readLine();

        Map<String, Integer> answerMap = new HashMap<>();
        String[] arr = "abcdefghijklmnopqrstuvwxyz".split("");

        Arrays.stream(arr).forEach(each -> answerMap.put(each, 0));

        Arrays.stream(word.split(""))
                .forEach(each -> answerMap.put(each, answerMap.get(each) + 1));

        String answer = "";
        StringBuilder sb = new StringBuilder("");
        for (Integer value : answerMap.values()) {
            sb.append(value)
                    .append(" ");
        }
        System.out.println(sb.toString());
    }
}
