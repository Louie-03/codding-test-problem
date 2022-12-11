package acmicpc.no1541;

import static acmicpc.no1541.Main.solution;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class MainTest {

    @Test
    void name() {
        assertThat(solution("55-50+40")).isEqualTo(-35);
        assertThat(solution("10+20+30+40")).isEqualTo(100);
        assertThat(solution("00009-00009")).isEqualTo(0);
    }
}
