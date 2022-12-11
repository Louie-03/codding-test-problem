package inflearn.재귀트리그래프.그래프와인접행렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    /*
     문제 : 그래프와 인접행렬
     유형 : BFS
     시간 복잡도 : O(N)
     난이도 : 매우 쉬움
     시간 : 10m
     uri :
     날짜 : 22.10.15
     refer : https://www.inflearn.com/course/%EC%9E%90%EB%B0%94-%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-%EB%AC%B8%EC%A0%9C%ED%92%80%EC%9D%B4-%EC%BD%94%ED%85%8C%EB%8C%80%EB%B9%84/unit/72775
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strings = br.readLine().split(" ");
        int n = Integer.parseInt(strings[0]);
        int k = Integer.parseInt(strings[1]);
        boolean[][] graph = new boolean[n][n];

//        무방향(양방향) 그래프
//        for (int i = 0; i < k; i++) {
//            String[] strings2 = br.readLine().split(" ");
//            int a = Integer.parseInt(strings2[0]) - 1;
//            int b = Integer.parseInt(strings2[1]) - 1;
//            graph[a][b] = true;
//            graph[b][a] = true;
//        }

//        단방향 그래프
        for (int i = 0; i < k; i++) {
            String[] strings2 = br.readLine().split(" ");
            int a = Integer.parseInt(strings2[0]) - 1;
            int b = Integer.parseInt(strings2[1]) - 1;
            graph[a][b] = true;
        }

        for (int i = 0; i < n; i++) {
            System.out.print(i + 1 + " : ");
            for (int j = 0; j < n; j++) {
                if (graph[i][j]) {
                    System.out.print(j + 1 + " ");
                }
            }
            System.out.println();
        }

//        for (boolean[] booleans : graph) {
//            for (boolean aBoolean : booleans) {
//                if (aBoolean) {
//                    System.out.print(1 + " ");
//                } else {
//                    System.out.print(0 + " ");
//                }
//            }
//            System.out.println();
//        }
    }
}
