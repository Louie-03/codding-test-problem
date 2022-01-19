package programmers;

import org.junit.jupiter.api.Test;

import java.util.List;

class No42840Test {

    @Test
    void testCase() {
        int[] answers1 = {1, 2, 3, 4, 5};
        int[] answers2 = {1, 3, 2, 4, 2};

        List<Integer> solution = new No42840().solution(answers2);
        for (int i : solution) {
            System.out.println(i);
        }
    }
}