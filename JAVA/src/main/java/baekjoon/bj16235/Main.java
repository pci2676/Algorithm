package baekjoon.bj16235;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static Land land;

    public static void main(String[] args) throws IOException {
        // n 크기의 땅에 5의 양분 기본
        // r과 c 는 1부터 시작
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        //N개의 줄에 A 배열의 값이 주어짐 로봇이 뿌릴 양분 정보
        Integer[][] nutrition = new Integer[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                nutrition[j][i] = Integer.parseInt(st.nextToken());
            }
        }
        S2D2 s2d2 = new S2D2(nutrition);

        land = new Land(N);
        //M개의 줄에 나무의 정보 (x,y),z(나이)
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());
            Tree tree = new Tree(z);
            land.plantTree(tree, x, y);
        }

        for (int year = 0; year < K; year++) {
            //봄
            land.takeSpring();
            //여름
            land.takeSummer();
            //가을
            land.takeFall();
            //겨울
            land.takeWinter(s2d2);
        }

        int alive = land.getAliveTrees();
        System.out.println(alive);
    }

}

class Land {
    private static final int[] OCT_X =
            {-1, 0, 1,
                    -1, 1,
                    -1, 0, 1};
    private static final int[] OCT_Y =
            {-1, -1, -1,
                    0, 0,
                    1, 1, 1};

    private Soil[][] soils;

    public Land(int size) {
        init(size);
    }

    private void init(int size) {
        this.soils = new Soil[size + 2][size + 2];
        for (int y = 0; y <= size + 1; y++) {
            for (int x = 0; x <= size + 1; x++) {
                makeIn(x, y);
                makeOut(x, y, size);
            }
        }
    }

    private void makeIn(int x, int y) {
        this.soils[x][y] = Soil.makeInSoil(x, y);
    }

    private void makeOut(int x, int y, int size) {
        if (x == 0 || x == size + 1 || y == 0 || y == size + 1) {
            this.soils[x][y] = Soil.makeOutSoil(x, y);
        }
    }

    public void plantTree(Tree tree, int x, int y) {
        this.soils[x][y].plant(tree);
    }


    public void propagate(Coordinate coordinate) {
        int x = coordinate.getX();
        int y = coordinate.getY();
        for (int i = 0; i < 8; i++) {
            int dx = x + OCT_X[i];
            int dy = y + OCT_Y[i];
            Tree tree = new Tree(1);
            Soil soil = soils[dx][dy];
            if (soil.isUsable()) {
                soil.plant(tree);
            }
        }
    }

    public void takeSpring() {
        int size = soils.length - 2;
        for (int y = 1; y <= size; y++) {
            for (int x = 1; x <= size; x++) {
                soils[x][y].comeSpring();
            }
        }
    }

    public void takeSummer() {
        int size = soils.length - 2;
        for (int y = 1; y <= size; y++) {
            for (int x = 1; x <= size; x++) {
                soils[x][y].comeSummer();
            }
        }
    }

    public void takeFall() {
        int size = soils.length - 2;
        for (int y = 1; y <= size; y++) {
            for (int x = 1; x <= size; x++) {
                soils[x][y].comeFall();
            }
        }
    }

    public void takeWinter(S2D2 s2D2) {
        fillNutrition(s2D2);
    }

    private void fillNutrition(S2D2 s2D2) {
        int size = soils.length - 2;
        for (int y = 1; y <= size; y++) {
            for (int x = 1; x <= size; x++) {
                int nutrition = s2D2.getNutrition(x - 1, y - 1);
                soils[x][y].fillNutrition(nutrition);
                soils[x][y].fillLand(this);
            }
        }
    }

    public int getAliveTrees() {
        int size = soils.length - 2;
        int alive = 0;
        for (int y = 1; y <= size; y++) {
            for (int x = 1; x <= size; x++) {
                alive += soils[x][y].getAliveTrees();
            }
        }
        return alive;
    }
}

class Soil {

    private Coordinate coordinate;
    private Integer nutrition;
    private boolean usable;
    private Land land;
    private Queue<Tree> trees;

    public Soil(Integer x, Integer y, Integer nutrition, boolean usable) {
        this.coordinate = new Coordinate(x, y);
        this.trees = new LinkedList<>();
        this.nutrition = nutrition;
        this.usable = usable;
    }

    public static Soil makeOutSoil(int x, int y) {
        return new Soil(x, y, 0, false);
    }

    public static Soil makeInSoil(int x, int y) {
        return new Soil(x, y, 5, true);
    }

    public Integer getNutrition() {
        return nutrition;
    }

    public boolean isUsable() {
        return usable;
    }

    public void fillLand(Land land) {
        this.land = land;
    }

    public void plant(Tree tree) {
        this.trees.offer(tree);
        tree.planted(this);
    }

    public void giveNutrition(Tree tree) {
        this.nutrition -= tree.getAge();
    }

    public void fillNutrition(int nutrition) {
        this.nutrition += nutrition;
    }

    public void comeSpring() {
        if (this.trees.isEmpty()) {
            return;
        }

        PriorityQueue<Tree> treePriorityQueue = new PriorityQueue<>();

        while (!this.trees.isEmpty()) {
            treePriorityQueue.offer(this.trees.poll());
        }

        while (!treePriorityQueue.isEmpty()) {
            Tree tree = treePriorityQueue.poll();
            tree.aging();
            trees.offer(tree);
        }
    }

    public void comeSummer() {
        if (this.trees.isEmpty()) {
            return;
        }
        int size = this.trees.size();
        for (int i = 0; i < size; i++) {
            Tree tree = trees.poll();
            if (tree.isAlive()) {
                trees.offer(tree);
                continue;
            }
            int nutrition = tree.getAge() / 2;
            this.nutrition += nutrition;
        }
    }

    public void comeFall() {
        if (this.trees.isEmpty()) {
            return;
        }
        int size = this.trees.size();
        for (int i = 0; i < size; i++) {
            Tree tree = trees.poll();
            propagate(tree);
            trees.offer(tree);
        }
    }

    private void propagate(Tree tree) {
        if (tree.canPropagate()) {
            this.land.propagate(this.coordinate);
        }
    }


    public int getAliveTrees() {
        return this.trees.size();
    }

}

class Tree implements Comparable<Tree> {

    private Integer age;

    private boolean alive = true;
    private Soil soil;

    public Tree(Integer age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public boolean isAlive() {
        return alive;
    }

    private boolean canTake(int restNutrition) {
        return restNutrition >= this.age;
    }

    public boolean canPropagate() {
        return this.age % 5 == 0;
    }

    public void death() {
        this.alive = false;
    }

    public void planted(Soil soil) {
        this.soil = soil;
    }

    public void aging() {
        int restNutrition = this.soil.getNutrition();
        if (!canTake(restNutrition)) {
            death();
            return;
        }
        this.soil.giveNutrition(this);
        this.age++;
    }

    @Override
    public int compareTo(Tree o) {
        return this.age.compareTo(o.age);
    }


}

class S2D2 {

    private Integer[][] nutrition;

    public S2D2(Integer[][] nutrition) {
        this.nutrition = nutrition;
    }

    public int getNutrition(int x, int y) {
        return nutrition[x][y];
    }


}

class Coordinate {
    private Integer x;
    private Integer y;

    public Coordinate(Integer x, Integer y) {
        this.x = x;
        this.y = y;
    }

    public Integer getX() {
        return x;
    }

    public Integer getY() {
        return y;
    }
}
//10 100 10
//2 3 2 3 2 2 3 2 3 2
//2 3 2 3 2 2 3 2 3 2
//2 3 2 3 2 2 3 2 3 2
//2 3 2 3 2 2 3 2 3 2
//2 3 2 3 2 2 3 2 3 2
//2 3 2 3 2 2 3 2 3 2
//2 3 2 3 2 2 3 2 3 2
//2 3 2 3 2 2 3 2 3 2
//2 3 2 3 2 2 3 2 3 2
//2 3 2 3 2 2 3 2 3 2
//1 1 3
//1 1 3
//1 1 3
//1 1 3
//1 1 3
//1 1 3
//1 1 3
//1 1 3
//1 1 3
//1 1 3
//1 1 3
//1 1 3
//1 1 3
//1 1 3
//1 1 3
//1 1 3
//1 1 3
//1 1 3
//1 1 3
//1 1 3
//1 1 3
//1 1 3
//1 1 3
//1 1 3
//1 1 3
//1 1 3
//1 1 3
//1 1 3
//1 1 3
//1 1 3
//1 1 3
//1 1 3
//1 1 3
//1 1 3
//1 1 3
//1 1 3
//1 1 3
//1 1 3
//1 1 3
//1 1 3
//1 1 3
//1 1 3
//1 1 3
//1 1 3
//1 1 3
//1 1 3
//1 1 3
//1 1 3
//1 1 3
//1 1 3
//1 1 3
//1 1 3
//1 1 3
//1 1 3
//1 1 3
//1 1 3
//1 1 3
//1 1 3
//1 1 3
//1 1 3
//1 1 3
//1 1 3
//1 1 3
//1 1 3
//1 1 3
//1 1 3
//1 1 3
//1 1 3
//1 1 3
//1 1 3
//1 1 3
//1 1 3
//1 1 3
//1 1 3
//1 1 3
//1 1 3
//1 1 3
//1 1 3
//1 1 3
//1 1 3
//1 1 3
//1 1 3
//1 1 3
//1 1 3
//1 1 3
//1 1 3
//1 1 3
//1 1 3
//1 1 3
//1 1 3
//1 1 3
//1 1 3
//1 1 3
//1 1 3
//1 1 3
//1 1 3
//1 1 3
//1 1 3
//1 1 3
//1 1 3
