package acmicpc.no9613;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class MainTest {

    public static final int MAX_INPUT_VALUE = 1000000;

    @Test
    void maxRangeTest() {
        long count = 0;
        for (int i = 0; i < 100; i++) {
            for (int j = i + 1; j < 100; j++) {
                count++;
            }
        }
        assertThat(count * MAX_INPUT_VALUE).isGreaterThan(Integer.MAX_VALUE);
    }

}
