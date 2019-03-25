import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
3
26 40 83
49 60 57
13 89 99
 */
public class bj1149 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.valueOf(br.readLine());
        int[][] ac = new int[3][N];

        String line = br.readLine();
        int[] temp = Arrays.stream(line.split(" "))
                .mapToInt(Integer::valueOf)
                .toArray();

        ac[0][0] = temp[0]; //r
        ac[1][0] = temp[1]; //g
        ac[2][0] = temp[2]; //b

        for (int i = 1; i < N; i++) {
            line = br.readLine();
            temp = Arrays.stream(line.split(" "))
                    .mapToInt(Integer::valueOf)
                    .toArray();
            int red = temp[0];
            int green = temp[1];
            int blue = temp[2];

            ac[0][i] = red + Math.min(ac[1][i - 1], ac[2][i - 1]);
            ac[1][i] = green + Math.min(ac[0][i - 1], ac[2][i - 1]);
            ac[2][i] = blue + Math.min(ac[0][i - 1], ac[1][i - 1]);
        }

        int answer = Math.min(ac[0][N - 1], Math.min(ac[1][N - 1], ac[2][N - 1]));
        System.out.println(answer);
    }


}
