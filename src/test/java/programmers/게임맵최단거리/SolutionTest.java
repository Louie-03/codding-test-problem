package programmers.게임맵최단거리;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class SolutionTest {

    @Test
    void name() {
        Solution solution = new Solution();

        assertThat(solution.solution(new int[][]{{1, 0}, {1, 1}}))
            .isEqualTo(3);

        assertThat(solution.solution(new int[][]{{1, 0, 1, 1, 1}, {1, 0, 1, 0, 1},
            {1, 0, 1, 1, 1}, {1, 1, 1, 0, 1}, {0, 0, 0, 0, 1}}))
            .isEqualTo(11);

        assertThat(solution.solution(new int[][]{{1, 0, 1, 1, 1}, {1, 0, 1, 0, 1},
            {1, 0, 1, 1, 1}, {1, 1, 1, 0, 0}, {0, 0, 0, 0, 1}}
        )).isEqualTo(-1);
    }
}
