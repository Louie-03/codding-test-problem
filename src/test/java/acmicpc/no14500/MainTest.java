package acmicpc.no14500;

import java.util.Random;
import org.junit.jupiter.api.Test;

class MainTest {

    @Test
    void name() {
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 500; i++) {
            for (int j = 0; j < 500; j++) {
                sb.append(random.nextInt(1000) + " ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
