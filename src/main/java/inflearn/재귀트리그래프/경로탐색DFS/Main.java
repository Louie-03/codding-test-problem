package inflearn.재귀트리그래프.경로탐색DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    /*
     문제 : 경로 탐색(인접행렬)
     유형 : DFS
     시간 복잡도 : ?
     난이도 : 쉬움
     시간 : 25m
     uri :
     날짜 : 22.10.15
     refer : https://www.inflearn.com/course/%EC%9E%90%EB%B0%94-%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-%EB%AC%B8%EC%A0%9C%ED%92%80%EC%9D%B4-%EC%BD%94%ED%85%8C%EB%8C%80%EB%B9%84/unit/72776?tab=curriculum
     */
    static boolean[][] graph;
    static int n;
    static Stack<Integer> stack = new Stack<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strings = br.readLine().split(" ");
        n = Integer.parseInt(strings[0]);
        int k = Integer.parseInt(strings[1]);
        graph = new boolean[n][n];

        for (int i = 0; i < k; i++) {
            String[] strings2 = br.readLine().split(" ");
            int a = Integer.parseInt(strings2[0]) - 1;
            int b = Integer.parseInt(strings2[1]) - 1;
            graph[a][b] = true;
        }

        dfs(1);

//        for (int i = 0; i < n; i++) {
//            System.out.print(i + 1 + " : ");
//            for (int j = 0; j < n; j++) {
//                if (graph[i][j]) {
//                    System.out.print(j + 1 + " ");
//                }
//            }
//            System.out.println();
//        }
    }

    private static void dfs(int num) {
//        System.out.println(num);
//        System.out.println(11);
        stack.push(num);
        if (num == n) {
            for (Integer integer : stack) {
                System.out.print(integer + " ");
            }
            System.out.println();
//            System.out.println(22);
        } else {
            for (int i = 0; i < n; i++) {
                if (graph[num - 1][i] && !stack.contains(i + 1)) {
                    dfs(i + 1);
                }
//                System.out.println(33);
            }
        }
        stack.pop();
    }
}

//5 9
//1 2
//1 3
//1 4
//2 1
//2 3
//2 5
//3 4
//4 2
//4 5
