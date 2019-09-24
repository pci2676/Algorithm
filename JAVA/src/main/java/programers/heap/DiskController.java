package programers.heap;

import java.util.PriorityQueue;
import java.util.Queue;

public class DiskController {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] jobs = {{0, 3}, {1, 9}, {2, 6}};
        System.out.println(solution.solution(jobs));
    }

    static class Solution {
        public int solution(int[][] jobs) {
            int answer = 0;

            Queue<Job> jobQueue = new PriorityQueue<>(Job::sortTime);
            for (int[] job : jobs) {
                jobQueue.offer(new Job(job[0], job[1]));
            }
            int size = jobs.length;

            Queue<Job> priority = new PriorityQueue<>();
            Job nowJob = jobQueue.poll();
            int time = nowJob.getRequest();
            while (!(jobQueue.isEmpty() && priority.isEmpty() && nowJob == null)) {

                int cost = nowJob.getCost();
                time = time + cost;
                nowJob.done(time);
                answer += nowJob.getResponseTime();

                while (!jobQueue.isEmpty() && jobQueue.peek().getRequest() <= time) {
                    priority.offer(jobQueue.poll());
                }

                if (!priority.isEmpty()) {
                    nowJob = priority.poll();
                } else if (!jobQueue.isEmpty()) {
                    nowJob = jobQueue.poll();
                    time = nowJob.getRequest();
                } else {
                    nowJob = null;
                }

            }

            answer = answer / size;

            return answer;
        }
    }

    static class Job implements Comparable<Job> {

        private int request;
        private int cost;
        private int endTime;

        public Job(int request, int cost) {
            this.request = request;
            this.cost = cost;
        }

        public int getRequest() {
            return request;
        }

        public int getCost() {
            return cost;
        }

        public int getResponseTime() {
            return endTime - request;
        }

        public void done(int endTime) {
            this.endTime = endTime;
        }

        public int sortTime(Job o) {
            if (request > o.getRequest()) {
                return 1;
            }
            return -1;
        }

        @Override
        public int compareTo(Job o) {
            if (cost > o.cost) {
                return 1;
            } else if (cost == o.cost) {
                if (request > o.request) {
                    return 1;
                }
            }
            return -1;
        }

    }

}
