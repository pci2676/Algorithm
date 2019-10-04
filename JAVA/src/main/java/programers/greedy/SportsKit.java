package programers.greedy;

import java.util.ArrayList;
import java.util.List;

public class SportsKit {
    public static void main(String[] args) {
        Solution solution = new Solution();

        int n = 5;
//        int[] lost = {3};
        int[] lost = {2, 4};
//        int[] reserve = {1};
        int[] reserve = {1, 3, 5};

        System.out.println(solution.solution(n, lost, reserve));
    }
}

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {

        int[] studentStatus = new int[n + 1];

        makeStudentStatus(studentStatus, lost, reserve);

        List<Student> students = new ArrayList<>();

        makeStudents(students, n, studentStatus);

        lendEachOther(students);

        return (int) students.stream()
                .filter(Student::hasSportsKit)
                .count();
    }

    private void makeStudentStatus(int[] studentStatus, int[] lost, int[] reserve) {
        for (int index : lost) {
            studentStatus[index]--;
        }
        for (int index : reserve) {
            studentStatus[index]++;
        }
    }


    private void makeStudents(List<Student> students, int n, int[] studentStatus) {
        for (int i = 1; i <= n; i++) {
            Student student = makeStudent(i, studentStatus[i]);
            students.add(student);
        }
    }

    private Student makeStudent(int index, int studentStatus) {
        if (studentStatus == -1) {
            return Student.makeLostStudent(index);
        }
        if (studentStatus == 0) {
            return Student.makeNormalStudent(index);
        }
        return Student.makeReserveStudent(index);
    }

    private void lendEachOther(List<Student> students) {
        for (int i = 0; i < students.size() - 1; i++) {
            Student producer = students.get(i);
            Student consumer = students.get(i + 1);
            producer.lendTo(consumer);
            consumer.lendTo(producer);
        }
    }

}

class Student {
    private Integer index;
    private boolean lost;
    private boolean lendable;

    public Student(Integer index, boolean lost, boolean lendable) {
        this.index = index;
        this.lendable = lendable;
        this.lost = lost;
    }

    public static Student makeLostStudent(int index) {
        return new Student(index, true, false);
    }

    public static Student makeReserveStudent(int index) {
        return new Student(index, false, true);
    }

    public static Student makeNormalStudent(int index) {
        return new Student(index, false, false);
    }

    public void lendTo(Student student) {
        if (!canLendable()) {
            return;
        }
        if (student.needLend()) {
            student.lend();
            this.lendable = false;
        }
    }

    private void lend() {
        this.lost = false;
    }

    public boolean hasSportsKit() {
        return !this.lost;
    }

    private boolean needLend() {
        return this.lost;
    }

    private boolean canLendable() {
        return this.lendable;
    }

}
