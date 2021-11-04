import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestJava {

    @Test
    void test() {
        boolean[] booleans = new boolean[10];
        for (boolean b : booleans) {
            assertEquals(b, false);
        }
    }

}
