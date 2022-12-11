package acmicpc.no1912;

import static acmicpc.no1912.Main.solution;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class MainTest {

    @Test
    void name() {
        assertThat(solution(new int[]{10, -4, 3, 1, 5, 6, -35, 12, 21, -1}))
            .isEqualTo(33);

        assertThat(solution(new int[]{2, 1, -4, 3, 4, -4, 6, 5, -5, 1}))
            .isEqualTo(14);

        assertThat(solution(new int[]{-1, -2, -3, -4, -5}))
            .isEqualTo(-1);
    }
}
