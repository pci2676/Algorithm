package programers.bruteForce;

import java.util.HashSet;
import java.util.Set;


/**
 * 브루트 포스의 유명한 문제라고 한다.
 * 접근 방법을 찾지 못해서 결국 다른 사람의 답을 한번보고 작성하였다.
 * 정답을 가정하고 접근하는 문제였다.
 */
public class BaseBallGame_R {

    public static void main(String[] args) {
        int[][] baseball = {{123, 1, 1}, {356, 1, 0}, {327, 2, 0}, {489, 0, 1}};

        Set<String> answers = new HashSet<>();
        for (int init = 123; init <= 987; init++) {
            String maybe = String.valueOf(init);
            if (isDuplicate(maybe) || hasZero(maybe)) {
                continue;
            }
            answers.add(maybe);

            for (int[] aBaseball : baseball) {
                if (!canAnswer(maybe, aBaseball)) {
                    answers.remove(maybe);
                }
            }
        }

        System.out.println(answers);
    }

    private static boolean canAnswer(String maybe, int[] baseball) {
        String attack = String.valueOf(baseball[0]);
        int strike = baseball[1];
        int ball = baseball[2];

        return hasCorrectStrikeAndBall(maybe, attack, strike, ball);
    }

    private static boolean hasCorrectStrikeAndBall(String maybe, String attack, int strike, int ball) {
        char maybeFirst = maybe.charAt(0);
        char maybeSecond = maybe.charAt(1);
        char maybeThird = maybe.charAt(2);

        char attackFirst = attack.charAt(0);
        char attackSecond = attack.charAt(1);
        char attackThird = attack.charAt(2);

        int strikeCount = 0;
        if (maybeFirst == attackFirst) {
            strikeCount++;
        }
        if (maybeSecond == attackSecond) {
            strikeCount++;
        }
        if (maybeThird == attackThird) {
            strikeCount++;
        }

        int ballCount = 0;
        if (maybeFirst == attackSecond || maybeFirst == attackThird) {
            ballCount++;
        }
        if (maybeSecond == attackFirst || maybeSecond == attackThird) {
            ballCount++;
        }
        if (maybeThird == attackSecond || maybeThird == attackFirst) {
            ballCount++;
        }

        return (strike == strikeCount) && (ball == ballCount);
    }

    private static boolean hasZero(String src) {
        String[] maybe = src.split("");
        String first = maybe[0];
        String second = maybe[1];
        String third = maybe[2];

        return first.equals("0") || second.equals("0") || third.equals("0");
    }

    private static boolean isDuplicate(String src) {
        String[] maybe = src.split("");
        String first = maybe[0];
        String second = maybe[1];
        String third = maybe[2];

        return first.equals(second) || first.equals(third) || second.equals(third);
    }

    class Solution {
        public int solution(int[][] baseball) {
            int answer = 0;

            return answer;
        }
    }


}
