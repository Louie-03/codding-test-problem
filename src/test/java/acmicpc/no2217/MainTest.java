package acmicpc.no2217;

import static acmicpc.no2217.Main.*;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class MainTest {

    @Test
    void name() {
        assertThat(solution(new int[]{10, 15})).isEqualTo(20);
        assertThat(solution(new int[]{1, 10, 15})).isEqualTo(20);
    }
}
