package inflearn.재귀트리그래프.이진트리순회넓이우선탐색;

import java.util.LinkedList;
import java.util.Queue;

public class Main {

    /*
     문제 : 이진트리 순회(넓이우선탐색 : 레벨탐색)
     유형 : BFS
     날짜 : 22.10.15
     refer : https://www.inflearn.com/course/%EC%9E%90%EB%B0%94-%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-%EB%AC%B8%EC%A0%9C%ED%92%80%EC%9D%B4-%EC%BD%94%ED%85%8C%EB%8C%80%EB%B9%84/unit/72768
     */
    static Queue<Node> queue = new LinkedList<>();

    static class Node {
        int value;
        Node parentNode;
        Node leftNode;
        Node rightNode;

        public Node(int value) {
            this.value = value;
        }

        public Node(int value, Node leftNode, Node rightNode) {
            this.value = value;
            this.leftNode = leftNode;
            this.rightNode = rightNode;
            leftNode.parentNode = this;
            rightNode.parentNode = this;
        }
    }

    public static void main(String[] args) {
        Node node8 = new Node(8);
        Node node9 = new Node(9);
        Node node10 = new Node(10);
        Node node11 = new Node(11);
        Node node12 = new Node(12);
        Node node13 = new Node(13);
        Node node14 = new Node(14);
        Node node15 = new Node(15);
        Node node4 = new Node(4, node8, node9);
        Node node5 = new Node(5, node10, node11);
        Node node6 = new Node(6, node12, node13);
        Node node7 = new Node(7, node14, node15);
        Node node2 = new Node(2, node4, node5);
        Node node3 = new Node(3, node6, node7);
        Node node1 = new Node(1, node2, node3);

        int level = 0;
        queue.add(node1);
        while (!queue.isEmpty()) {
            System.out.print(level + " : ");
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                System.out.print(node.value + " ");

                if (node.leftNode != null) {
                    queue.add(node.leftNode);
                }
                if (node.rightNode != null) {
                    queue.add(node.rightNode);
                }
            }
            level++;
            System.out.println();
        }
    }

//    private static void d(Node node1) {
//        Node leftNode = node1.leftNode;
//        Node rightNode = node1.rightNode;
//        if (leftNode != null) {
//            queue.add(leftNode.value);
//        }
//        if (rightNode != null) {
//            queue.add(rightNode.value);
//        }
//        if (leftNode != null) {
//            d(leftNode);
//        }
//        if (rightNode != null) {
//            d(rightNode);
//        }
//    }

    /*
    node1    1 2 3
    node2    1 2 3 4 5
    node3    1 2 3 4 5 6 7

     */
}
