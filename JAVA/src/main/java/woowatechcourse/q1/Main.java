package woowatechcourse.q1;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] rest = new int[]{0, 0};
        int[][] riders = new int[][]{{-700, 0}, {150, 180}, {500, 500}, {150, -800}, {800, 800}, {-900, 500}, {-1100, 900}};
        System.out.println(solution.solution(rest, riders, 1000) == 4);
    }
}

class Solution {
    public int solution(int[] restaurant, int[][] riders, int k) {
        int answer = 0;

        ResTaurant resTaurant = new ResTaurant(restaurant[0], restaurant[1]);

        List<Rider> allRider = new ArrayList<>();
        for (int[] rider : riders) {
            allRider.add(new Rider(rider[0], rider[1]));
        }

        long maxDistance = k * k;
        answer = (int) allRider.parallelStream()
                .map(resTaurant::getDistance)
                .filter(distance -> distance <= maxDistance)
                .count();

        return answer;
    }
}

class ResTaurant {
    private int x;
    private int y;

    public ResTaurant(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public long getDistance(Rider rider) {
        return rider.getDistance(x, y);
    }

}

class Rider {
    private int x;
    private int y;

    public Rider(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public long getDistance(int x, int y) {
        long powX = (this.x - x) * (this.x - x);
        long powY = (this.y - y) * (this.y - y);
        return powX + powY;
    }
}
