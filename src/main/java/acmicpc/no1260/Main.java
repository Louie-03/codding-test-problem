package acmicpc.no1260;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());

        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            map.put(i, new ArrayList<>());
        }


        // TODO: 2026/03/10 노드에 직접적으로 연결된 다른 노드가 여러개라면 오름차순으로 정렬해야 되는 것 같은데 이걸 효율적으로 하는 방법 알아보기
        // TODO: 2026/03/10 list 정렬 방법
        // TODO: 2026/03/10 list 정렬 vs 다른 정렬되는 자료구조

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            map.get(a).add(b);
            map.get(b).add(a);
        }

        for (int i = 1; i <= n; i++) {
            Collections.sort(map.get(i));
        }

        StringBuilder sb = new StringBuilder();
        dfs(v, map, sb, new HashSet<>());
        System.out.println(sb);

        sb = new StringBuilder();
        bfs(v, map, sb);
        System.out.println(sb);

    }

    static void dfs(int i, Map<Integer, List<Integer>> map, StringBuilder sb,
        Set<Integer> duplicationSet) {
        if (duplicationSet.contains(i)) {
            return;
        }

        duplicationSet.add(i);
        sb.append(i + " ");
        for (Integer integer : map.get(i)) {
            if (!duplicationSet.contains(integer)) {
                dfs(integer, map, sb, duplicationSet);
            }
        }
    }

    static void bfs(int i, Map<Integer, List<Integer>> map, StringBuilder sb) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(i);

        Set<Integer> duplicationSet = new HashSet<>();

        while (!queue.isEmpty()) {
            Integer integer = queue.poll();
            if (duplicationSet.contains(integer)) {
                continue;
            }

            sb.append(integer + " ");
            duplicationSet.add(integer);
            for (Integer integer1 : map.get(integer)) {
                if (duplicationSet.contains(integer1)) {
                    continue;
                }

                queue.add(integer1);
            }
        }
    }

}
