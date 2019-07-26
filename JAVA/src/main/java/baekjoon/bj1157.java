package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class bj1157 {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {

        String line = br.readLine();

        Map<String, Long> answerMap = new HashMap<>();

        String[] arr = line.split("");

        for (String anArr : arr) {
            String key = anArr.toUpperCase();
            if (answerMap.containsKey(key)) {
                long value = answerMap.get(key);
                answerMap.put(key, value + 1);
            } else {
                answerMap.put(key, 1L);
            }

        }

        long max = answerMap.entrySet().stream()
                .map(Map.Entry::getValue)
                .max(Long::compareTo)
                .get();

        List<String> answer = new ArrayList<>();

        answerMap.entrySet().stream()
                .filter(stringLongEntry -> stringLongEntry.getValue() == max)
                .map(Map.Entry::getKey)
                .forEach(answer::add);

        if (answer.size() > 1) {
            System.out.println("?");
        } else {
            System.out.println(answer.get(0));
        }

    }
}
