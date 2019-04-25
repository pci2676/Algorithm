package swExpert;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class sw1213 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int test = 1; test <= 10; test++) {
            int answer;

            String testNumber = br.readLine();
            String regex = br.readLine();
            String question = br.readLine();

            StringBuilder sb = new StringBuilder();
            sb.append(" ").append(question).append(" ");


            answer = sb.toString().split(regex).length - 1;
            if (answer == -1) {
                answer = 0;
            }

            System.out.println(String.format("#%s %d", testNumber, answer));
        }

    }
}
