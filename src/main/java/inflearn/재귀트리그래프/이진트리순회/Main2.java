package inflearn.재귀트리그래프.이진트리순회;

public class Main2 {

    /*
     문제 : 이진트리 순회
     유형 : DFS
     날짜 : 22.10.13
     refer : https://www.inflearn.com/course/%EC%9E%90%EB%B0%94-%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-%EB%AC%B8%EC%A0%9C%ED%92%80%EC%9D%B4-%EC%BD%94%ED%85%8C%EB%8C%80%EB%B9%84/unit/72767?category=questionDetail
     */

    static class Node {
        int value;
        Node leftNode;
        Node rightNode;

        public Node(int value) {
            this.value = value;
        }

        public Node(int value, Node leftNode, Node rightNode) {
            this.value = value;
            this.leftNode = leftNode;
            this.rightNode = rightNode;
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
        DFS1(node1);
//        중위순회 구현(왼, 중, 오)
        DFS2(node1);
    }

    private static void DFS1(Node node) {
        if (node == null) {
            return;
        }
        System.out.print(node.value + " ");
        DFS1(node.leftNode);
        DFS1(node.rightNode);
    }

    private static void DFS2(Node node) {
        if (node == null) {
            return;
        }
        DFS2(node.leftNode);
        System.out.println(node.value + " ");
        DFS2(node.rightNode);
    }

    private static void DFS3(Node node) {
        if (node == null) {
            return;
        }
        DFS2(node.leftNode);
        DFS2(node.rightNode);
        System.out.println(node.value + " ");
    }

//    4 5 2 6 7 3 1
}
