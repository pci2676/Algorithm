package woowatechcourse.q2;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.equals(solution.solution("2019/05/01 00:59:19\n" +
                "2019/06/01 01:35:20\n" +
                "2019/08/01 02:01:22\n" +
                "2019/08/01 02:01:23\n" +
                "2019/08/02 03:02:35\n" +
                "2019/10/03 04:05:40\n" +
                "2019/10/04 06:23:10\n" +
                "2019/10/10 08:23:20\n" +
                "2019/10/12 08:42:24\n" +
                "2019/10/23 08:43:26\n" +
                "2019/11/14 08:43:29\n" +
                "2019/11/01 10:19:02\n" +
                "2019/12/01 11:23:10"), new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 2, 1, 1, 0, 1, 0, 4, 0, 1, 1, 0, 0, 0}));
    }
}

class Solution {
    public int[] solution(String logs) {
        int[] answer = {};
        String[] allLogs = logs.split("\n");
        List<Integer> allHours = Arrays.stream(allLogs)
                .map(Log::getHour)
                .collect(Collectors.toList());

        answer = new int[24];
        for (int hour : allHours) {
            answer[hour]++;
        }
        return answer;
    }
}

class Log {
    public static int getHour(String log) {
        String[] dayAndTimes = log.split(" ");
        String time = dayAndTimes[1];
        String hour = time.substring(0, 2);
        int hourValue = Integer.parseInt(hour) + 9;
        if (hourValue >= 24) {
            return hourValue - 24;
        }
        return hourValue;
    }
}


