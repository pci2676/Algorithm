package swExpert;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class sw1245 {

    static final double M = 1;
    static final double G = 1;
    static double answer;
    static int[] magnet;
    static int[] m;
    static int magCount;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int test = Integer.parseInt(br.readLine());

        for (int t = 1; t <= test; t++) {

            answer = 0;
            magCount = Integer.parseInt(br.readLine());
            magnet = new int[magCount];
            m = new int[magCount];

            //입력 받기
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < magCount; i++) {
                magnet[i] = Integer.valueOf(st.nextToken());
            }
            for (int i = 0; i < magCount; i++) {
                m[i] = Integer.valueOf(st.nextToken());
            }

            answer = getAnswer(magnet[0], magnet[magCount - 1]);

            System.out.println("#" + t + " " + answer);
        }
    }

    private static double getAnswer(int left, int right) {
        double position = (double) (left + right) / 2;
        double error = getError((left + right) / 2);
        double fp = error - (int) error;
        //오차 분기
        if (error == 0 || fp < 0.0000000001)
            return position;

        if (error > 0) {
            position = getAnswer(left, (left + right) / 2);
        }
        if (error < 0) {
            position = getAnswer((left + right) / 2, right);
        }

        return position;
    }

    private static double getError(int point) {
        double error = 0;
        for (int i = 0; i < point; i++) {
            error -= (double) m[i] / Math.pow((point - magnet[i]), 2.0);
        }
        for (int i = point; i < magCount; i++) {
            error += (double) m[i] / Math.pow((magnet[i] - point), 2.0);
        }

        return error;
    }

    /*
    오차한계까지 계산

     */
    //G*m1*m2/(d1*d2)

}
