package programmers.단어변환;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class SolutionTest {

    @Test
    void name() {
        assertThat(new Solution().solution("hit", "cog",
            new String[]{"hot", "dot", "dog", "lot", "log", "cog"}))
            .isEqualTo(4);
        assertThat(new Solution().solution("hit", "cog",
            new String[]{"hot", "dot", "dog", "lot", "log"}))
            .isEqualTo(0);
    }
}
