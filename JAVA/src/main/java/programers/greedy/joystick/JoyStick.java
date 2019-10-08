package programers.greedy.joystick;

public class JoyStick {

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.solution("JEROEN") == 56);
        System.out.println(solution.solution("JAN") == 23);
        System.out.println(solution.solution("AAA") == 0);
        System.out.println(solution.solution("AAAB") == 2);
        System.out.println(solution.solution("AAAZ") == 2);
        System.out.println(solution.solution("ZZZ") == 5);
        System.out.println(solution.solution("AABAAAAAAABBB") == 12);
        System.out.println(solution.solution("BAB") == 3);

        System.out.println(solution.solution("AAAABAA BA B AB AABAAB") == 3);

    }

}

class Solution {
    public int solution(String name) {
        int answer = 0;

        MyJoyStick myJoyStick = new MyJoyStick(name);

        int index = 0;

        myJoyStick.firstMove(name.substring(0, 1));

        while (myJoyStick.isNotEqual()) {
            index = myJoyStick.getNext(index);
        }

        answer = myJoyStick.getCount();

        return answer;
    }
}

class MyJoyStick {

    private String targetName;
    private String[] myName;
    private Integer count = 0;

    public MyJoyStick(String targetName) {
        this.targetName = targetName;
        this.myName = new String[targetName.length()];
        for (int i = 0; i < targetName.length(); i++) {
            myName[i] = "A";
        }
    }

    public Integer getCount() {
        return this.count;
    }

    public boolean isNotEqual() {
        return !String.join("", this.myName).equals(this.targetName);
    }

    public int getNext(int nowIndex) {
        int leftMove = 1;
        int rightMove = 1;
        String[] targetWords = this.targetName.split("");

        //find left
        int leftIndex = getLeftIndex(nowIndex);
        while (myName[leftIndex].equals(targetWords[leftIndex])) {
            leftMove++;
            leftIndex = getLeftIndex(leftIndex);
        }
        int leftDiff = getDiff(targetWords[leftIndex]);

        //find right
        int rightIndex = getRightIndex(nowIndex);
        while (myName[rightIndex].equals(targetWords[rightIndex])) {
            rightMove++;
            rightIndex = getRightIndex(rightIndex);
        }
        int rightDiff = getDiff(targetWords[rightIndex]);

        if (leftDiff == 0) {
            leftDiff--;
        }
        if (rightDiff == 0) {
            rightDiff--;
        }

        int leftCount = leftMove + leftDiff;
        int rightCount = rightMove + rightDiff;


        if (leftMove > rightMove) {
            this.count += rightCount;
            this.myName[rightIndex] = targetWords[rightIndex];
            return rightIndex;
        } else {
            this.count += leftCount;
            this.myName[leftIndex] = targetWords[leftIndex];
            return leftIndex;
        }
    }

    private int getLeftIndex(int leftIndex) {
        leftIndex--;
        if (leftIndex <= -1) {
            return this.targetName.length() - 1;
        }
        return leftIndex;
    }

    private int getRightIndex(int rightIndex) {
        rightIndex++;
        if (rightIndex >= this.targetName.length()) {
            return 0;
        }
        return rightIndex;
    }

    public void firstMove(String targetWord) {
        int diff = getDiff(targetWord);
        this.count += diff;
        this.myName[0] = targetWord;
    }

    private int getDiff(String targetWord) {
        int diff = targetWord.charAt(0) - 'A';
        if (diff > 13) {
            diff = (diff - 26) * (-1);
        }
        return diff;
    }

}