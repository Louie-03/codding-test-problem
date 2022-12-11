package acmicpc.no2606;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MainTest {

    @Test
    void name() {
        System.out.println(acker(4, 1));
    }

    private int acker(int m, int n) {
        if (m == 0)
            return n + 1;
        if (n == 0)
            return acker(m -1, 1);
        return acker(m - 1, acker(m, n - 1));
    }
}
