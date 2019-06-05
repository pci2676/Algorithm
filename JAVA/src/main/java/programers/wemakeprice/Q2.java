package programers.wemakeprice;

import java.util.*;

public class Q2 {

    public static void main(String[] args) {
        int[][] customer = {{2, 1}, {1, 1}, {3, 1}, {1, 0}, {1, 1}, {2, 0}, {2, 1}};
        int K = 1;
        int[] answer;

        Queue<Integer> wait = new LinkedList<>();
        HashSet<Integer> reserve = new HashSet<>();


        //방에 넣을수 있으면 일단 다 넣고 못넣으면 대기명단으로 전부 넘기자
        for (int i = 0; i < customer.length; i++) {
            int id = customer[i][0];
            int status = customer[i][1];

            //대기자명단에 있는놈인지 아닌지
            if (wait.contains(id)) {
                //취소하는애야
                if (status == 0) {
                    for (int j = 0; j < wait.size(); j++) {
                        if (id == ((LinkedList<Integer>) wait).get(j)) {
                            wait.remove(j);
                        }
                    }
                }
            } else {
                //대기자명단에 없어
                if (status == 0) {
                    //취소한데
                    reserve.remove(id);
                    K++;
                } else {
                    //예약한데
                    //방에 공간이 있나?
                    if (K == 0) {
                        //없어
                        wait.add(id);
                    } else {
                        //있어
                        //대기열이 존재해?
                        if (!wait.isEmpty()) {
                            //존재해
                            reserve.add(wait.poll());
                            //기존에 있던거에서 돈게 아니니까 다시돌아야해
                            i--;
                            K--;
                            continue;
                        } else {
                            //없어
                            reserve.add(id);
                        }

                        K--;
                    }
                }
            }
        }


        List<Integer> ordered = new ArrayList<>(reserve);
        Collections.sort(ordered);
        answer = new int[ordered.size()];
        for (int i = 0; i < ordered.size(); i++) {
            answer[i] = ordered.get(i);
        }


        System.out.println(Arrays.toString(answer));
    }

    class Solution {
        public int[] solution(int[][] customer, int K) {
            int[] answer = {};

            // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
            System.out.println("Hello Java");

            return answer;
        }
    }

}


