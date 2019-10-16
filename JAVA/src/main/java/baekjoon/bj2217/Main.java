package baekjoon.bj2217;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
        int n = Integer.parseInt(br.readLine());
        List<Rope> ropes = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int endurance = Integer.parseInt(br.readLine());
            Rope rope = new Rope(endurance);
            ropes.add(rope);
        }
        ropes.sort(Rope::compareTo);

        int size = ropes.size();

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < size; i++) {
            int nowSize = size - i;
            int nowEndurance = ropes.get(i).getEndurance() * nowSize;
            max = Math.max(max, nowEndurance);
        }
        System.out.println(max);

    }

}

class Rope implements Comparable<Rope> {

    private Integer endurance;

    public Rope(int endurance) {
        this.endurance = endurance;
    }

    public Integer getEndurance() {
        return endurance;
    }

    @Override
    public int compareTo(Rope o) {
        return endurance.compareTo(o.endurance);
    }
}
