package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class bj10809 {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
        String line = br.readLine();
        String[] arr = line.split("");
        Map<Integer, Integer> map;
        map = putMap(arr);

        for (int i = 'a'; i <= 'z'; i++) {
            if(map.containsKey(i)){
                System.out.print(map.get(i)+" ");
            }else{
                System.out.print(-1+" ");
            }
        }
    }

    private static Map<Integer, Integer> putMap(String[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey((int)arr[i].charAt(0))) {
                continue;
            }
            map.put((int)arr[i].charAt(0), i);
        }
        return map;
    }
}
