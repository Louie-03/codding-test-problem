package programmers.입국심사;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class SolutionTest {

    @Test
    void name() {
        Solution solution = new Solution();

        assertThat(solution.solution(6, new int[]{7, 10}))
            .isEqualTo(28);
        assertThat(solution.solution(1000000000, new int[]{1000000000}))
            .isEqualTo(1000000000000000000L);
    }
}
