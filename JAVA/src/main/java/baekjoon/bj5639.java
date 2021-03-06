package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class bj5639 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int rootValue = Integer.valueOf(br.readLine());
        Node root = new Node(rootValue);

        String input;

        try {

            while ((input = br.readLine()).length() > 0) {
                int value = Integer.valueOf(input);
                inputNode(root, value);
            }
        } catch (Exception e) {

        }

        getAnswer(root);

    }

    private static void inputNode(Node node, int value) {
        if (node.value > value) {
            if (node.left == null) {
                node.left = new Node(value);
            } else {
                inputNode(node.left, value);
            }
        } else {
            if (node.right == null) {
                node.right = new Node(value);
            } else {
                inputNode(node.right, value);
            }
        }
    }

    private static void getAnswer(Node node) {
        if (node.left != null) {
            getAnswer(node.left);
        }
        if (node.right != null) {
            getAnswer(node.right);
        }
        System.out.println(node.value);
    }

    static class Node {
        int value;

        Node left = null;
        Node right = null;

        Node(int value) {
            this.value = value;
        }
    }
}
