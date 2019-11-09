package woowatechcourse.q6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.equals(solution.solution(
                new String[][]{
                        {"jm@email.com", "제이엠"},
                        {"jason@email.com", "제이슨"},
                        {"woniee@email.com", "워니"},
                        {"mj@email.com", "엠제이"},
                        {"nowm@email.com", "이제엠"}
                }),
                new String[]{
                        "jason@email.com",
                        "jm@email.com",
                        "mj@email.com"
                }));
    }
}

class Solution {
    public String[] solution(String[][] forms) {
        String[] answer = {};

        Set<String> emails = new HashSet<>();

        List<Crew> crews = new ArrayList<>();
        for (String[] form : forms) {
            crews.add(new Crew(form[1], form[0]));
        }

        for (Crew standardCrew : crews) {
            for (Crew compareCrew : crews) {
                if (standardCrew.equals(compareCrew)) {
                    continue;
                }
                if (standardCrew.isDuplicate(compareCrew)) {
                    emails.add(compareCrew.getEmail());
                }
            }
        }


        answer = new String[emails.size()];
        List<String> sortedEmail = new ArrayList<>(emails);
        Collections.sort(sortedEmail);

        for (int i = 0; i < sortedEmail.size(); i++) {
            answer[i] = sortedEmail.get(i);
        }

        return answer;
    }
}

class Crew {
    private String name;
    private String email;

    public Crew(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public boolean isDuplicate(Crew crew) {
        for (int i = 0; i < this.name.length() - 1; i++) {
            String duplicatePart = this.name.substring(i, i + 2);
            if (crew.haveDuplicatePart(duplicatePart)) {
                return true;
            }
        }
        return false;
    }

    private boolean haveDuplicatePart(String duplicatePart) {
        for (int i = 0; i < this.name.length() - 1; i++) {
            String part = this.name.substring(i, i + 2);
            if (duplicatePart.equals(part)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Crew crew = (Crew) o;
        return Objects.equals(name, crew.name) &&
                Objects.equals(email, crew.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, email);
    }

    public String getEmail() {
        return email;
    }
}

