package programers.greedy;

public class JoyStick_FAIL {

    private static final int ENGLISH_AMOUNT = 26;
    private static final int HALF_OF_ENGLISH = 13;
    private static final int JOYSTICK_MOVE = 1;

    public static void main(String[] args) {
        String name = "ABAAB";
        int answer = 0;

        char[] input = new char[name.length()];
        for (int i = 0; i < input.length; i++) {
            input[i] = 'A';
        }

        //전부 A인지 확인
        if (name.equals(new String(input))) {
            //return answer;
        }

        int right = getRightCount(name, input);
        int left = getLeftCount(name, input);

        System.out.println("right: " + right);
        System.out.println("left: " + left);
        int bigger = Math.max(right, left);

        int jump = getJumpCount(name);
        answer = bigger - jump;

        System.out.println(answer);
    }

    private static int getRightCount(String name, char[] input) {
        int sum = 0;
        for (int i = 0; i < name.length(); i++) {
            int def = name.charAt(i) - input[i];
            if (def > HALF_OF_ENGLISH) {
                def = ENGLISH_AMOUNT - def;
            }
            sum = sum + def + JOYSTICK_MOVE;
        }
        return sum - JOYSTICK_MOVE;
    }

    private static int getLeftCount(String name, char[] input) {
        int sum = 0;
        int def = name.charAt(0) - input[0];
        sum = sum + def;
        for (int i = name.length() - 1; i > 0; i--) {
            def = name.charAt(i) - input[i];
            if (def > HALF_OF_ENGLISH) {
                def = ENGLISH_AMOUNT - def;
            }
            sum = sum + def + JOYSTICK_MOVE;
        }
        return sum;
    }

    private static int getJumpCount(String name) {
        String cutName = name.substring(1, name.length() - 1);
        int halfLength = name.length() / 2;

        if (name.length() % 2 != 0) {
            halfLength++;
        }
        System.out.println(halfLength);

        char[] regex = new char[halfLength];
        for (int i = 0; i < halfLength; i++) {
            regex[i] = 'A';
        }

        if (cutName.contains(new String(regex))) {
            return halfLength - 1;
        }

        int max = 0;
        int temp = 0;
        for (int i = 0; i < cutName.length(); i++) {
            if (cutName.charAt(i) == 'A') {
                temp++;
            } else {
                temp = 0;
            }
            if (max < temp) {
                max = temp;
            }
        }
        if (max >= name.length() / 2) {
            return max - 1;
        }

        return 0;
    }

    class Solution {
        public int solution(String name) {
            int answer = 0;
            return answer;
        }
    }
}


/**
 * 중간 /2한 값돠 큰 A가 있으면 그 A의 길이 -1 을 뺀값이 답
 * ABAAB A가 2개 전체길이5
 * 5가 답
 * 6이 나옴
 * <p>
 * ABAAAAAB
 * 5가 답
 * 9가 나옴
 * <p>
 * ABAAAABAA
 * <p>
 * <p>
 * <p>
 * ABAAAB  A가 3개 전체길이6
 * 5가답
 * 7이나옴
 * <p>
 * ABAAAAB A가 4개 전체길이 7
 * 5가 답
 * 8이 나옴
 * <p>
 * 즉 중간 A의 길이-1 만큼 답에서 빼줘야함
 * <p>
 * AAAAAB
 */
