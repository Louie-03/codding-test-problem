package inflearn.재귀트리그래프.이진트리순회;

import java.util.ArrayList;
import java.util.List;

public class Main {

    /*
     문제 : 이진트리 순회
     유형 : DFS
     날짜 : 22.10.13
     refer : https://www.inflearn.com/course/%EC%9E%90%EB%B0%94-%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-%EB%AC%B8%EC%A0%9C%ED%92%80%EC%9D%B4-%EC%BD%94%ED%85%8C%EB%8C%80%EB%B9%84/unit/72767?category=questionDetail
     혼자 구현하다 말았는데 영상에 나온 강의는 생각보다 쉽게 접근했네요 ㅇㅅㅇ 쉽게 생각하면 엄청 간단하게 구현할 수 있었다
     */

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
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        Node node7 = new Node(7);
        Node node2 = new Node(2, node4, node5);
        Node node3 = new Node(3, node6, node7);
        Node node1 = new Node(1, node2, node3);

//        전위순회 구현(중, 왼, 오)
        Node node = node1;
        List<Integer> list = new ArrayList<>();
        while (list.size() != 7) {
            node = findNextNode(node, list);
            list.add(node.value);
        }

        for (Integer integer : list) {
            System.out.print(integer + " ");
        }

//        중위순회 구현(왼, 중, 오)
        node = findLeftEndNode(node1);
        list = List.of(node.value);
        while (list.size() != 7) {
            node = findNextNode2(node, list);
        }
    }

    private static Node findNextNode(Node node, List<Integer> list) {
        if (!list.contains(node.value)) {
            return node;
        }
        if (node.leftNode != null && !list.contains(node.leftNode.value)) {
            return node.leftNode;
        }
        if (node.rightNode != null && !list.contains(node.rightNode.value)) {
            return node.rightNode;
        }
        Node parentNode = node.parentNode;
        if (parentNode == null) {
            throw new IllegalStateException("다음 노드를 찾을 수 없습니다.");
        }
        return findNextNode(parentNode, list);
    }

    /*
        4번 노드 탐색
        4번 노드의 부모인 2번 노드의 오른쪽 노드 탐색
        2번 노드의 모든 자식 노드를 탐색했으니 2번 노드 탐색
        2번 노드의 부모 노드인 1번 노드의 오른쪽 노드인 3번 노드의 자식 노드가 있으니 3번 노드의 왼쪽 노드 탐색
        이때 탐색은 자식 노드가 없을때까지 해야함
         */
    private static Node findNextNode2(Node node, List<Integer> list) {
        if (!list.contains(node.value) && notExistUndiscoveredNode(node, list)) {
            return node;
        }
        if (node.leftNode != null && notExistUndiscoveredNode(node.leftNode, list)) {
            return node.leftNode;
        }
        if (node.rightNode != null && !list.contains(node.rightNode.value)) {
            return node.rightNode;
        }
        Node parentNode = node.parentNode;
        if (parentNode == null) {
            throw new IllegalStateException("다음 노드를 찾을 수 없습니다.");
        }
        return findNextNode(parentNode, list);
    }

    private static Node findLeftEndNode(Node node) {
        while (node.leftNode != null) {
            node = node.leftNode;
        }
        return node;
    }

    private static boolean notExistUndiscoveredNode(Node parentNode, List<Integer> list) {
        if (!list.contains(parentNode.value)) {
            return false;
        }
        boolean notExistLeftNode = true;
        if (parentNode.leftNode != null) {
             notExistLeftNode = notExistUndiscoveredNode(parentNode.leftNode, list);
        }
        boolean notExistRightNode = true;
        if (parentNode.rightNode != null) {
            notExistRightNode = notExistUndiscoveredNode(parentNode.rightNode, list);
        }
        return notExistLeftNode || notExistRightNode;
    }
}
