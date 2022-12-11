package inflearn.재귀트리그래프.Tree말단노드까지의가장짧은경로;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Main {

    static class Node {
        int value;
        Node parentNode;
        Node leftNode;
        Node rightNode;

        public Node(int value) {
            this.value = value;
        }

        public Node(int value, Node leftNode) {
            this.value = value;
            this.leftNode = leftNode;
            leftNode.parentNode = this;
        }

        public Node(int value, Node leftNode, Node rightNode) {
            this.value = value;
            this.leftNode = leftNode;
            this.rightNode = rightNode;
            leftNode.parentNode = this;
            rightNode.parentNode = this;
        }

        public boolean isEnd() {
            return leftNode == null && rightNode == null;
        }

        public int getDepth() {
            int depth = 0;
            Node node = this;
            while (node.parentNode != null) {
                depth++;
                node = node.parentNode;
            }
            return depth;
        }
    }

    /*
     문제 : Tree 말단 노드까지의 가장 짧은 경로
     유형 : BFS
     시간 복잡도 : O(N)
     난이도 : 매우 쉬움
     시간 : 10m
     uri :
     날짜 : 22.10.15
     refer : https://www.inflearn.com/course/%EC%9E%90%EB%B0%94-%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-%EB%AC%B8%EC%A0%9C%ED%92%80%EC%9D%B4-%EC%BD%94%ED%85%8C%EB%8C%80%EB%B9%84/unit/72771?tab=community&category=questionDetail
     */

    public static void main(String[] args) {
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node2 = new Node(2, node4, node5);
        Node node3 = new Node(3);
        Node node1 = new Node(1, node2, node3);

        bfs(node1);
        dfs(node1);
        System.out.println(dfs2(node1, 0));
    }

    private static void bfs(Node root) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        int L = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                if (node.isEnd()) {
                    System.out.println(L);
                    return;
                }
                if (node.leftNode != null) {
                    queue.add(node.leftNode);
                }
                if (node.rightNode != null) {
                    queue.add(node.rightNode);
                }
            }
            L++;
        }
    }

    private static void dfs(Node root) {
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        int length = Integer.MAX_VALUE;
        while (!stack.isEmpty()) {
            Node node = stack.pop();
            if (node.isEnd()) {
                length = Math.min(length, node.getDepth());
            } else {
                if (node.leftNode != null) {
                    stack.push(node.leftNode);
                }
                if (node.rightNode != null) {
                    stack.push(node.rightNode);
                }
            }
        }
        System.out.println(length);
    }

    private static int dfs2(Node node, int depth) {
        Node leftNode = node.leftNode;
        Node rightNode = node.rightNode;
        if (leftNode != null && rightNode != null) {
            return Math.min(dfs2(leftNode, depth + 1), dfs2(rightNode, depth + 1));
        }
        if (leftNode != null) {
            return dfs2(leftNode, depth + 1);
        }
        if (rightNode != null) {
            return dfs2(rightNode, depth + 1);
        }
        return depth;
    }
}
