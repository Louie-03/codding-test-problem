package acmicpc.no17626;

import org.junit.jupiter.api.Test;

import java.time.LocalTime;

import static acmicpc.no17626.Main.solution;
import static org.assertj.core.api.Assertions.assertThat;

class MainTest {

    @Test
    void name() {
        assertThat(solution(1)).isEqualTo(1);
        assertThat(solution(12)).isEqualTo(3);
        assertThat(solution(13)).isEqualTo(2);
        assertThat(solution(25)).isEqualTo(1);
        assertThat(solution(26)).isEqualTo(2);
        assertThat(solution(11339)).isEqualTo(3); // 105 17 5 / 103 27 1 / 103 21 17
        assertThat(solution(15663)).isEqualTo(4);
        assertThat(solution(34567)).isEqualTo(4);

        System.out.println(LocalTime.now());
        solution(50000);
        System.out.println(LocalTime.now());
    }
}