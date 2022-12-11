package inflearn.재귀트리그래프.경로탐색인접리스트;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Main {

    /*
     문제 : 경로 탐색(인접리스트)
     유형 : DFS
     시간 복잡도 : ?
     난이도 : 쉬움
     시간 : 25m
     uri :
     날짜 : 22.10.15
     refer : https://www.inflearn.com/course/%EC%9E%90%EB%B0%94-%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-%EB%AC%B8%EC%A0%9C%ED%92%80%EC%9D%B4-%EC%BD%94%ED%85%8C%EB%8C%80%EB%B9%84/unit/72777
     */
    static List<List<Integer>> graph = new ArrayList<>();
    static int n;
    static boolean[] check;
    static Stack<Integer> stack = new Stack<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strings = br.readLine().split(" ");
        n = Integer.parseInt(strings[0]);
        int k = Integer.parseInt(strings[1]);
        check = new boolean[n];

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < k; i++) {
            String[] strings2 = br.readLine().split(" ");
            int a = Integer.parseInt(strings2[0]) - 1;
            int b = Integer.parseInt(strings2[1]);
            graph.get(a).add(b);
        }
        dfs(1);
    }

    private static void dfs(int num) {
        check[num - 1] = true;
        stack.push(num);
        if (num == n) {
            for (Integer integer : stack) {
                System.out.print(integer + " ");
            }
            System.out.println();
        } else {
            for (Integer integer : graph.get(num - 1)) {
                if (!check[integer - 1]) {
                    dfs(integer);
                }
            }
        }
        stack.pop();
        check[num - 1] = false;
    }
}
