package acmicpc.no1707;

import static acmicpc.no1707.Main.bfs;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import org.junit.jupiter.api.Test;

class MainTest {

    @Test
    void name() {
        System.out.println(LocalDateTime.now());
        Map<Integer, List<Integer>> map = new HashMap<>();
        int v = 20000;
        for (int i = 1; i <= v; i++) {
            map.put(i, new ArrayList<>());
        }
        Random random = new Random();
        int e = 200000;
        for (int i = 0; i < e; i++) {
            int a = random.nextInt(20000) + 1;
            int b = random.nextInt(20000) + 1;
            map.get(a).add(b);
            map.get(b).add(a);
        }
        boolean[] check = new boolean[v + 1];
        System.out.println(bfs(v, map, check));
        System.out.println(LocalDateTime.now());
    }

    @Test
    void name2() {
        boolean[] booleans = new boolean[10];
        int i = 0;
        for (boolean aBoolean : booleans) {
            if (i == 2) {
                booleans[5] = true;
            }
            System.out.println(aBoolean);
            i++;
        }
    }
}
