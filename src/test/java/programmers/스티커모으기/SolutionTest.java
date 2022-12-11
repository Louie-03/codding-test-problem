package programmers.스티커모으기;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class SolutionTest {

    @Test
    void name() {
        Solution solution = new Solution();
        assertThat(solution.solution(new int[]{14, 6, 5, 11, 3, 9, 2, 10})).isEqualTo(36);
        assertThat(solution.solution(new int[]{1, 3, 2, 5, 4})).isEqualTo(8);
    }
}
