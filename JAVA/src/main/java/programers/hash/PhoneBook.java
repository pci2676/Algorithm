package programers.hash;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class PhoneBook {
    public static void main(String[] args) {
        String[] phone_book = {"123", "456", "789"};
        boolean answer = true;

        List<String> book = new LinkedList<>(Arrays.asList(phone_book));

        for (int i = 0; i < phone_book.length; i++) {
            String prefix = phone_book[i];

            for (int j = 0; j < phone_book.length; j++) {
                String compare = phone_book[j];
                if (prefix.equals(compare)) {
                    continue;
                }
                if (compare.startsWith(prefix)) {
                    answer = false;
                    break;
                }
            }
            if (!answer) {
                break;
            }
        }

        System.out.println(answer);
    }

    class Solution {
        public boolean solution(String[] phone_book) {
            boolean answer = true;
            return answer;
        }
    }

}
