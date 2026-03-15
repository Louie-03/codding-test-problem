package acmicpc.no11725;

import org.junit.jupiter.api.Test;

import java.util.*;

import static acmicpc.no11725.Main2.*;
import static org.assertj.core.api.Assertions.assertThat;

class Main2Test {

    @Test
    void name() {
        int[] answer1 = new int[8];
        dfs(1, new HashSet<>(), answer1, createTestCase1());
        int[] expectAnswer1 = {0, 0, 4, 6, 1, 3, 1, 4};
        assertThat(expectAnswer1).containsExactly(answer1);

        int[] answer2 = new int[13];
        dfs(1, new HashSet<>(), answer2, createTestCase2());
        int[] expectAnswer2 = {0, 0, 1, 1, 2, 3, 3, 4, 4, 5, 5, 6, 6};
        assertThat(expectAnswer2).containsExactly(answer2);

        int[] answer3 = new int[7];
        dfs(1, new HashSet<>(), answer3, createTestCase3());
        int[] expectAnswer3 = {0, 0, 3, 1, 1, 3, 4};
        assertThat(expectAnswer3).containsExactly(answer3);

        int[] answer4 = new int[3];
        dfs(1, new HashSet<>(), answer4, createTestCase4());
        int[] expectAnswer4 = {0, 0, 1};
        assertThat(expectAnswer4).containsExactly(answer4);

        /**
         *      1
         *   3    4
         *  2 5    6
         */
    }

    @Test
    void assertThat_containsExactly_학습_테스트() {
        assertThat(new int[]{1, 2, 3}).containsExactly(1, 2, 3);
        assertThat(new int[]{1, 2, 3, 3}).containsExactly(1, 2, 3, 3);

//        아래 테스트는 순서, 개수가 다르므로 불가능, 1233/123처럼 중복된 값의 개수가 달라도 불가
//        assertThat(new int[]{1, 2, 3, 3}).containsExactly(1, 2, 3);
//        assertThat(new int[]{1, 2, 3}).containsExactly(3, 2, 1);
    }

    private Map<Integer, List<Integer>> createTestCase1() {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 1; i <= 7; i++) {
            map.put(i, new ArrayList<>());
        }

        map.get(1).add(6);
        map.get(6).add(1);
        map.get(6).add(3);
        map.get(3).add(6);
        map.get(3).add(5);
        map.get(5).add(3);
        map.get(4).add(1);
        map.get(1).add(4);
        map.get(2).add(4);
        map.get(4).add(2);
        map.get(4).add(7);
        map.get(7).add(4);

        return map;
    }

    private Map<Integer, List<Integer>> createTestCase2() {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 1; i <= 12; i++) {
            map.put(i, new ArrayList<>());
        }

        map.get(1).add(2);
        map.get(2).add(1);
        map.get(1).add(3);
        map.get(3).add(1);
        map.get(2).add(4);
        map.get(4).add(2);
        map.get(3).add(5);
        map.get(5).add(3);
        map.get(3).add(6);
        map.get(6).add(3);
        map.get(4).add(7);
        map.get(7).add(4);
        map.get(4).add(8);
        map.get(8).add(4);
        map.get(5).add(9);
        map.get(9).add(5);
        map.get(5).add(10);
        map.get(10).add(5);
        map.get(6).add(11);
        map.get(11).add(6);
        map.get(6).add(12);
        map.get(12).add(6);

        return map;
    }

    private Map<Integer, List<Integer>> createTestCase3() {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 1; i <= 6; i++) {
            map.put(i, new ArrayList<>());
        }

        map.get(1).add(3);
        map.get(3).add(1);
        map.get(1).add(4);
        map.get(4).add(1);
        map.get(3).add(2);
        map.get(2).add(3);
        map.get(3).add(5);
        map.get(5).add(3);
        map.get(4).add(6);
        map.get(6).add(4);

        return map;
    }

    private Map<Integer, List<Integer>> createTestCase4() {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 1; i <= 2; i++) {
            map.put(i, new ArrayList<>());
        }

        map.get(1).add(2);
        map.get(2).add(1);

        return map;
    }

}