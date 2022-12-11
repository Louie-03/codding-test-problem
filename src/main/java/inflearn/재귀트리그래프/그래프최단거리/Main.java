package inflearn.재귀트리그래프.그래프최단거리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    /*
     문제 : 그래프 최단거리(BFS)
     유형 : BFS
     시간 복잡도 : O(N)
     난이도 : 매우 쉬움
     시간 : 20m
     uri :
     날짜 : 22.10.17
     refer : https://www.inflearn.com/course/%EC%9E%90%EB%B0%94-%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-%EB%AC%B8%EC%A0%9C%ED%92%80%EC%9D%B4-%EC%BD%94%ED%85%8C%EB%8C%80%EB%B9%84/unit/72778
     */
    static Map<Integer, List<Integer>> map;
    static Map<Integer, Integer> result = new HashMap<>();
    static int n;
    static boolean[] check;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strings = br.readLine().split(" ");
        n = Integer.parseInt(strings[0]);
        check = new boolean[n + 1];
        int k = Integer.parseInt(strings[1]);
        map = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            map.put(i, new ArrayList<>());
        }

        for (int i = 0; i < k; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            map.get(Integer.parseInt(st.nextToken()))
                .add(Integer.parseInt(st.nextToken()));
        }

        bfs();

        for (int i = 2; i <= n; i++) {
            System.out.println(i + " : " + result.get(i));
        }
    }

    private static void bfs() {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        while (result.size() != n - 1) {
            Integer pop = queue.poll();
            for (Integer integer : map.get(pop)) {
                if (!result.containsKey(integer)) {
                    result.put(integer, result.getOrDefault(pop, 0) + 1);
                }
                if (!check[integer]) {
                    check[integer] = true;
                    queue.add(integer);
                }
            }
        }
    }

}

// 6 9
// 1 3
// 1 4
// 2 1
// 2 5
// 3 4
// 4 5
// 4 6
// 6 2
// 6 5
