package programmers.숫자게임;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class SolutionTest {

    @Test
    void name() {
        Solution solution = new Solution();
        assertThat(solution.solution(new int[]{5, 1, 3, 7}, new int[]{2, 2, 6, 8}))
            .isEqualTo(3);
        assertThat(solution.solution(new int[]{2, 2, 2, 2}, new int[]{1, 1, 1, 1}))
            .isEqualTo(0);
    }
}
