package acmicpc.no2004;

import static acmicpc.no2004.Main.getCount;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MainTest {

    @DisplayName("5보다 2의 지수가 더 작을 수 있다. 예 : 30C2")
    @Test
    void name() {
        int n = 30;
        for (int i = 0; i <= n; i++) {
            int count1 = getCount(n, 5);
            count1 -= getCount(n - i, 5);
            count1 -= getCount(i, 5);

            int count2 = getCount(n, 2);
            count2 -= getCount(n - i, 2);
            count2 -= getCount(i, 2);
            if (count2 < count1) {
                System.out.println(i + " " + count1 + " " + getCount(n, 2) + " "
                    + getCount(n - i, 2) + " " + getCount(i, 2));
            }
        }
    }
}
