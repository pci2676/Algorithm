package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class bj2490 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int t = 0; t < 3; t++) {
            String line = br.readLine();

            int answer = Arrays.stream(line.split(" "))
                    .mapToInt(Integer::valueOf)
                    .sum();

            System.out.println(game.findByCount(answer).getComment());
        }
    }

    public enum game {
        DO(3, "A"),
        GAE(2, "B"),
        GUL(1, "C"),
        YUT(0, "D"),
        MO(4, "E");

        private int count;
        private String comment;

        game(int count, String comment) {
            this.count = count;
            this.comment = comment;
        }

        public static game findByCount(int count) {
            return Arrays.stream(game.values())
                    .filter(game -> game.hasCount(count))
                    .findFirst()
                    .orElseThrow(RuntimeException::new);
        }

        public String getComment() {
            return this.comment;
        }

        private boolean hasCount(int count) {
            return this.count == count;
        }
    }
}
