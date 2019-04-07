//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//
//public class sw1232 {
//
//    static class Node {
//        int index;
//        String value;
//        int left = -1;
//        int right = -1;
//
//        Node(int index, String value) {
//            this.index = index;
//            this.value = value;
//        }
//
//        Node(int index, String value, int left, int right) {
//            this.index = index;
//            this.value = value;
//            this.left = left;
//            this.right = right;
//        }
//    }
//
//    static String line;
//    static String[] lineArr;
//    static Node[] node;
//
//    public static void main(String[] args) throws Exception {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//        for (int t = 1; t <= 10; t++) {
//            int nodeAmount = Integer.parseInt(br.readLine());
//            node = new Node[nodeAmount + 1];
//            for (int i = 1; i <= nodeAmount; i++) {
//                line = br.readLine();
//                lineArr = line.split(" ");
//                node[i] = createNode();
//            }
//            int maxDistance = (int) inOrder(1);
//
//            System.out.println("#" + t + " " + maxDistance);
//        }
//    }
//
//    private static Node createNode() {
//        Node node;
//        int idx = Integer.parseInt(lineArr[0]);
//        String value = lineArr[1];
//        if (lineArr.length == 4) {
//            int left = Integer.parseInt(lineArr[2]);
//            int right = Integer.parseInt(lineArr[3]);
//            node = new Node(idx, value, left, right);
//        } else
//            node = new Node(idx, value);
//        return node;
//    }
//
//    //왼쪽으로 갈수 없다면 숫자를 가지고 있는 노드
//    //왼쪽이나 오른쪽으로 갈수 있다면 연산자를 가지고 있는 노드
//
//    private static double inOrder(int index) {
//        double leftNumber;
//        double rightNumber = 0;
//        double result = 0;
//        if (node[index].left != -1) {
//            leftNumber = inOrder(node[index].left);
//            node[index].left = -1;
//        } else {
//            return Double.parseDouble(node[index].value);
//        }
//
//        if (node[index].right != -1) {
//            rightNumber = inOrder(node[index].right);
//            node[index].right = -1;
//        }
//
//        if (node[index].value.equals("+")) result = leftNumber + rightNumber;
//        else if (node[index].value.equals("-")) result = leftNumber - rightNumber;
//        else if (node[index].value.equals("*")) result = leftNumber * rightNumber;
//        else if (node[index].value.equals("/")) result = leftNumber / rightNumber;
//        return result;
//    }
//
//
//}
