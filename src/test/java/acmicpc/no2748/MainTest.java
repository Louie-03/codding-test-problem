package acmicpc.no2748;

import org.junit.jupiter.api.Test;

import static acmicpc.no2748.Main.solution;
import static org.assertj.core.api.Assertions.assertThat;

class MainTest {

    static int count = 0;

    @Test
    void name() {
        assertThat(solution(1)).isEqualTo(1);
        assertThat(solution(2)).isEqualTo(1);
        assertThat(solution(3)).isEqualTo(2);
        assertThat(solution(4)).isEqualTo(3);
    }

    @Test
    void name2() {
        fibonacci(90);
        System.out.println(count);
    }

    void fibonacci(int n) {
        count++;
        if (n == 0 || n == 1) {
            return;
        }
        fibonacci(n - 1);
        fibonacci(n - 2);
    }
}