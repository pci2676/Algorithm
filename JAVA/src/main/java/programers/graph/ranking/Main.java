package programers.graph.ranking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(5, new int[][]{{4, 3}, {4, 2}, {3, 2}, {1, 2}, {2, 5}}) == 2);
        System.out.println(solution.solution(5, new int[][]{{4, 5}, {3, 5}, {3, 4}, {2, 3}, {1, 2}}) == 5);
        System.out.println(solution.solution(5, new int[][]{{1, 2}, {2, 3}, {1, 3}, {4, 5}, {3, 5}}) == 1);
    }
}

class Solution {
    public int solution(int n, int[][] results) {
        int answer = 0;

        List<Boxer> boxers = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            Boxer boxer = new Boxer(i);
            boxers.add(boxer);
        }

        MatchHistory matchHistory = new MatchHistory(boxers);

        for (int[] result : results) {
            int winner = result[0];
            int loser = result[1];
            matchHistory.addHistory(winner, loser);
        }

        answer = matchHistory.getAllMatchBoxer(n);

        return answer;
    }
}

class Boxer {
    private int number;
    private Set<Boxer> weak = new HashSet<>(); // 내가 이긴 애들 == 나한테 진애들 == 약한애들
    private Set<Boxer> strong = new HashSet<>(); // 내가 진 애들 == 나한테 이긴애들 == 강한애들

    public Boxer(int number) {
        this.number = number;
    }

    public int getMatchCount() {
        Set<Boxer> loseMatch = new HashSet<>();
        Set<Boxer> winMatch = new HashSet<>();
        makeLoseMatch(this, loseMatch);
        makeWinMatch(this, winMatch);
        return loseMatch.size() + winMatch.size();
    }

    private void makeLoseMatch(Boxer boxer, Set<Boxer> loseMatch) {
        for (Boxer stronger : boxer.strong) {
            if (loseMatch.contains(stronger)) {
                continue;
            }
            makeLoseMatch(stronger, loseMatch);
        }
        loseMatch.addAll(boxer.strong);
    }

    private void makeWinMatch(Boxer boxer, Set<Boxer> winMatch) {
        for (Boxer weaker : boxer.weak) {
            if (winMatch.contains(weaker)) {
                continue;
            }
            makeWinMatch(weaker, winMatch);
        }
        winMatch.addAll(boxer.weak);
    }

    public void win(Boxer boxer) { // 내가 boxer 를 이겼다
        weak.add(boxer);// 내가 이긴애로 추가
        weak.addAll(boxer.weak); // 얘한테 진애들도 내가 다이김
    }

    public void lose(Boxer boxer) { // 내가 졌다
        strong.add(boxer); // 나보다 강하다
        strong.addAll(boxer.strong); // 강한애보다 강한애들은 나보다 강하다
    }

    public int getNumber() {
        return this.number;
    }

    @Override
    public String toString() {
        return "Boxer{" +
                "number=" + number +
                ", win=" + weak.stream().map(Boxer::getNumber).collect(Collectors.toList()) +
                ", lose=" + strong.stream().map(Boxer::getNumber).collect(Collectors.toList()) +
                '}';
    }

}

class MatchHistory {

    List<Boxer> boxers;

    public MatchHistory(List<Boxer> boxers) {
        this.boxers = boxers;
    }

    public int getAllMatchBoxer(int n) {
        return (int) boxers.stream()
                .filter(boxer -> boxer.getMatchCount() == n - 1)
                .count();
    }

    public void addHistory(int winnerNumber, int loserNumber) {
        Boxer winner = null;
        Boxer loser = null;
        for (Boxer boxer : boxers) {
            winner = findBoxer(winnerNumber, winner, boxer);
            loser = findBoxer(loserNumber, loser, boxer);
        }
        if (winner != null && loser != null) {
            winner.win(loser);
            loser.lose(winner);
        }
    }

    private Boxer findBoxer(int number, Boxer boxer, Boxer someBoxer) {
        if (someBoxer.getNumber() == number) {
            return someBoxer;
        }
        return boxer;
    }

}