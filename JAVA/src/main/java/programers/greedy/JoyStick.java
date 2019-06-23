package programers.greedy;

public class JoyStick {

    private static final int ENGLISH_AMOUNT = 26;
    private static final int HALF_OF_ENGLISH = 13;
    private static final int JOYSTICK_MOVE = 1;

    public static void main(String[] args) {
        String name = "AABBAA";
        int answer = 0;

        char[] input = new char[name.length()];
        for (int i = 0; i < input.length; i++) {
            input[i] = 'A';
        }

        //전부 A인지 확인
        if (name.equals(new String(input))) {
            //return answer;
        }

        //시작위치 왼쪽이나 오른쪽으로 A가 연속으로 있는지 확인
        int dontMove = getACount(name);

        for (int i = 0; i < name.length(); i++) {
            int def = name.charAt(i) - input[i];
            if (def > HALF_OF_ENGLISH) {
                def = ENGLISH_AMOUNT - def;
            }
            answer = answer + def + JOYSTICK_MOVE;
        }
        answer = answer - JOYSTICK_MOVE - dontMove;

        System.out.println(answer);
    }

    private static int getACount(String name) {

        //오른쪽 A구하기
        int right = 0;
        for (int i = 1; i < name.length(); i++) {
            if (name.charAt(i) == 'A') {
                right++;
            } else {
                break;
            }
        }

        //왼쪽 A구하기
        int left = 0;
        for (int i = name.length() - 1; i > 0; i--) {
            if (name.charAt(i) == 'A') {
                left++;
            } else {
                break;
            }
        }

        //큰것만 반환
        if (left > right) {
            return left;
        } else {
            return right;
        }
    }

    class Solution {
        public int solution(String name) {
            int answer = 0;
            return answer;
        }
    }
}
