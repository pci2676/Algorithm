package swExpert;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class sw1244 {

    static int chance;
    static int max;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCaseCount = Integer.parseInt(br.readLine());
        for (int t = 1; t <= testCaseCount; t++) {
            String input = br.readLine();
            String[] inputArr = input.split(" ");
            String[] inputNumber = inputArr[0].split("");

            chance = Integer.parseInt(inputArr[1]);
            int[] numbers = Arrays.stream(inputNumber).mapToInt(Integer::parseInt).toArray();
            max = 0;

            dfs(0, 0, 0, numbers);

            System.out.println("#" + t + " " + max);
        }
    }


    private static void dfs(int count, int p1, int p2, int[] numbers) {

        //교환횟수제한
        if (count > chance)
            return;
        if (count >= numbers.length) {
            if ((chance - numbers.length) % 2 == 0) {
                swapArray(numbers, p1, p2);
                setMax(numbers);
                return;
            }
        }

        //배열의 순서변경
        swapArray(numbers, p1, p2);
        //값비교
        if (count == chance) {
            setMax(numbers);
            return;
        }

        //순회
        for (int i = p1; i < numbers.length - 1; i++) {
            for (int j = 0; j < numbers.length; j++) {
                //제자리 바꾸기 못하게하기
                if (i == j) continue;
                //깊은 복사로 항상 새로운 객체 넘겨주기
                int[] transmit = new int[numbers.length];
                System.arraycopy(numbers, 0, transmit, 0, numbers.length);
                dfs(count + 1, i, j, transmit);
            }
        }

    }

    private static void swapArray(int[] arr, int p1, int p2) {
        int left = arr[p1];
        int right = arr[p2];
        arr[p1] = right;
        arr[p2] = left;
    }

    private static void setMax(int[] numbers) {
        int sum = 0;
        for (int i = 0; i < numbers.length; i++) {
            sum = sum * 10 + numbers[i];
        }
        if (sum > max)
            max = sum;
    }
}
