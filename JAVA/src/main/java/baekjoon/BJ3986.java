package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BJ3986 {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());
        int answer = 0;
        for (int test = 0; test < t; test++) {
            Stack<String> stack = new Stack<>();
            String line = br.readLine();
            String[] words = line.split("");
            stack.push(words[0]);
            for (int i = 1; i < words.length; i++) {
                if (!stack.empty() && stack.peek().equals(words[i])) {
                    stack.pop();
                    continue;
                }
                stack.push(words[i]);
            }
            if (stack.empty()) {
                answer++;
            }
        }
        System.out.println(answer);
    }

}