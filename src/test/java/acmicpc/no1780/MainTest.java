package acmicpc.no1780;

import static acmicpc.no1780.Main.counts;
import static acmicpc.no1780.Main.ints;
import static acmicpc.no1780.Main.recursive;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class MainTest {

    @Test
    void name() {
        int n = 9;
        ints = new int[n][n];

        recursive(0, 0, n);

        assertThat(counts[0]).isEqualTo(0);
        assertThat(counts[1]).isEqualTo(1);
        assertThat(counts[2]).isEqualTo(0);
    }
}
