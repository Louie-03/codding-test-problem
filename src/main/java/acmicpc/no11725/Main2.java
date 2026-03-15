package acmicpc.no11725;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
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

        int[] answer = new int[n + 1];
//        dfs(1, new HashSet<>(), answer, map);
        bfs(new HashSet<>(), answer, map);

        StringBuilder sb = new StringBuilder();
        for (int i = 2; i < n + 1; i++) {
            sb.append(answer[i]).append("\n");
        }
        System.out.println(sb);
    }

    static void dfs(int parent, Set<Integer> duplicationSet, int[] answer, Map<Integer, List<Integer>> map) {
        duplicationSet.add(parent);
        for (Integer child : map.get(parent)) {
            if (!duplicationSet.contains(child)) {
                answer[child] = parent;
                dfs(child, duplicationSet, answer, map);
            }
        }
    }

    static void bfs(Set<Integer> duplicationSet, int[] answer, Map<Integer, List<Integer>> map) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);

        while (!queue.isEmpty()) {
            Integer num = queue.poll();
            if (duplicationSet.contains(num)) {
                continue;
            }
            duplicationSet.add(num);
            for (Integer i : map.get(num)) {
                if (!duplicationSet.contains(i)) {
                    queue.add(i);
                    answer[i] = num;
                }
            }
        }
    }

}
