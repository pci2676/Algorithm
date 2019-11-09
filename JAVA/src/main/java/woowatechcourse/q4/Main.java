package woowatechcourse.q4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.equals(solution.solution(new String[]{"kim password", "lee abc"}, new String[]{
                "ADD 30",
                "LOGIN kim abc",
                "LOGIN lee password",
                "LOGIN kim password",
                "LOGIN kim password",
                "ADD 30",
                "ORDER",
                "ORDER",
                "ADD 40",
                "ADD 50"}), new boolean[]{false, false, false, true, false, true, true, false, true, true}));

        System.out.println(Arrays.equals(solution.solution(new String[]{"kim password", "lee abc"}, new String[]{"LOGIN lee abc",
                "LOGIN kim password"}), new boolean[]{true, false}));
    }
}

class Solution {
    public boolean[] solution(String[] infos, String[] actions) {
        boolean[] answer = {};
        Member member = new Member(infos);
        Boolean[] booleans = Arrays.stream(actions)
                .map(action -> CommandParser.getCommandResult(action, member))
                .toArray(Boolean[]::new);

        answer = new boolean[booleans.length];

        for (int i = 0; i < booleans.length; i++) {
            answer[i] = booleans[i];
        }

        return answer;
    }
}

class CommandParser {
    private static final String LOGIN = "LOGIN";
    private static final String ADD = "ADD";
    private static final String ADDER = "ADDER";

    public static boolean getCommandResult(String command, Member member) {
        String[] commands = command.split(" ");
        if (LOGIN.equals(commands[0])) {
            return Login.loginProcess(commands, member);
        }

        if (!member.alreadyLogin()) {
            return false;
        }

        if (ADD.equals(commands[0])) {
            return Cart.addCart(member);
        }

        return Order.orderProcess(member);
    }

}

class Member {
    private List<String> ids = new ArrayList<>();
    private List<String> passwords = new ArrayList<>();
    private String id;
    private String password;
    private boolean login;
    private boolean cart;

    public Member(String[] infos) {
        for (String info : infos) {
            String[] idAndPass = info.split(" ");
            this.ids.add(idAndPass[0]);
            this.passwords.add(idAndPass[1]);
        }
    }

    public boolean alreadyLogin() {
        return login;
    }

    public boolean isCorrectInfo(String id, String password) {
        int index = findIdIndex(id);
        if (index == -1) {
            return false;
        }

        String findId = ids.get(index);
        String findPassword = passwords.get(index);

        if ((findId.equals(id)) && (findPassword.equals(password))) {
            this.login = true;
            this.id = findId;
            this.password = findPassword;
            return true;
        }
        return false;
    }

    private int findIdIndex(String id) {
        for (int i = 0; i < ids.size(); i++) {
            if (ids.get(i).equals(id)) {
                return i;
            }
        }
        return -1;
    }

    public void addCart() {
        this.cart = true;
    }

    public boolean hasCart() {
        return this.cart;
    }

    public void orderCart() {
        this.cart = false;
    }
}

class Login {

    public static boolean loginProcess(String[] command, Member member) {
        if (member.alreadyLogin()) {
            return false;
        }
        return member.isCorrectInfo(command[1], command[2]);
    }

}

class Cart {

    public static boolean addCart(Member member) {
        member.addCart();
        return true;
    }

}

class Order {
    public static boolean orderProcess(Member member) {
        boolean answer = member.hasCart();
        member.orderCart();
        return answer;
    }
}
