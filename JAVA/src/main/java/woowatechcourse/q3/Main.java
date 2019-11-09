package woowatechcourse.q3;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(new int[]{13000, 88000, 10000}, new int[]{30, 20}) == 82000);
    }
}

class Solution {
    public int solution(int[] prices, int[] discounts) {
        int answer = 0;
        PriorityQueue<Price> allPrice = new PriorityQueue<>();
        for (int price : prices) {
            allPrice.offer(new Price(price));
        }

        PriorityQueue<Coupon> coupons = new PriorityQueue<>();
        for (int discount : discounts) {
            coupons.offer(new Coupon(discount));
        }

        List<Combine> combines = makeCombine(allPrice, coupons);
        answer = combines.stream()
                .map(Combine::getPrice)
                .reduce(0, Integer::sum);
        return answer;
    }

    private List<Combine> makeCombine(PriorityQueue<Price> allPrice, PriorityQueue<Coupon> coupons) {
        List<Combine> combines = new ArrayList<>();
        while (!allPrice.isEmpty()) {
            Price price = allPrice.poll();
            Coupon coupon = null;
            if (!coupons.isEmpty()) {
                coupon = coupons.poll();
            }
            Combine combine = new Combine(price, coupon);
            combines.add(combine);
        }
        return combines;
    }
}

class Price implements Comparable<Price> {

    private int price;

    public Price(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    public int getDiscountedPrice(Coupon coupon) {
        int price = this.price / 100 * (100 - coupon.getDisCount());
        return price;
    }

    @Override
    public int compareTo(Price o) {
        return Integer.compare(o.price, this.price);
    }
}

class Coupon implements Comparable<Coupon> {

    private int disCount;

    public Coupon(int disCount) {
        this.disCount = disCount;
    }

    public int getDisCount() {
        return disCount;
    }

    @Override
    public int compareTo(Coupon o) {
        return Integer.compare(o.disCount, this.disCount);
    }
}


class Combine {
    private Price price;
    private Coupon coupon;

    public Combine(Price price, Coupon coupon) {
        this.price = price;
        this.coupon = coupon;
    }

    public int getPrice() {
        if (coupon == null) {
            return price.getPrice();
        }
        return price.getDiscountedPrice(this.coupon);
    }
}


