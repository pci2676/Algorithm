package programers.stack_queue.printer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class Printer {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] priorities1 = {2, 1, 3, 2};
        int[] priorities2 = {1, 1, 9, 1, 1, 1};
        int location1 = 2;
        int location2 = 0;
        System.out.println(solution.solution(priorities1, location1) == 1);
        System.out.println(solution.solution(priorities2, location2) == 5);
    }

}

class Solution {

    public int solution(int[] priorities, int location) {
        int answer = 0;

        PriorityPrinter printer = makePrinter(priorities);

        List<Document> printedDocuments = getPrintedDocuments(priorities, printer);

        answer = findAnswer(printedDocuments, location);

        return answer;
    }

    private PriorityPrinter makePrinter(int[] priorities) {
        PriorityQueue<Document> documentPriorityQueue = new PriorityQueue<>();
        Queue<Document> documentQueue = new LinkedList<>();

        for (int time = 0; time < priorities.length; time++) {
            Document document = new Document(priorities[time], time);
            documentPriorityQueue.offer(document);
            documentQueue.offer(document);
        }

        return new PriorityPrinter(documentPriorityQueue, documentQueue);
    }

    private List<Document> getPrintedDocuments(int[] priorities, PriorityPrinter printer) {
        List<Document> printedDocuments = new ArrayList<>();

        for (int time = 1; time <= priorities.length; time++) {
            Document document = printer.print(time);
            printedDocuments.add(document);
        }

        return printedDocuments;
    }

    private Integer findAnswer(List<Document> printedDocuments, Integer location) {
        return printedDocuments.stream()
                .filter(document -> document.getInTime().equals(location))
                .findFirst()
                .orElseThrow(RuntimeException::new)
                .getOutTime();
    }
}

class PriorityPrinter {

    private PriorityQueue<Document> documentPriorityQueue;
    private Queue<Document> documentQueue;

    public PriorityPrinter(PriorityQueue<Document> documentPriorityQueue, Queue<Document> documentQueue) {
        this.documentPriorityQueue = documentPriorityQueue;
        this.documentQueue = documentQueue;
    }

    public Document print(int time) {
        //우선순위가 가장높은 문서라면
        if (documentPriorityQueue.peek().getPriority().equals(documentQueue.peek().getPriority())) {
            documentPriorityQueue.poll();
            Document document = documentQueue.poll();
            document.done(time);
            return document;
        }
        //우선순위가 가장 높은 문서가 아니라면
        return findHighPriorityDocument(time);
    }

    private Document findHighPriorityDocument(int time) {
        while (!documentPriorityQueue.peek().getPriority().equals(documentQueue.peek().getPriority())) {
            Document document = documentQueue.poll();
            documentQueue.offer(document);
        }

        documentPriorityQueue.poll();
        Document document = documentQueue.poll();
        document.done(time);
        return document;
    }

}

class Document implements Comparable<Document> {

    private Integer priority;
    private Integer inTime;
    private Integer outTime;

    public Document(Integer priority, Integer inTime) {
        this.priority = priority;
        this.inTime = inTime;
    }

    public Integer getPriority() {
        return priority;
    }

    public Integer getInTime() {
        return inTime;
    }

    public Integer getOutTime() {
        return outTime;
    }

    public void done(int time) {
        this.outTime = time;
    }

    @Override
    public int compareTo(Document document) {
        return document.getPriority().compareTo(this.getPriority());
    }

}