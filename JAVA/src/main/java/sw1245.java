import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class sw1245 {

    static double answer;
    static int[][] magnet;
    static int magCount;
    static final double M = 1;
    static final double G = 1;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int test = Integer.parseInt(br.readLine());

        for (int t = 1; t <= test; t++) {

            answer = 0;
            magCount = Integer.parseInt(br.readLine());
            magnet = new int[magCount][2];
            String all = br.readLine();
            int[] intAll = Arrays.stream(all.split(" "))
                    .mapToInt(Integer::new).toArray();
            for (int x = 0; x < magCount; x++) {
                magnet[x][1] = intAll[x];
                magnet[x][2] = intAll[magCount + x];
            }

            getX();

            System.out.println("#" + t + " " + answer);
        }
    }

    /*
    1. 모든x 좌표의 중간지점을 초기값으로 시작
    2. 가중치 총합 계산
    2-1. 가중치가 음수면 왼쪽으로 1이동
    2-2. 가중치가 양수면 오른쪽으로 1이동
    2-3. x 좌표의 값이 방금전에 이동한값과 다음에 이동할값이 같으면 적은 숫자에서 소수점계산단계로 넘어간다.
    -----소수점계산단계
    지정된 x 좌표에서
    3-0. 오차의 한계까지 왔다면 탐색 중지
    3. 소수점 5부터 가중치 계산시작
    4. 가중치 계산방향으로 1씩 이동
    4-1. 가중치 계산했는데 이동방향이 바뀌면 진행방향에따라서 작은값 큰값으로 고정 그아래 소수점으로 이동 -->3
     */

    private static void getX() {
        double sum = 0;
        for (int i = 0; i < magCount; i++) {
            sum += magnet[i][1];
        }
        double middle = sum/magCount;
    }

    private static double getWeight(int x, int[] someMagnet) {
        //G*m1*m2/(d1*d2)
        double d = Math.abs(x - someMagnet[0]);
        double m = (double) someMagnet[1];
        return G * M * m / (d * d);
    }
}
