package programers.binsearch.budget;

import java.util.Arrays;
import java.util.Stack;

public class Budget {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] budgets = {120, 110, 140, 150};
        int M = 485;
        System.out.println(solution.solution(budgets, M) == 127);
    }
}

class Solution {

    public int solution(int[] budgets, int M) {
        int answer = 0;
        if (canAllocate(budgets, M)) {
            return Arrays.stream(budgets).max().getAsInt();
        }

        if (checkMin(budgets, M)) {
            return M / budgets.length;
        }

        Arrays.sort(budgets);

        Stack<Integer> budgetStack = new Stack<>();
        long sum = 0;
        for (int budget : budgets) {
            budgetStack.push(budget);
            sum += budget;
        }

        Stack<Integer> overBudgets = new Stack<>();
        int over = budgetStack.pop();
        sum -= over;
        overBudgets.push(over);

        while (isOver(budgetStack, overBudgets, sum, M)) {
            over = budgetStack.pop();
            overBudgets.push(over);
            sum -= over;
        }

        int overSize = overBudgets.size();
        int topOfRest = budgetStack.peek();

        while (M >= sum + overSize * topOfRest) {
            topOfRest++;
        }
        answer = topOfRest - 1;

        return answer;
    }

    private boolean checkMin(int[] budgets, int m) {
        long sum = 0;
        for (int budget : budgets) {
            sum += budget;
        }
        long each = sum / budgets.length;

        return each > m;
    }

    private boolean isOver(Stack<Integer> budgetStack, Stack<Integer> overBudgets, long sum, int M) {
        //남은거 다더한거에서 총예산 뺀거를 over한거의 개수로 나눈거가 남은거중에 젤 큰거보다 작으면됨
        int topOfRest = budgetStack.peek();
        int overSize = overBudgets.size();
        long restBudget = M - sum;
        long eachOver = restBudget / overSize;

        return eachOver <= topOfRest;
    }

    private boolean canAllocate(int[] budgets, int M) {
        long sum = 0;
        for (int budget : budgets) {
            sum += budget;
        }
        return sum <= M;
    }

}


