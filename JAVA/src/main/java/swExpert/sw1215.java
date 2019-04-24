package swExpert;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class sw1215 {

    static int answer;
    static int target;
    static String map[][];
    static List<String> palindrom = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int test = 1; test <= 10; test++) {
            answer = 0;

            target = Integer.valueOf(br.readLine());

            String line = br.readLine();
            int size = line.length();
            map = new String[size][size];

            map[0] = line.split("");
            for (int i = 1; i < size; i++) {
                line = br.readLine();
                map[i] = line.split("");
            }

            for (int y = 0; y < size; y++) {
                for (int x = 0; x < size; x++) {

                    for (int i = 0; i < target; i++) {
                        if (x + i == size) {
                            palindrom.clear();
                            break;
                        }
                        palindrom.add(map[y][x + i]);
                    }

                    check(palindrom.size());

                    for (int i = 0; i < target; i++) {
                        if (y + i == size) {
                            palindrom.clear();
                            break;
                        }
                        palindrom.add(map[y + i][x]);
                    }

                    check(palindrom.size());

                }
            }


            System.out.println(String.format("#%d %d", test, answer));
        }
    }

    private static void check(int size) {


        int start = 0;
        int last = palindrom.size() - 1;

        boolean flag = true;
        if (size == 0) {
            flag = false;
        }

        for (int i = 0; i < palindrom.size() / 2; i++) {
            if (!palindrom.get(start + i).equals(palindrom.get(last - i))) {
                flag = false;
                break;
            }
        }

        if (flag) {
            answer++;
        }
        palindrom.clear();
    }

}
