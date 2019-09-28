package programers.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

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

        List<Node> firstLinkedNodes = firstNode.getLinkedNode();

        for (Node node : firstLinkedNodes) {
            node.visit();
        }

        Queue<Node> nodeQueue = new LinkedList<>(firstLinkedNodes);

        while (!nodeQueue.isEmpty()) {
            Node nextNode = nodeQueue.poll();
            nextNode.visit();
            nextNode.addDistance();
            addInfo(nextNode);
            addNextLinkedNode(nodeQueue, nextNode);
        }
    }

    private void addNextLinkedNode(Queue<Node> nodeQueue, Node nextNode) {
        for (Node node : nextNode.getLinkedNode()) {
            if (node.isVisited()) {
                continue;
            }
            node.visit();
            node.changeBaseDistance(nextNode);
            nodeQueue.offer(node);
        }
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


    private void makeNodes(int n, List<Node> nodes) {
        for (int i = 1; i <= n; i++) {
            nodes.add(new Node(i));
        }
    }

}

class Node {
    private Integer index;
    private boolean visited = false;
    private int distance = 0;
    private List<Node> linkedNode = new ArrayList<>();

    public Node(Integer index) {
        this.index = index;
    }

    public Integer getIndex() {
        return this.index;
    }

    public boolean isVisited() {
        return this.visited;
    }

    public List<Node> getLinkedNode() {
        return this.linkedNode;
    }

    public int getDistance() {
        return this.distance;
    }

    public void addDistance() {
        this.distance++;
    }

    public void changeBaseDistance(Node beforeNode) {
        this.distance = beforeNode.getDistance();
    }

    public void addLinkedNode(Node node) {
        this.linkedNode.add(node);
    }

    public void visit() {
        this.visited = true;
    }

}