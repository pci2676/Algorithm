package swExpert;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class sw1231 {

    static class Node {
        Integer index;
        String value;
        Node left = null;
        Node right = null;

        Node(Integer index, String value) {
            this.index = index;
            this.value = value;
        }
    }

    static String[] nodeValue;
    static String maxDistance;

    public static void main(String[] args) throws Exception {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        for (int t = 1; t <= 10; t++) {
            Node root = null;
            maxDistance = "";

            int nodeAmount = Integer.parseInt(bufferedReader.readLine());
            String temp = bufferedReader.readLine();
            nodeValue = temp.split(" ");
            root = new Node(Integer.parseInt(nodeValue[0]), nodeValue[1]);
            for (int i = 0; i < nodeAmount - 1; i++) {
                String tempFor = bufferedReader.readLine();
                nodeValue = tempFor.split(" ");
                createNode(root);
            }
            inOrder(root);
            System.out.println("#" + t + " " + maxDistance);
        }
    }


    private static void createNode(Node node) {
        int index = Integer.parseInt(nodeValue[0]);
        String value = nodeValue[1];
        if (node == null) {
            node = new Node(index, value);
        } else if (node.index == index / 2 && index % 2 == 0) {
            node.left = new Node(index, value);
        } else if (node.index == index / 2 && index % 2 == 1) {
            node.right = new Node(index, value);
        } else {
            createNode(node.left);
            createNode(node.right);
        }
    }

    private static void inOrder(Node node) {
        if (node.left != null) {
            inOrder(node.left);
        }
        maxDistance += node.value;
        if (node.right != null) {
            inOrder(node.right);
        }
    }
}