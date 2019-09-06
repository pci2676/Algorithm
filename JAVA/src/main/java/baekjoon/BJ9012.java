package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BJ9012 {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());

        for (int t = 0; t < n; t++) {
            String line = br.readLine();
            String[] gwalHos = line.split("");
            Stack<String> stack = new Stack<>();
            stack.push(gwalHos[0]);

            boolean answer = true;

            for (int i = 1; i < gwalHos.length; i++) {
                String gwalHo = gwalHos[i];
                if (gwalHo.equals("(")) {
                    stack.push(gwalHo);
                }
                if (gwalHo.equals(")")) {
                    if (stack.empty()) {
                        answer = false;
                        break;
                    }
                    if (stack.pop().equals(")")) {
                        answer = false;
                        break;
                    }
                }
            }
            if (!stack.empty()) {
                answer = false;
            }

            if (answer) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }

        }

    }
}
