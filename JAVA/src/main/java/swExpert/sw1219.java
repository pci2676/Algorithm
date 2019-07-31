package swExpert;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class sw1219 {

    static HashMap<String, String> map1;
    static HashMap<String, String> map2;

    static List road;

    static int[] maxDistance;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        maxDistance = new int[10];

        for (int t = 0; t < 10; t++) {
            maxDistance[t] = 0;

            map1 = new HashMap<>();
            map2 = new HashMap<>();

            road = new LinkedList();


            int testCaseNumber = scanner.nextInt();
            int couple = scanner.nextInt();

            for (int i = 0; i < couple; i++) {
                String key = scanner.next();
                String value = scanner.next();
                if (!map1.containsKey(key)) {
                    map1.put(key, value);
                } else {
                    map2.put(key, value);
                }
            }

            search("0", t);

            System.out.println("#" + testCaseNumber + " " + maxDistance[t]);
        }

    }

    private static void search(String key, int index) {
        searchMap(map1, key, index);
        searchMap(map2, key, index);
        return;
    }

    private static void searchMap(HashMap<String, String> map, String key, int index) {
        if (!map.containsKey(key)) {
            return;
        } else {//map1에 key가 존재
            if (check(map, key)) {
                maxDistance[index] = 1;
                return;
            } else {
                search(map.get(key), index);
            }
        }
    }

    private static boolean check(HashMap<String, String> map, String k) {
        if (map.get(k).equals("99"))
            return true;
        return false;
    }

}
