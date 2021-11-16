import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestJava {

    @Test
    void test() {
        Tv tv = null;
        ExtendTv extendTv = new ExtendTv();
        extendTv.method2();

        tv = extendTv;
        ExtendTv extendTv2 = (ExtendTv) tv;
        extendTv2.method2();
    }

}
