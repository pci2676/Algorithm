package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ2902 {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
        String longName = br.readLine();
        String[] words = longName.split("-");
        StringBuilder shortName = new StringBuilder();
        for (String word : words) {
            shortName.append(word.substring(0, 1));
        }
        System.out.println(shortName.toString());
    }
}
