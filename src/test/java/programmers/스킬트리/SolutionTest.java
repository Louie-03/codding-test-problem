package programmers.스킬트리;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class SolutionTest {

    static Solution solution;

    @BeforeAll
    static void beforeAll() {
        solution = new Solution();
    }

    @Test
    void name() {
        assertThat(solution.solution("CBD",
            new String[]{"BACDE", "CBADF", "AECB", "BDA"})).isEqualTo(2);
    }
}
