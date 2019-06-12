package programers.stack_queue;

import java.util.LinkedList;
import java.util.Queue;

public class TruckOnTheBridge {
    public static void main(String[] args) {
        int bridge_length = 2;
        int weight = 10;
        int[] truck_weights = {7, 4, 5, 6};
        int answer = 0;

        int amountOfTruck = truck_weights.length;
        int[] pass = new int[amountOfTruck];

        Queue<Integer> trucks = new LinkedList<>();
        for (int truck : truck_weights) {
            trucks.offer(truck);
        }
        Queue<Integer> truckOnBridge = new LinkedList<>();
        int passed = 0;

        int time = 0;
        while (passed != amountOfTruck) {

            int onBridgeIndex = amountOfTruck - trucks.size();
            time++;

            for (int i = 0; i < onBridgeIndex; i++) {
                if (pass[i] == -1) {
                    continue;
                }
                pass[i]++;
                if (pass[i] == bridge_length) {
                    pass[i] = -1;
                    passed++;
                    truckOnBridge.poll();
                }
            }

            if (trucks.isEmpty()) {
                continue;
            }

            int currentWeight = truckOnBridge.stream()
                    .mapToInt(Integer::valueOf)
                    .sum();
            int willWeight = currentWeight + trucks.peek();
            if (willWeight > weight) {
                continue;
            }

            int oneOfTruck = trucks.poll();
            truckOnBridge.offer(oneOfTruck);

        }

        System.out.println(time);
    }

    class Solution {
        public int solution(int bridge_length, int weight, int[] truck_weights) {
            int answer = 0;
            return answer;
        }
    }
}
