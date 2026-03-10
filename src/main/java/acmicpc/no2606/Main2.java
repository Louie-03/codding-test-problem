package acmicpc.no2606;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

public class Main2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            map.put(i, new ArrayList<>());
        }

        for (int i = 0; i < k; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            map.get(a).add(b);
            map.get(b).add(a);

        }

        Set<Integer> duplicationSet = new HashSet<>();
        bfs(map, duplicationSet);

        System.out.println(duplicationSet.size() - 1);
    }

    static void bfs(Map<Integer, List<Integer>> map, Set<Integer> duplicationSet) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        duplicationSet.add(1);

        while (!list.isEmpty()) {
            Integer key = list.get(0);
            List<Integer> list1 = map.get(key);
            list.remove(key);
            for (Integer integer : list1) {
                if (!duplicationSet.contains(integer)) {
                    list.add(integer);
                    duplicationSet.add(integer);
                }
            }
        }

    }
}
