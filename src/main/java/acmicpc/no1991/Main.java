package acmicpc.no1991;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    /*
     문제 : 트리 순회
     유형 : 트리, 재귀
     시간 복잡도 : O(V)
     난이도 : 매우 쉬움
     시간 : 30m
     uri : https://www.acmicpc.net/problem/1991
     날짜 : 22.11.18
     refer :
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Map<Character, Node> map = new HashMap<>();
        for (int i = 'A'; i < 'A' + n; i++) {
            char c = (char) i;
            map.put(c, new Node(c));
        }
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            Node node = map.get(st.nextToken().charAt(0));
            char c = st.nextToken().charAt(0);
            if (c != '.') {
                node.left = map.get(c);
            }
            c = st.nextToken().charAt(0);
            if (c != '.') {
                node.right = map.get(c);
            }
        }
        StringBuilder sb = new StringBuilder();
        preorder(sb, map.get('A'));
        sb.append("\n");
        inorder(sb, map.get('A'));
        sb.append("\n");
        postorder(sb, map.get('A'));
        System.out.println(sb);
    }

    private static void preorder(StringBuilder sb, Node node) {
        sb.append(node.c);
        if (node.left != null) {
            preorder(sb, node.left);
        }
        if (node.right != null) {
            preorder(sb, node.right);
        }
    }

    private static void inorder(StringBuilder sb, Node node) {
        if (node.left != null) {
            inorder(sb, node.left);
        }
        sb.append(node.c);
        if (node.right != null) {
            inorder(sb, node.right);
        }
    }

    private static void postorder(StringBuilder sb, Node node) {
        if (node.left != null) {
            postorder(sb, node.left);
        }
        if (node.right != null) {
            postorder(sb, node.right);
        }
        sb.append(node.c);
    }

    static class Node {
        char c;
        Node left;
        Node right;

        public Node(char c) {
            this.c = c;
        }

        @Override
        public String toString() {
            return c + " " + (left == null ? '.' : left.c) + " " + (right == null ? '.' : right.c);
        }
    }
}
