package acmicpc.no2501;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class MainTest {

    @Test
    void test() {
        assertThat(Main.solution(1, 3)).isEqualTo(0);
        assertThat(Main.solution(6, 3)).isEqualTo(3);
        assertThat(Main.solution(6, 4)).isEqualTo(6);
        assertThat(Main.solution(6, 6)).isEqualTo(0);
        assertThat(Main.solution(25, 4)).isEqualTo(0);
        assertThat(Main.solution(2735, 1)).isEqualTo(1);

    }

    @Test
    void 자바_나머지_문법_확인1() {
        assertThat(1 % 2).isEqualTo(1);
        assertThat(2 % 2).isEqualTo(0);
        assertThat(3 % 2).isEqualTo(1);
        assertThat(4 % 5).isEqualTo(4);
    }

    @Test
    void 자바_나머지_문법_확인2() {
        for (int i = 0; i < 100; i++) {
            System.out.println(i + " / 3 = " + i / 3);
            System.out.println(i + " % 3 = " + i % 3);
        }
    }
}
