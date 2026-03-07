package acmicpc.no21317;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static acmicpc.no21317.Main.solution;
import static org.assertj.core.api.Assertions.assertThat;

class MainTest {

    @Test
    void name() {
        assertThat(solution(1, new int[]{0}, new int[]{0}, 100)).isEqualTo(0);
        assertThat(solution(2, new int[]{0, 100}, new int[]{0, 1}, 10)).isEqualTo(100);
        assertThat(solution(3, new int[]{0, 100, 100}, new int[]{0, 50, 1}, 10)).isEqualTo(50);
        assertThat(solution(5, new int[]{0, 1, 2, 4, 6}, new int[]{0, 2, 3, 5, 7}, 4)).isEqualTo(5);
        assertThat(solution(5, new int[]{0, 1, 2, 4, 6}, new int[]{0, 2, 3, 5, 7}, 100)).isEqualTo(7);
        assertThat(solution(5, new int[]{0, 2, 3, 5, 7}, new int[]{0, 1, 2, 4, 6}, 4)).isEqualTo(5);
        assertThat(solution(5, new int[]{0, 5, 5, 1, 2}, new int[]{0, 2, 3, 3, 4}, 3)).isEqualTo(5);
        assertThat(solution(6, new int[]{0, 1, 2, 4, 6, 1}, new int[]{0, 2, 3, 5, 2, 2}, 1)).isEqualTo(3);
    }

    @Test
    void 기본형_배열_비교_학습_테스트() {
        int[] ints1 = {1, 2, 3};
        int[] ints2 = {1, 2, 3};

        assertThat(ints1.equals(ints2)).isFalse();
        assertThat(ints1 == ints2).isFalse();
        assertThat(Arrays.equals(ints1, ints2)).isTrue();
    }

}