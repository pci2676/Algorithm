package swExpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class sw8016 {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {

        int T = Integer.valueOf(br.readLine());

        for (int t = 1; t <= T; t++) {

            int k = Integer.valueOf(br.readLine());

            BigInteger bLeft = BigInteger.valueOf(k).subtract(BigInteger.valueOf(1L));
            BigInteger bRight = BigInteger.valueOf(k);

            BigInteger left = bLeft.multiply(bLeft).multiply(BigInteger.valueOf(2L)).add(BigInteger.ONE);
            BigInteger right = bRight.multiply(bRight).multiply(BigInteger.valueOf(2L)).subtract(BigInteger.ONE);
            //1+()

            System.out.println(String.format("#%d %d %d", t, left, right));
        }
    }
}
