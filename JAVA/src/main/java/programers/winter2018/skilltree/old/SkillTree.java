package programers.winter2018.skilltree.old;

import java.util.LinkedList;
import java.util.Queue;

public class SkillTree {

    public static void main(String[] args) {
        int answer = 0;
        String skill = "CBD";
        String[] skill_trees = {"BACDE", "CBADF", "BDA", "AECB"};

        Queue<Character> need = new LinkedList<>();
        for (int i = 0; i < skill.length(); i++) {
            need.offer(skill.charAt(i));
        }

        for (int i = 0; i < skill_trees.length; i++) {

            boolean flag = true;
            Queue<Character> copy = new LinkedList<>(need);

            for (int j = 0; j < skill_trees[i].length() && !copy.isEmpty(); j++) {
                Character now = skill_trees[i].charAt(j);
                if (!copy.contains(now)) {
                    continue;
                }
                Character must = copy.poll();
                if (must != now) {
                    flag = false;
                    break;
                }
            }

            if (flag) {
                answer++;
            }

        }

        System.out.println(answer);
    }

    class Solution {
        public int solution(String skill, String[] skill_trees) {
            int answer = 0;
            return answer;
        }
    }
}
