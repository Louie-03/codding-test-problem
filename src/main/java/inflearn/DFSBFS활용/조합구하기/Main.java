package inflearn.DFSBFS활용.조합구하기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    static int n;
    static int m;
    static boolean[][] booleans;
    static Stack<Integer> stack = new Stack<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strings = br.readLine().split(" ");
        n = Integer.parseInt(strings[0]);
        m = Integer.parseInt(strings[1]);
        booleans = new boolean[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            booleans[i][i] = true;
        }
        bfs();
    }

    private static void bfs() {
        if (stack.size() == m) {
            for (Integer integer : stack) {
                System.out.print(integer + " ");
            }
            System.out.println();
            return;
        }

        for (int i = stack.isEmpty() ? 1 : stack.peek() + 1; i <= n; i++) {
            stack.push(i);
            bfs();
            stack.pop();
        }
    }

    /*
        1234
       1oooo
       2oo
       3o o
       4o  o
     */
}
