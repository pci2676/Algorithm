package programers.dfs_bfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.stream.Collectors;

public class TravelPath {

    public static void main(String[] args) {
        String[][] ticketsFirst = {{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL", "SFO"}};
        String[][] ticketsSecond = {{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}};
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.solution(ticketsFirst)));
        System.out.println(Arrays.toString(solution.solution(ticketsSecond)));
    }

    static class Solution {
        public String[] solution(String[][] tickets) {
            String[] answer = {};

            List<Ticket> usableTickets = Arrays.stream(tickets)
                    .map(Ticket::new)
                    .collect(Collectors.toList());
            answer = new String[usableTickets.size() + 1];

            List<Ticket> usedTickets = new ArrayList<>();
            Queue<Ticket> canFirstTicket = findFirstTickets(usableTickets);
            while (!canFirstTicket.isEmpty()) {
                Ticket firstTicket = canFirstTicket.poll();
                findPath(firstTicket, usableTickets, usedTickets);
            }

            int index = 0;
            for (Ticket ticket : usedTickets) {
                answer[index] = ticket.getDepart();
                index++;
            }
            answer[index] = usedTickets.get(usedTickets.size() - 1).getDest();

            return answer;
        }

        private void findPath(Ticket beforeTicket, List<Ticket> usableTickets, List<Ticket> usedTickets) {
            if (isNotUsable(usableTickets)) {
                return;
            }

            beforeTicket.use();
            usedTickets.add(beforeTicket);

            Queue<Ticket> canNextTickets = findNextTickets(usableTickets, beforeTicket);
            while (!canNextTickets.isEmpty()) {
                Ticket nextTicket = canNextTickets.poll();
                findPath(nextTicket, usableTickets, usedTickets);
            }

            if (isNotUsable(usableTickets)) {
                return;
            }

            beforeTicket.cancel();
            usedTickets.remove(beforeTicket);
        }

        private boolean isNotUsable(List<Ticket> usableTickets) {
            return usableTickets.stream()
                    .noneMatch(Ticket::isUsable);
        }

        private Queue<Ticket> findFirstTickets(List<Ticket> tickets) {
            return tickets.stream()
                    .filter(Ticket::canFirst)
                    .collect(Collectors.toCollection(PriorityQueue::new));
        }

        private Queue<Ticket> findNextTickets(List<Ticket> usableTickets, Ticket beforeTicket) {
            return usableTickets.stream()
                    .filter(Ticket::isUsable)
                    .filter(usableTicket -> usableTicket.getDepart().equals(beforeTicket.getDest()))
                    .collect(Collectors.toCollection(PriorityQueue::new));
        }
    }

    static class Ticket implements Comparable<Ticket> {
        private String depart;
        private String dest;
        private boolean usable = true;

        public Ticket(String[] ticket) {
            this.depart = ticket[0];
            this.dest = ticket[1];
        }

        public String getDepart() {
            return depart;
        }

        public String getDest() {
            return dest;
        }

        public boolean isUsable() {
            return usable;
        }

        public void use() {
            this.usable = false;
        }

        public void cancel() {
            this.usable = true;
        }

        public boolean canFirst() {
            return this.depart.equals("ICN");
        }

        @Override
        public int compareTo(Ticket o) {
            return this.dest.compareTo(o.getDest());
        }
    }
}
