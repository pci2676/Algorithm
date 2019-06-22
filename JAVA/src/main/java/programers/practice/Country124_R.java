package programers.practice;

public class Country124_R {

    private static final int CIRCULAR = 3;

    public static void main(String[] args) {
        int n = 16; //16-> 5,1  1,2,1

        String answer = "";

        int mok = 0;
        int namuji = 0;

        while (n > 0) {
            mok = n / CIRCULAR;
            namuji = n % CIRCULAR;

            if (namuji == 0) {
                mok--;
                namuji = 4;
            }
            answer = namuji + answer;
            n = mok;
        }

        System.out.println(answer);
    }

    class Solution {
        public String solution(int n) {
            String answer = "";
            return answer;
        }
    }
}
