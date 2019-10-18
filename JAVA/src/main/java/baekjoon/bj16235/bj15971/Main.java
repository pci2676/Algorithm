package baekjoon.bj16235.bj15971;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static Map<Integer, Room> rooms;
    private static int answer = -1;
    private static List<Integer> distances = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        rooms = new HashMap<>();

        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int r1 = Integer.parseInt(st.nextToken());
            int r2 = Integer.parseInt(st.nextToken());
            int length = Integer.parseInt(st.nextToken());

            Room room1 = findRoom(r1);
            Room room2 = findRoom(r2);

            room1.addPath(room2, length);
            room2.addPath(room1, length);

            update(room1);
            update(room2);
        }

        Room startRoom = rooms.get(start);
        Room endRoom = rooms.get(end);

        dfs(startRoom, endRoom);

        System.out.println(answer);
    }

    private static void dfs(Room startRoom, Room endRoom) {
        if (answer > 0) {
            return;
        }

        if (startRoom == endRoom) {
            int sum = distances.stream()
                    .mapToInt(Integer::intValue)
                    .sum();
            int max = distances.parallelStream()
                    .max(Integer::compareTo)
                    .orElse(0);
            answer = sum - max;
            return;
        }

        startRoom.visit();
        Stack<Room> stack = startRoom.getNextRooms();

        while (!stack.isEmpty()) {
            Room nextRoom = stack.pop();
            int distance = startRoom.getPathLength(nextRoom);
            distances.add(distance);
            dfs(nextRoom, endRoom);
            distances.remove(distances.size() - 1);
        }

    }

    private static Room findRoom(int number) {
        if (rooms.containsKey(number)) {
            return rooms.get(number);
        }
        return new Room(number);
    }

    private static void update(Room room) {
        if (rooms.containsKey(room.getNumber())) {
            return;
        }
        rooms.put(room.getNumber(), room);
    }

}

class Room {
    private Integer number;
    private Map<Room, Integer> map = new HashMap<>();
    private boolean visit = false;

    public Room(int number) {
        this.number = number;
    }

    private static boolean isNotVisit(Room room) {
        return !room.visit;
    }

    public void addPath(Room room, int length) {
        this.map.put(room, length);
    }

    public int getPathLength(Room room) {
        return this.map.get(room);
    }

    public Integer getNumber() {
        return this.number;
    }

    public void visit() {
        this.visit = true;
    }

    public Stack<Room> getNextRooms() {
        Stack<Room> stack = new Stack<>();
        map.keySet().stream()
                .filter(Room::isNotVisit)
                .forEach(stack::push);
        return stack;
    }

}

