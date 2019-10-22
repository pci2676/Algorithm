package programers.winter2018.skilltree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution("CBD", new String[]{"BACDE", "CBADF", "AECB", "BDA"}));
    }

}

class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        SkillTree skillTree = new SkillTree(skill);

        for (String someoneTree : skill_trees) {
            skillTree.inputSkills(someoneTree);
            answer += skillTree.isValidAsInt();
        }

        return answer;
    }
}

class SkillTree {

    private String validSkills;
    private Queue<String> skillTree;

    public SkillTree(String validSkills) {
        this.validSkills = validSkills;
    }

    public void inputSkills(String someoneTree) {
        this.skillTree = Arrays.stream(someoneTree.split(""))
                .collect(Collectors.toCollection(LinkedList::new));
    }

    public int isValidAsInt() {
        Queue<String> validator = makeValidator();

        while (!skillTree.isEmpty()) {
            String skill = skillTree.poll();

            if (validator.contains(skill)) {
                String mustPreSkill = validator.poll();

                if (!mustPreSkill.equals(skill)) {
                    return 0;
                }
            }
        }

        return 1;
    }

    private Queue<String> makeValidator() {
        return Arrays.stream(this.validSkills.split(""))
                .collect(Collectors.toCollection(LinkedList::new));
    }

}