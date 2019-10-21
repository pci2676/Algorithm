package kakao2018.traffic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.solution(new String[]{
                "2016-09-15 01:00:04.001 2.0s",
                "2016-09-15 01:00:07.000 2s"}) == 1);
        System.out.println(solution.solution(new String[]{
                "2016-09-15 01:00:04.002 2.0s",
                "2016-09-15 01:00:07.000 2s"}) == 2);
        System.out.println(solution.solution(new String[]{
                "2016-09-15 20:59:57.421 0.351s",
                "2016-09-15 20:59:58.233 1.181s",
                "2016-09-15 20:59:58.299 0.8s",
                "2016-09-15 20:59:58.688 1.041s",
                "2016-09-15 20:59:59.591 1.412s",
                "2016-09-15 21:00:00.464 1.466s",
                "2016-09-15 21:00:00.741 1.581s",
                "2016-09-15 21:00:00.748 2.31s",
                "2016-09-15 21:00:00.966 0.381s",
                "2016-09-15 21:00:02.066 2.62s"}) == 7);
    }

}

class Solution {
    public int solution(String[] lines) {
        int answer = 0;
        List<KakaoLog> kakaoLogs = new ArrayList<>();

        for (String line : lines) {
            KakaoLog kakaoLog = new KakaoLog(line);
            kakaoLogs.add(kakaoLog);
        }

        List<TimeRange> timeRanges = kakaoLogs.stream()
                .map(KakaoLog::getTimeRanges)
                .flatMap(Collection::stream)
                .collect(Collectors.toList());

        for (TimeRange timeRange : timeRanges) {
            answer = getMax(answer, kakaoLogs, timeRange);
        }

        return answer;
    }

    private int getMax(int answer, List<KakaoLog> kakaoLogs, TimeRange timeRange) {
        int count = (int) kakaoLogs.parallelStream()
                .filter(kakaoLog -> kakaoLog.isBetween(timeRange))
                .count();

        if (count > answer) {
            answer = count;
        }

        return answer;
    }
}

class KakaoLog {
    private Double startTime;
    private Double endTime;

    public KakaoLog(String line) {
        String[] format = line.split(" ");
        String[] hms = format[1].split(":");
        Double hmsTime = getHmsTime(hms);
        Double costTime = getCostTime(format[2]);
        startTime = Double.parseDouble(String.format("%.3f", hmsTime - costTime + 0.001));
        endTime = Double.parseDouble(String.format("%.3f", hmsTime));
    }

    private Double getHmsTime(String[] hms) {
        double hour = Double.parseDouble(hms[0]) * 60 * 60;
        double min = Double.parseDouble(hms[1]) * 60;
        double sec = Double.parseDouble(hms[2]);
        return hour + min + sec;
    }

    private Double getCostTime(String s) {
        String cost = s.split("s")[0];
        return Double.parseDouble(cost);
    }

    public boolean isBetween(TimeRange range) {
        //시작이 껴잇거나
        if (range.getStartTime() <= this.startTime && this.startTime <= range.getEndTime()) {
            return true;
        }
        //끝이 껴잇거나
        if (range.getStartTime() <= this.endTime && this.endTime <= range.getEndTime()) {
            return true;
        }
        //시작과 끝이 더 크거나
        return (this.startTime <= range.getStartTime()) && (range.getEndTime() <= this.endTime);
    }

    public List<TimeRange> getTimeRanges() {
        return Arrays.asList(new TimeRange(this.startTime), new TimeRange(this.endTime));
    }

}

class TimeRange {
    private Double startTime;
    private Double endTime;

    public TimeRange(Double startTime) {
        this.startTime = Double.parseDouble(String.format("%.3f", startTime));
        this.endTime = Double.parseDouble(String.format("%.3f", startTime + 0.999));
    }

    public Double getStartTime() {
        return startTime;
    }

    public Double getEndTime() {
        return endTime;
    }
}