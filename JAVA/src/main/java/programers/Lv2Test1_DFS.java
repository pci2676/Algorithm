package programers;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Lv2Test1_DFS {

    /**
     * dfs 문제였다
     * dfs 는 모든 방향에 대한 탐색을 진행하는데
     * 이 문제는 모든 노드가 연결되어있다고 생각하고 풀어야했다.
     * 삽질 개많이함;;;
     */

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String numbers = br.readLine();
        List<Integer> each = Arrays.stream(numbers.split(""))
                .map(Integer::valueOf)
                .collect(Collectors.toList());

        Set<Integer> answers = new HashSet<>();

        List<Integer> picked = new ArrayList<>();

        dfs(each, picked, answers, -1);

        int answer = (int) answers.stream()
                .filter(Lv2Test1_DFS::isPrime)
                .count();

        System.out.println(answer);
    }

    private static void dfs(List<Integer> numbers, List<Integer> picked, Set<Integer> answers, int index) {
        addPick(picked, index);

        addAnswer(numbers, picked, answers);

        for (int i = 0; i < numbers.size(); i++) {
            if (picked.contains(i)) {
                continue;
            }
            dfs(numbers, picked, answers, i);
        }

        removePick(picked, index);
    }

    private static void addPick(List<Integer> picked, int index) {
        if (index != -1) {
            picked.add(index);
        }
    }

    private static void addAnswer(List<Integer> numbers, List<Integer> picked, Set<Integer> answers) {
        int answer = 0;
        for (int pick : picked) {
            answer = answer * 10 + numbers.get(pick);
        }
        answers.add(answer);
    }

    private static void removePick(List<Integer> picked, int index) {
        if (index != -1) {
            picked.remove(picked.size() - 1);
        }
    }

    private static boolean isPrime(int maybe) {
        if (maybe == 1 || maybe == 0) {
            return false;
        }
        if (maybe == 2) {
            return true;
        }
        for (int i = 3; i < maybe; i++) {
            if (maybe % i == 0) {
                return false;
            }
        }
        return true;
    }
}
