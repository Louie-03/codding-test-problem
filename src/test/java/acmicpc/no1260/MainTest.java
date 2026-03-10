package acmicpc.no1260;

import static acmicpc.no1260.Main.bfs;
import static acmicpc.no1260.Main.dfs;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;

class MainTest {

    @Test
    void name() {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 1; i <= 4; i++) {
            map.put(i, new ArrayList<>());
        }

        List<Integer> list1 = map.get(1);
        list1.add(2);
        list1.add(3);
        list1.add(4);

        map.get(2).add(1);
        map.get(3).add(1);
        map.get(4).add(1);

        map.get(2).add(4);
        map.get(4).add(2);
        map.get(3).add(4);
        map.get(4).add(3);

        StringBuilder dfsSb = new StringBuilder();
        dfs(1, map, dfsSb, new HashSet<>());
        StringBuilder bfsSb = new StringBuilder();
        bfs(1, map, bfsSb);

        assertThat(dfsSb.toString()).isEqualTo("1 2 4 3 ");
        assertThat(bfsSb.toString()).isEqualTo("1 2 3 4 ");
    }
}
