package programers.winter2018.cookie;

import java.util.ArrayList;
import java.util.List;

public class BuyingCookie {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] cookie1 = {1, 1, 2, 3};
        int[] cookie2 = {1, 2, 4, 5};
        System.out.println(solution.solution(cookie1) == 3);
        System.out.println(solution.solution(cookie2) == 0);
    }


}

class Solution {
    public int solution(int[] cookie) {
        int answer = 0;


        List<Cookie> cookieList = new ArrayList<>();
        for (int value : cookie) {
            Cookie myCookie = new Cookie(value);
            cookieList.add(myCookie);
        }

        CookieBundle cookieBundle = new CookieBundle(cookieList.size());
        for (int i = 0; i < cookie.length; i++) {
            int start = i;
            for (int j = start + 1; j < cookie.length; j++) {
                int end = j;
                cookieBundle.make(cookieList, start, end);
                int afterAnswer = cookieBundle.getMax(answer);
                answer = getAnswer(answer, afterAnswer);
            }
        }

        return answer;
    }

    private int getAnswer(int beforeAnswer, int afterAnswer) {
        if (beforeAnswer < afterAnswer) {
            return afterAnswer;
        }
        return beforeAnswer;
    }
}

class Cookie {
    private Integer amount;

    public Cookie(Integer amount) {
        this.amount = amount;
    }

    public Integer getAmount() {
        return amount;
    }
}

class CookieBundle {

    private List<Cookie> cookies = new ArrayList<>();
    private Integer[] cookiesSum;

    public CookieBundle(int length) {
        this.cookiesSum = new Integer[length];
    }

    public void make(List<Cookie> cookies, int start, int end) {
        this.cookies = cookies.subList(start, end + 1);
    }

    public int getMax(int answer) {

        int sum = this.cookies.stream()
                .mapToInt(Cookie::getAmount)
                .sum();

        if (answer > sum) {
            return answer;
        }

        if (sum % 2 == 1) {
            return answer;
        }

        int half = sum / 2;

        int check = 0;
        for (Cookie cookie : cookies) {
            check += cookie.getAmount();
            if (check > half) {
                break;
            }
            answer = getAnswer(half, check, answer);
        }
        return answer;
    }

    private int getAnswer(int half, int check, int answer) {
        if (half == check) {
            return half;
        }
        return answer;
    }
}