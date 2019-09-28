package programers.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.stream.Collectors;

public class FarNode {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int n = 6;
        int[][] edge = {{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}};
        System.out.println(solution.solution(n, edge) == 3);
    }

}

class Solution {

    private static Map<Integer, Integer> nodeInfo = new HashMap<>();

    public int solution(int n, int[][] edge) {
        int answer = 0;
        List<Node> nodes = new ArrayList<>();
        makeNodes(n, nodes);

        addAllLinkedNode(edge, nodes);

        findFarDistance(nodes);

        int farDistance = nodeInfo.values().stream()
                .max(Integer::compareTo)
                .get();

        answer = (int) nodeInfo.values().stream()
                .filter(value -> value == farDistance)
                .count();

        return answer;
    }

    private void findFarDistance(List<Node> nodes) {
        Node firstNode = findNode(1, nodes);

        firstNode.visit();
        List<Node> linkedNodes = firstNode.getLinkedNode();
        for (Node node : linkedNodes) {
            Stack<Node> nextNodes = new Stack<>();
            nextNodes.push(node);
            dfs(nextNodes, 0);
        }
    }

    private void dfs(Stack<Node> nextNodes, int nowDistance) {
        if (nextNodes.isEmpty()) {
            return;
        }

        Node nextLinkedNode = nextNodes.pop();
        if (nextLinkedNode.isVisited()) {
            return;
        }

        nextLinkedNode.visit();
        nextLinkedNode.changeShortDistance(nowDistance + 1);

        addInfo(nextLinkedNode);

        List<Node> linkedNodes = nextLinkedNode.getLinkedNode();

        for (Node node : linkedNodes) {
            nextNodes.push(node);
        }

        for (int i = 0; i < linkedNodes.size(); i++) {
            dfs(nextNodes, nowDistance + 1);
        }
        nextLinkedNode.cancel();

    }

    private void addInfo(Node node) {
        int index = node.getIndex();
        int distance = node.getDistance();
        if (nodeInfo.containsKey(index)) {
            int storedDistance = nodeInfo.get(index);
            if (storedDistance > distance) {
                nodeInfo.replace(index, distance);
            }
            return;
        }
        nodeInfo.put(index, distance);
    }

    private void addAllLinkedNode(int[][] edge, List<Node> nodes) {
        for (int[] link : edge) {
            int startIndex = link[0];
            int destIndex = link[1];
            Node startNode = findNode(startIndex, nodes);
            Node destNode = findNode(destIndex, nodes);
            linkNode(startNode, destNode);
        }
    }

    private void linkNode(Node startNode, Node destNode) {
        startNode.addLinkedNode(destNode);
        destNode.addLinkedNode(startNode);
    }

    private Node findNode(int nodeIndex, List<Node> nodes) {
        return nodes.stream()
                .filter(node -> node.getIndex() == nodeIndex)
                .findAny()
                .orElseThrow(RuntimeException::new);
    }

    private void makeNodes(int n, List<Node> nodes) {
        for (int i = 1; i <= n; i++) {
            nodes.add(new Node(i));
        }
    }

}

class Node {
    private Integer index;
    private boolean visited = false;
    private Integer distance;
    private List<Node> linkedNode = new ArrayList<>();

    public Node(Integer index) {
        this.index = index;
    }

    public Integer getIndex() {
        return index;
    }

    public boolean isVisited() {
        return visited;
    }

    public List<Node> getLinkedNode() {
        return this.linkedNode.stream()
                .filter(node -> !node.isVisited())
                .collect(Collectors.toList());
    }

    public int getDistance() {
        return distance;
    }

    public void changeShortDistance(int distance) {
        if (this.distance == null) {
            this.distance = distance;
            return;
        }
        if (this.distance > distance) {
            this.distance = distance;
        }
    }

    public void addLinkedNode(Node node) {
        this.linkedNode.add(node);
    }

    public void visit() {
        this.visited = true;
    }

    public void cancel() {
        this.visited = false;
    }

}