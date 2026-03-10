package acmicpc.no2579;

import static acmicpc.no2579.Main.solution;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class MainTest {

    @Test
    void name() {
        assertThat(solution(1, new int[]{100})).isEqualTo(100);
        assertThat(solution(2, new int[]{100, 200})).isEqualTo(300);
        assertThat(solution(3, new int[]{200, 400, 100})).isEqualTo(500);
        assertThat(solution(3, new int[]{700, 100, 100})).isEqualTo(800);
        assertThat(solution(5, new int[]{100, 10, 100, 10, 100})).isEqualTo(300);
        assertThat(solution(5, new int[]{100, 100, 200, 1000, 1})).isEqualTo(1201);
        assertThat(solution(6, new int[]{10, 20, 15, 25, 10, 20})).isEqualTo(75);
        assertThat(solution(4, new int[]{1, 2, 4, 3})).isEqualTo(8);
        assertThat(solution(4, new int[]{10, 5, 3, 20})).isEqualTo(35);
        assertThat(solution(4, new int[]{10, 1, 1, 10})).isEqualTo(21);
        assertThat(solution(8, new int[]{5, 5, 16, 18, 6, 9, 17, 20})).isEqualTo(71);
        assertThat(solution(7, new int[]{25, 29, 14, 2, 9, 17, 16})).isEqualTo(89);
        assertThat(solution(5, new int[]{9, 6, 8, 4, 4})).isEqualTo(23);
        assertThat(solution(5, new int[]{4, 2, 8, 9, 8})).isEqualTo(23);
        assertThat(solution(5, new int[]{2, 1, 4, 16, 8})).isEqualTo(27);
        assertThat(solution(4, new int[]{1, 2, 4, 3})).isEqualTo(8);
        assertThat(solution(8, new int[]{251, 333, 571, 24, 6, 65, 378, 337})).isEqualTo(1625);
        /**
         * 251 333 571 24  6   65  378  337
         * 251 333 822 608 910 911 1288 1312
         * 251 584 904 846 614 975 1289 1625
         *
         * 251 333 822 904 910 911 1289 1625
         */
    }

    @Test
    void name2() {
        int[] ints = new int[300];
        for (int i = 0; i < 300; i++) {
            ints[i] = 10000;
        }
        System.out.println(solution(300, ints));
    }

}
