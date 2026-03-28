package programmers.피로도;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class SolutionTest {

    @Test
    void name() {
        assertThat(new Solution().solution(80, new int[][]{{80, 20}, {50, 40}, {30, 10}}))
            .isEqualTo(3);
        assertThat(new Solution().solution(80, new int[][]{{50, 40}, {80, 20}, {30, 10}}))
            .isEqualTo(3);
        assertThat(new Solution().solution(20, new int[][]{{80, 20}, {50, 40}, {30, 10}}))
            .isEqualTo(0);
        assertThat(new Solution().solution(20, new int[][]{{80, 20}}))
            .isEqualTo(0);
        assertThat(new Solution().solution(80, new int[][]{{80, 20}}))
            .isEqualTo(1);
        assertThat(new Solution().solution(90, new int[][]{{50, 40}, {80, 20}, {30, 20}, {20, 10}}))
            .isEqualTo(3);
    }
}
