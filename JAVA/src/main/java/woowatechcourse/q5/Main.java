package woowatechcourse.q5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.equals(solution.solution(new String[]{"1.0", "2.0", "1.5"}), new int[]{3000, 14000, 15000}));
        System.out.println(Arrays.equals(solution.solution(new String[]{"1.0", "2.0", "0.0", "1.0"}), new int[]{-1}));
    }
}

class Solution {
    private static List<Double> JUNE_EAT = Arrays.asList(1.0, 2.0);
    private static List<Double> LOVER_EAT = Arrays.asList(0.0, 0.5);

    public int[] solution(String[] history) {
        int[] answer = {};
        Refrigerator refrigerator = Refrigerator.getRefrigerator();

        List<Integer> prices = new ArrayList<>();
        List<Boolean> isJuneEat = new ArrayList<>();

        for (String amount : history) {
            June june = new June();
            Lover lover = new Lover();
            boolean eatJune = false;

            List<Double> eats = getEats(amount);
            int eachPrice = 0;
            for (Double eat : eats) {
                if (JUNE_EAT.contains(eat)) {
                    eachPrice += june.getCost(eat, refrigerator);
                    eatJune = true;
                    continue;
                }
                if (LOVER_EAT.contains(eat)) {
                    eachPrice += lover.getCost(eat, refrigerator);
                }
            }
            prices.add(eachPrice);
            isJuneEat.add(eatJune);

        }

        for (boolean isEat : isJuneEat) {
            if (isEat) {
                continue;
            }
            return new int[]{-1};
        }

        answer = new int[prices.size()];
        for (int i = 0; i < prices.size(); i++) {
            answer[i] = prices.get(i);
        }

        return answer;
    }

    public List<Double> getEats(String amount) {

        List<Double> result = new ArrayList<>();

        Double eats = Double.parseDouble(amount);
        while (eats > 0) {
            if (eats - JUNE_EAT.get(1) >= 0) {
                eats -= JUNE_EAT.get((1));
                result.add(JUNE_EAT.get(1));
                continue;
            }
            if (eats - JUNE_EAT.get(0) >= 0) {
                eats -= JUNE_EAT.get(0);
                result.add(JUNE_EAT.get(0));
                continue;
            }
            if (eats - LOVER_EAT.get(1) >= 0) {
                eats -= LOVER_EAT.get(1);
                result.add(LOVER_EAT.get(1));
                continue;
            }
            if (eats - LOVER_EAT.get(0) >= 0) {
                eats -= LOVER_EAT.get(0);
                result.add(LOVER_EAT.get(0));
                continue;
            }
        }
        return result;
    }
}

class Refrigerator {
    private Integer pigLeg;
    private Integer anion;
    private Integer greenAnion;
    private Integer garlic;
    private Integer chili;

    private Refrigerator(Integer pigLeg, Integer anion, Integer greenAnion, Integer garlic, Integer chili) {
        this.pigLeg = pigLeg;
        this.anion = anion;
        this.greenAnion = greenAnion;
        this.garlic = garlic;
        this.chili = chili;
    }

    public static Refrigerator getRefrigerator() {
        return new Refrigerator(5, 100, 10, 5, 2);
    }

    public void useJuneRecipe(double amount) {
        useRecipe(Recipe.pigLeg * amount, Recipe.anion * amount, Recipe.greenAnion * amount, Recipe.garlic * amount, Recipe.chili * amount);
    }

    public void useLoverRecipe(double amount) {
        useRecipe(Recipe.pigLeg * amount, Recipe.anion * amount, Recipe.greenAnion * amount, Recipe.garlic * amount, Recipe.chili / 2 * amount);
    }

    private void useRecipe(double pigLeg, double anion, double greenAnion, double garlic, double chili) {
        this.pigLeg = this.pigLeg - (int) Math.round(pigLeg);
        this.anion = this.anion - (int) Math.round(anion);
        this.greenAnion = this.greenAnion - (int) Math.round(greenAnion);
        this.garlic = this.garlic - (int) Math.round(garlic);
        this.chili = this.chili - (int) Math.round(chili);
    }

    public Integer getCost() {
        int price = 0;
        if (this.pigLeg < 0) {
            this.pigLeg += Market.pigLegBuyAmount;
            price += Market.pigLegPrice;
        }
        if (this.anion < 0) {
            this.anion += Market.anionBuyAmount;
            price += Market.anionPrice;
        }
        if (this.greenAnion < 0) {
            this.greenAnion += Market.greenAnionBuyAmount;
            price += Market.greenAnionPrice;
        }
        if (this.garlic < 0) {
            this.garlic += Market.garlicBuyAmount;
            price += Market.garlicPrice;
        }
        if (this.chili < 0) {
            this.chili += Market.chiliBuyAmount;
            price += Market.chiliPrice;
        }

        return price;
    }
}

class June {
    private int eatCount;

    public Integer getCost(double amount, Refrigerator refrigerator) {
        eatCount++;
        //냉장고 상황과 내가 먹을 양만큼의 레시피 감산
        refrigerator.useJuneRecipe(amount);
        // 음수인 냉장고 상황에 플러스가 되도록 재료사기
        // 재료살때 가격 합산헤서 반환
        return refrigerator.getCost();
    }

    public boolean dontEat() {
        return eatCount == 0;
    }
}

class Lover {

    public Integer getCost(double eat, Refrigerator refrigerator) {
        refrigerator.useLoverRecipe(eat);
        return refrigerator.getCost();
    }
}

class Recipe {
    public static Integer pigLeg = 4;
    public static Integer anion = 50;
    public static Integer greenAnion = 10;
    public static Integer garlic = 10;
    public static Integer chili = 4;
}

class Market {
    public static Integer pigLegPrice = 10000;
    public static Integer anionPrice = 3000;
    public static Integer greenAnionPrice = 1000;
    public static Integer garlicPrice = 2000;
    public static Integer chiliPrice = 1000;

    public static Integer pigLegBuyAmount = 10;
    public static Integer anionBuyAmount = 100;
    public static Integer greenAnionBuyAmount = 30;
    public static Integer garlicBuyAmount = 50;
    public static Integer chiliBuyAmount = 10;
}

