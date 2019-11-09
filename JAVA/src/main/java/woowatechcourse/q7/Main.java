package woowatechcourse.q7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.equals(solution.solution(
                "mrko",
                new String[][]{
                        {"donut", "andole"},
                        {"donut", "jun"},
                        {"donut", "mrko"},
                        {"shakevan", "andole"},
                        {"shakevan", "jun"},
                        {"shakevan", "mrko"}},
                new String[]
                        {"bedi", "bedi", "donut", "bedi", "shakevan"}),

                new String[]{"andole", "jun", "bedi"}));
    }
}

class Solution {
    public String[] solution(String user, String[][] friends, String[] visitors) {
        String[] answer = {};

        User me = new User(user);

        List<Friend> friendList = new ArrayList<>();
        for (String[] friend : friends) {
            friendList.add(new Friend(friend[0], friend[1]));
        }

        me.addFriends(friendList);

        List<String> myFriendsName = me.getMyFriendsName();

        Map<String, Integer> map = new HashMap<>();

        for (Friend friend : friendList) {
            if (friend.contain(me.getName())) {
                continue;
            }

            for (String myFriendName : myFriendsName) {
                if (friend.contain(myFriendName)) {
                    String otherFriendName = friend.getMyFriend(myFriendName);
                    if (map.containsKey(otherFriendName)) {
                        map.put(otherFriendName, map.get(otherFriendName) + 10);
                        continue;
                    }
                    map.put(otherFriendName, 10);
                }
            }
        }

        for (String visitor : visitors) {
            if (map.containsKey(visitor)) {
                map.put(visitor, map.get(visitor) + 1);
            }
            if (me.getMyFriendsName().contains(visitor)) {
                continue;
            }
            map.put(visitor, 1);
        }

        List<String> recommends = map.entrySet().stream()
                .map(entry -> new Recommend(entry.getKey(), entry.getValue()))
                .sorted()
                .map(Recommend::getName)
                .collect(Collectors.toList());


        answer = new String[recommends.size()];

        for (int i = 0; i < recommends.size() && i < 5; i++) {
            answer[i] = recommends.get(i);
        }

        return answer;
    }
}

class User {
    List<String> friends = new ArrayList<>();
    private String name;

    public User(String name) {
        this.name = name;
    }

    public void addFriends(List<Friend> friendList) {
        for (Friend friend : friendList) {
            if (friend.contain(name)) {
                friends.add(friend.getMyFriend(name));
            }
        }
    }

    public List<String> getMyFriendsName() {
        return friends;
    }

    public String getName() {
        return name;
    }
}

class Friend {
    private String name;
    private String friendName;

    public Friend(String name, String friendName) {
        this.name = name;
        this.friendName = friendName;
    }

    public boolean contain(String me) {
        return Arrays.asList(name, friendName).contains(me);
    }

    public String getMyFriend(String me) {
        if (name.equals(me)) {
            return friendName;
        }
        return name;
    }
}

class Recommend implements Comparable<Recommend> {
    private String name;
    private int value;

    public Recommend(String name, int value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    @Override
    public int compareTo(Recommend o) {
        return Integer.compare(o.value, this.value);
    }
}
