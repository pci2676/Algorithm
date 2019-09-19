package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class BJ11656 {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
        String word = br.readLine();
        Set<String> dictionary = new HashSet<>();
        for (int i = 0; i < word.length(); i++) {
            dictionary.add(word.substring(i));
        }
        List<String> sorted = dictionary.stream()
                .sorted(String::compareTo)
                .collect(Collectors.toList());

        for (String ordered : sorted) {
            System.out.println(ordered);
        }
    }
}
