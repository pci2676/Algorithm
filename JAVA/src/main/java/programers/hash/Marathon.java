package programers.hash;

import java.util.Arrays;

public class Marathon {
    public static void main(String[] args) {
        String[] participant = {"leo", "kiki", "eden", "eden"};
        String[] completion = {"kiki", "eden", "leo"};
        String answer = "";

        Arrays.sort(participant);
        Arrays.sort(completion);

        for (int i = 0; i < participant.length; i++) {
            if (!participant[i].equals(completion[i])) {
                answer = participant[i];
                break;
            }
        }

//        LinkedList<String> runner = new LinkedList<>(Arrays.asList(participant));
//        List<String> done = new LinkedList<>(Arrays.asList(completion));
//
//        done.parallelStream()
//                .forEach(one -> runner.removeFirstOccurrence(one));
//
//        answer = runner.getFirst();

        System.out.println(answer);
    }

    class Solution {
        public String solution(String[] participant, String[] completion) {
            String answer = "";
            return answer;
        }
    }


}
