package acmicpc.no1325;

import java.time.LocalTime;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.junit.jupiter.api.Test;

class Main2Test {

    @Test
    void name() {
        System.out.println(LocalTime.now());
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int i = 1; i < 10000; i++) {
            map.put(i, new HashSet<>());
            map.get(i).add(i + 1);
        }
        Map<Integer, Integer> countMap = new HashMap<>();
        LocalTime start = LocalTime.now();
        for (int i = 1; i < 10000; i++) {
//            Main2.bfs(map, countMap, new boolean[10001], i);
        }
        LocalTime end = LocalTime.now();
        for (int i = 1; i < 10000; i++) {
            System.out.println(i + " : " + countMap.get(i));
        }
        System.out.println(start);
        System.out.println(end);
    }

    @Test
    void name2() {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        System.out.println(LocalTime.now());
        for (int i = 1; i < 10000; i++) {
            map.put(i, new HashSet<>());
            for (int j = 0; j < 10; j++) {
                map.get(i).add(j + 1);
            }
        }
        System.out.println(LocalTime.now());
    }

    @Test
    void name3() {
        System.out.println(LocalTime.now());
        dfs(1);
        System.out.println(LocalTime.now());

        // TODO: 2026/03/17 Exception 발생, dfs 불가능
    }

    private void dfs(int count) {
        if (count != 100000) {
            dfs(++count);
        }
    }
}
