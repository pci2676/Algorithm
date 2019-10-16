package programers.binsearch.budget;

import java.util.Arrays;

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
        Arrays.sort(budgets);
        BudgetPlan budgetPlan = new BudgetPlan(budgets);
        //전부 원하는 값 할당가능
        if (budgetPlan.canAllAllocate(M)) {
            return budgetPlan.getMaxOfBudgets();
        }

        //한곳도 원하는 값 할당 불가능
        if (budgetPlan.canNotAllocate(M)) {
            return budgetPlan.findMinBudget(M);
        }

        //일부만 할당 가능
        int size = budgetPlan.getBudgetsSize();
        int min = 0;
        int max = M;
        int preMid = 0;

        while (true) {
            int mid = (min + max) / 2;
            int overSize = size;
            long sum = 0;

            if (preMid == mid) {
                answer = mid;
                break;
            }

            for (int budget : budgets) {
                if (budget > mid) {
                    break;
                }
                sum += budget;
                overSize--;
            }

            long nowBudget = overSize * mid + sum;

            if (nowBudget > M) {
                max = mid;
                preMid = mid;
                continue;
            }
            if (nowBudget < M) {
                min = mid;
                preMid = mid;
                continue;
            }
            if (nowBudget == M) {
                answer = mid;
                break;
            }
        }

        return answer;
    }


    private boolean canNotAllocate(int[] budgets, int m) {
        return budgets[0] > m;
    }


    private boolean canAllocate(int[] budgets, int M) {
        long sum = 0;
        for (int budget : budgets) {
            sum += budget;
        }
        return sum <= M;
    }

    private int getMin(int[] budgets, int M) {
        int min = budgets[0];
        while (M < min * budgets.length) {
            min--;
        }
        return min;
    }

}

class BudgetPlan {

    private int[] budgets;
    private long[] budgetSums;
    private int maxBudget;

    public BudgetPlan(int[] budgets) {
        this.budgets = budgets;
        initBudgetSums();
    }

    private void initBudgetSums() {
        this.budgetSums = new long[budgets.length];
        budgetSums[0] = budgets[0];
        for (int i = 1; i < budgets.length; i++) {
            budgetSums[i] = budgetSums[i - 1] + budgets[i];
        }
    }

    public boolean canAllAllocate(int M) {
        return M >= budgetSums[budgetSums.length - 1];
    }

    public boolean canNotAllocate(int M) {
        return budgets[0] > M;
    }

    public int getMaxOfBudgets() {
        return budgets[budgets.length - 1];
    }

    public int findMinBudget(int M) {
        int min = budgets[0];
        while (M < min * budgets.length) {
            min--;
        }
        return min;
    }

    public int getBudgetsSize() {
        return this.budgets.length;
    }

    public int[] getBudgets() {
        return budgets;
    }

    public long[] getBudgetSums() {
        return budgetSums;
    }

    public int getMaxBudget() {
        return maxBudget;
    }


}


