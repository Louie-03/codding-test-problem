package acmicpc.no2331;

import static acmicpc.no2331.Main.getValue;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;

class MainTest {

    @Test
    void 반복수열의_길이_확인() {
        for (int i = 1; i < 10000; i++) {
            List<Integer> list = new ArrayList<>();
            list.add(i);
            Map<Integer, Integer> map = new HashMap<>();
            for (int j = 1; j < 100; j++) {
                int value = getValue(list.get(j - 1), 5);
                list.add(value);
                map.put(value, map.getOrDefault(value, 0) + 1);
            }
            int count = 0;
            for (Integer integer : map.keySet()) {
                if (map.get(integer) != 1) {
                    count++;
                }
            }
            if (count == 0) {
                System.out.println(i);
            }
        }
    }
}
