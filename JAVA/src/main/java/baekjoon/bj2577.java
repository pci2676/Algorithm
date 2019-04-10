package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class bj2577 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		long a = Integer.valueOf(br.readLine());
		long b = Integer.valueOf(br.readLine());
		long c = Integer.valueOf(br.readLine());

		long d = a * b * c;

		int[] answer = new int[100];
		int index;
		while (d != 0) {
			index = (int) d % 10;
			answer[index]++;
			d = d / 10;
		}

		for (int i = 0; i < 10; i++) {
			System.out.println(answer[i]);
		}

	}

}
