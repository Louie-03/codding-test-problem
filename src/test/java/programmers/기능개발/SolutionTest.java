package programmers.기능개발;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {

    @Test
    void name() {
        assertThat(new Solution().solution(new int[]{93, 30, 55}, new int[]{1, 30, 5}))
                .containsExactly(2, 1);
        assertThat(new Solution().solution(new int[]{95, 90, 99, 99, 80, 99}, new int[]{1, 1, 1, 1, 1, 1}))
                .containsExactly(1, 3, 2);
        assertThat(new Solution().solution(new int[]{95, 90, 99, 99, 80, 70}, new int[]{1, 1, 1, 1, 1, 1}))
                .containsExactly(1, 3, 1, 1);
        assertThat(new Solution().solution(new int[]{95, 97, 96}, new int[]{1, 1, 1}))
                .containsExactly(3);
        assertThat(new Solution().solution(new int[]{93}, new int[]{1}))
                .containsExactly(1);
        assertThat(new Solution().solution(new int[]{93}, new int[]{1}))
                .containsExactly(1);
        assertThat(new Solution().solution(new int[]{95, 99, 99, 99, 99, 99}, new int[]{100, 1, 1, 1, 1, 1}))
                .containsExactly(6);
        assertThat(new Solution().solution(new int[]{95, 99, 99, 99, 99, 99}, new int[]{1, 1, 1, 1, 1, 1}))
                .containsExactly(6);
        assertThat(new Solution().solution(new int[]{95, 9, 9, 9, 9, 9}, new int[]{1, 1, 1, 1, 1, 1}))
                .containsExactly(1, 5);
        assertThat(new Solution().solution(new int[]{95, 9, 9, 5, 9, 9}, new int[]{1, 1, 1, 1, 1, 1}))
                .containsExactly(1, 2, 3);
    }
}