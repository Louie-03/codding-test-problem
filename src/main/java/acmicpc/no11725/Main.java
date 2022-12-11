package acmicpc.no11725;

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
     문제 : 트리의 부모 찾기
     유형 : BFS
     시간 복잡도 : O(N)
     난이도 : 보통
     시간 : 40m
     uri : https://www.acmicpc.net/problem/11725
     날짜 : 22.11.21
     refer :
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] answer = new int[n + 1];
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            map.put(i, new ArrayList<>());
        }
        for (int i = 0; i < n - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            map.get(a).add(b);
            map.get(b).add(a);
        }
        bfs(map, answer);
        StringBuilder sb = new StringBuilder();
        for (int i = 2; i <= n; i++) {
            sb.append(answer[i]).append('\n');
        }
        System.out.println(sb);
    }

    private static void bfs(Map<Integer, List<Integer>> map, int[] answer) {
        answer[1] = 1;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        while (!queue.isEmpty()) {
            Integer integer = queue.poll();
            for (Integer integer1 : map.get(integer)) {
                if (answer[integer1] == 0) {
                    queue.add(integer1);
                    answer[integer1] = integer;
                }
            }
        }
    }

    /*
    두 노드 모두 존재하지만 루트 트리와 연결되어 있지 않은 경우
    두 노드 모두 존재하지만 루트 트리와 연결된 경우
    한 노드만 존재하고 해당 노드가 루트 트리와 연결된 경우
    한 노드만 존재하고 해당 노드가 루트 트리와 연결되어 있지 않은 경우
    두 노드 모두 존재하지 않는 경우
            1
          4   6
        2  7     3
                  5
     하위에 부모 자식이 정해지지 않았던 노드들의 부모도 설정해줘야함
     1 2
     3 4
     4 5
     2 3
        1
          2
            3
              4
                5

     2 -> 3
     5 -> 4

     2 -> 3 -> 5 -> 4
     2 -> 3 -> 5 -> 4
     */
}
