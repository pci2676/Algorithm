package swExpert;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class sw1218 {

    static int[] maxDistance = new int[10];
    static List<String> list;
    static HashMap<String, String> map = new HashMap<>();

    static {
        map.put(")", "(");
        map.put("}", "{");
        map.put("]", "[");
        map.put(">", "<");
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        for (int t = 0; t < 10; t++) {
            maxDistance[t] = 1;
            list = new LinkedList<>();

            int length = scanner.nextInt();
            String all = scanner.next();
            String[] unit = all.split("");


            for (int i = 0; i < length; i++) {
                String token = unit[i];
                if (map.containsKey(token)) {
                    pop(token, t);
                } else {
                    push(token);
                }
            }

            System.out.println("#" + (t + 1) + " " + maxDistance[t]);

        }

    }

    private static void push(String token) {
        list.add(token);
    }

    private static void pop(String token, int index) {
        String top = list.get(list.size() - 1);
        if (top.equals(map.get(token))) {
            list.remove(list.size() - 1);
        } else {
            maxDistance[index] = 0;
        }
    }

}
