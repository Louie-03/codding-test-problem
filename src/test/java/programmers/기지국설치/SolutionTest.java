package programmers.기지국설치;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class SolutionTest {

    @Test
    void name() {
        Solution solution = new Solution();
        assertThat(solution.solution(11, new int[]{4, 11}, 1)).isEqualTo(3);
        assertThat(solution.solution(16, new int[]{9}, 2)).isEqualTo(3);
    }
}
