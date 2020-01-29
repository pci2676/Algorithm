package kakao2019.failrate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.equals(solution.solution(5, new int[]{2, 1, 2, 6, 2, 4, 3, 3}), new int[]{3, 4, 2, 1, 5}));
    }
}

//실패율은 다음과 같이 정의한다.
//스테이지에 도달했으나 아직 클리어하지 못한 플레이어의 수 / 스테이지에 도달한 플레이어 수
//전체 스테이지의 개수 N,
// 게임을 이용하는 사용자가 현재 멈춰있는 스테이지의 번호가 담긴 배열 stages가 매개변수로 주어질 때,
// 실패율이 높은 스테이지부터 내림차순으로 스테이지의 번호가 담겨있는 배열을 return 하도록 solution 함수를 완성하라.
class Solution {
    public int[] solution(int N, int[] stages) {
        int[] answer = {};

        List<Stage> stageList = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            stageList.add(new Stage(i));
        }

        for (Stage stage : stageList) {
            for (int number : stages) {
                stage.put(number);
            }
        }

        Collections.sort(stageList);

        answer = new int[N];
        for (int i = 0; i < stageList.size(); i++) {
            answer[i] = stageList.get(i).getNumber();
        }

        return answer;
    }
}

class Stage implements Comparable<Stage> {
    private int number;
    private double reach;
    private double fail;

    public Stage(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public void put(int number) {
        if (number == this.number) {
            addFail();
            return;
        }
        if (number > this.number) {
            addReach();
        }
    }

    private void addReach() {
        reach++;
    }

    private void addFail() {
        fail++;
        addReach();
    }

    public double getFailRate() {
        if (fail == 0) {
            return 0;
        }
        return fail / reach;
    }

    @Override
    public int compareTo(Stage o) {
        int result = Double.compare(o.getFailRate(), getFailRate());
        if (result == 0) {
            return Integer.compare(this.number, o.number);
        }
        return result;
    }

}