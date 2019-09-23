package programers.heap;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class WheatFlour {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(4, new int[]{4, 10, 15}, new int[]{20, 5, 10}, 30));

    }

    static class Solution {
        public int solution(int stock, int[] dates, int[] supplies, int k) {
            int answer = 0;
            Queue<Wheat> wheats = new LinkedList<>();
            Queue<Wheat> priority = new PriorityQueue<>();
            int size = dates.length;
            for (int i = 0; i < size; i++) {
                wheats.offer(new Wheat(dates[i], supplies[i]));
            }
            int day = 0;

            while (true) {
                if (day == k) {
                    break;
                }
                day++;
                stock--;
                if (!wheats.isEmpty()) {
                    if (wheats.peek().getDate() == day) {
                        priority.offer(wheats.poll());
                    }
                }

                //재고가 다 떨어진 날이 왔네!
                if (stock == 0 && day != k) {
                    Wheat wheat = priority.poll();
                    stock += wheat.getSupply();
                    answer++;
                }
            }

            return answer;
        }
    }

    static class Wheat implements Comparable<Wheat> {
        private int date;
        private int supply;

        public Wheat(int date, int supply) {
            this.date = date;
            this.supply = supply;
        }

        public int getDate() {
            return date;
        }

        public int getSupply() {
            return supply;
        }

        @Override
        public int compareTo(Wheat o) {
            if (supply > o.supply) {
                return -1;
            }
            return 1;
        }

    }

}
