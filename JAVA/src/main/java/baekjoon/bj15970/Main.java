package baekjoon.bj15970;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
        int n = Integer.parseInt(br.readLine());

        List<Point> points = new ArrayList<>();

        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int position = Integer.parseInt(st.nextToken());
            int color = Integer.parseInt(st.nextToken());
            Point point = new Point(position, color);
            points.add(point);
        }

        points.sort(Point::compareTo);

        for (int i = 0; i < n; i++) {
            Point point = points.get(i);
            for (int j = i + 1; j < n; j++) {
                Point nextPoint = points.get(j);
                if (nextPoint.isSameColor(point)) {
                    point.changeMin(nextPoint);
                    nextPoint.changeMin(point);
                    break;
                }
            }

        }

        //합
        int sum = points.stream()
                .mapToInt(Point::getMin)
                .sum();
        System.out.println(sum);
    }
}

class Point implements Comparable<Point> {
    private Integer position;
    private int color;
    private int min = Integer.MAX_VALUE;

    public Point(int position, int color) {
        this.position = position;
        this.color = color;
    }

    public int getMin() {
        return min;
    }

    public void changeMin(Point point) {
        int distance = Math.abs(this.position - point.position);
        this.min = Math.min(this.min, distance);
    }

    public boolean isSameColor(Point point) {
        return this.color == point.color;
    }

    @Override
    public int compareTo(Point o) {
        return position.compareTo(o.position);
    }
}
