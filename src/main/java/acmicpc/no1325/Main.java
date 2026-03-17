package acmicpc.no1325;

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

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        List<Integer>[] array = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            array[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            array[b].add(a);
        }

        Map<Integer, Integer> countMap = new HashMap<>();

        for (int i = 1; i <= n; i++) {
            bfs(array, countMap, new boolean[n + 1], i);
        }

        for (Integer integer : countMap.keySet()) {
            System.out.println(integer + " : " + countMap.get(integer));
        }

        int maxCount = getMaxCount(countMap);

        List<Integer> answer = new ArrayList<>();
        // TODO: 2026/03/17 array.keySet이 순서가 보장됨?
        // TODO: 2026/03/17 Set 자체가 순서 보장이 안됨?
        for (int i = 1; i <= n; i++) {
            if (countMap.containsKey(i) && countMap.get(i) == maxCount) {
                answer.add(i);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (Integer integer : answer) {
            sb.append(integer).append(" ");
        }

        System.out.println(sb);
    }

    static void bfs(List<Integer>[] map, Map<Integer, Integer> countMap,
        boolean[] duplications, int i) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(i);
        duplications[i] = true;
        int count = 0;
        while (!queue.isEmpty()) {
            Integer now = queue.poll();
            count++;

            for (Integer next : map[now]) {
                if (!duplications[next]) {
                    queue.add(next);
                    duplications[next] = true;
                }
            }
        }
        countMap.put(i, count);
    }

    private static int getMaxCount(Map<Integer, Integer> countMap) {
        int maxCount = 0;
        for (Integer value : countMap.values()) {
            if (maxCount < value) {
                maxCount = value;
            }
        }
        return maxCount;
    }

}
