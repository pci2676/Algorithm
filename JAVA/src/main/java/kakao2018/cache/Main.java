package kakao2018.cache;

import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.solution(3, new String[]{"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA"}) == 50);
    }

}

class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;

        Cache cache = new Cache(cacheSize);

        int time = 0;
        for (String city : cities) {
            time += cache.search(city);
        }
        answer = time;

        return answer;
    }
}


class Cache {
    private static final int HIT = 1;
    private static final int NOT_HIT = 5;

    private Queue<String> cache;
    private int size;

    public Cache(int size) {
        this.cache = new LinkedList<>();
        this.size = size;
    }

    public int search(String item) {
        item = item.toLowerCase();
        if (has(item)) {
            update(item);
            return HIT;
        }
        insert(item);
        return NOT_HIT;
    }

    private boolean has(String item) {
        return cache.contains(item);
    }

    private void update(String item) {
        cache.remove(item);
        cache.offer(item);
    }

    private void insert(String item) {
        if (size == 0) {
            return;
        }
        if (isFull()) {
            cache.poll();
        }
        cache.offer(item);
    }

    private boolean isFull() {
        return cache.size() >= size;
    }
}