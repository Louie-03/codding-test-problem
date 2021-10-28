package acmicpc;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class no1260DfsBfs {
    static int n;
    static int[][] edge;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        int m = scanner.nextInt();
        int v = scanner.nextInt();
        edge = new int[n + 1][n + 1];

        for (int i = 0; i < m; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();

            edge[x][y] = 1;
            edge[y][x] = 1;
        }

        dfs(v);
        System.out.println();
        bfs(v);
    }

    private static void dfs(int v) {
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[n + 1];
        stack.add(v);

        while (!stack.empty()) {
            v = stack.pop();
            if (visited[v]) {
                continue;
            }
            visited[v] = true;
            System.out.print(v + " ");
            for (int i = n; i >= 1; i--) {
                if (edge[v][i] == 1 && !visited[i]) {
                    stack.add(i);
                }
            }
        }
    }

    private static void bfs(int v) {
        Queue<Integer> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[n + 1];
        queue.add(v);

        while (!queue.isEmpty()) {
            v = queue.remove();
            if (visited[v]) {
                continue;
            }
            visited[v] = true;
            System.out.print(v + " ");
            for (int i = 1; i <= n; i++) {
                if (edge[v][i] == 1 && !visited[i]) {
                    queue.add(i);
                }
            }
        }
    }
}