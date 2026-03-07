package acmicpc.no10870;

import org.junit.jupiter.api.Test;

import static acmicpc.no10870.Main.solution;
import static org.assertj.core.api.Assertions.assertThat;

class MainTest {

    @Test
    void name() {
        assertThat(solution(0)).isEqualTo(0);
        assertThat(solution(1)).isEqualTo(1);
        assertThat(solution(2)).isEqualTo(1);
        assertThat(solution(10)).isEqualTo(55);
    }
}