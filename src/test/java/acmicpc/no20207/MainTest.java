package acmicpc.no20207;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MainTest {

    @Test
    void name() {
        Runtime.getRuntime().gc();
        int[][] ints = new int[1000][365];
        for (int i = 0; i < 1000; i++) {
            for (int j = 0; j < 365; j++) {
                ints[i][j] = 10000;
            }
        }

        long usedMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        System.out.print(usedMemory + " bytes");
    }
}
