package programmers.타겟넘버;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class SolutionTest {

    @Test
    void name() {
        Solution solution = new Solution();

        assertThat(solution.solution(new int[]{1, 1, 1, 1, 1}, 3)).isEqualTo(5);
        assertThat(solution.solution(new int[]{4, 1, 2, 1}, 4)).isEqualTo(2);
    }
}
