package programers.hash;

import java.util.Hashtable;

public class Camouflage {
    class Solution {
        public int solution(String[][] clothes) {
            int answer = 0;
            return answer;
        }
    }

    public static void main(String[] args) {
        int answer = 0;
        String[][] clothes = {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}};

        Hashtable<String, Integer> closet = new Hashtable<>();

        for (String[] clothe : clothes) {
            String category = clothe[1];
            int count = closet.getOrDefault(category, 1);
            closet.put(category, count + 1);
        }

        int combination = 1;
        for (int value : closet.values()) {
            combination = combination * value;
        }
        answer = combination - 1;

        System.out.println(answer);
    }
}
