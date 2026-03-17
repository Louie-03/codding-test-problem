package acmicpc.no1325;

import java.time.LocalTime;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.junit.jupiter.api.Test;

class MainTest {

    @Test
    void name() {
        int n = 5;
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            map.put(i, new HashSet<>());
        }

        map.get(3).add(1);
        map.get(3).add(2);
        map.get(4).add(3);
        map.get(5).add(3);

//        assertThat(solution(map, n)).containsExactly(1, 2);
    }

    @Test
    void name2() {
        System.out.println(LocalTime.now());
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int i = 1; i < 10000; i++) {
            map.put(i, new HashSet<>());
            map.get(i).add(i + 1);
        }

        System.out.println(LocalTime.now());
//        Main.solution(1, 1, map, new HashMap<>(), new HashSet<>());
        System.out.println(LocalTime.now());
    }
}
