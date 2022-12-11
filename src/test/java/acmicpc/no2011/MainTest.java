package acmicpc.no2011;

import static acmicpc.no2011.Main.DP;
import static acmicpc.no2011.Main.isCanMakeAlphabet;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class MainTest {

    @Test
    void name() {
        assertThat(DP("1024")).isEqualTo(2);
        assertThat(DP("25114")).isEqualTo(6);
        assertThat(DP("1111111111")).isEqualTo(89);
        assertThat(DP("01234")).isEqualTo(0);
        assertThat(DP("1004")).isEqualTo(0);
        assertThat(DP("121074110")).isEqualTo(2);

        assertThat(DP("0")).isEqualTo(0);
        assertThat(DP("011")).isEqualTo(0);
        assertThat(DP("0101")).isEqualTo(0);
        assertThat(DP("1203")).isEqualTo(1);
        assertThat(DP("2626")).isEqualTo(4);
        assertThat(DP("2727")).isEqualTo(1);
        assertThat(DP("1")).isEqualTo(1);
        assertThat(DP("9")).isEqualTo(1);
        assertThat(DP("10")).isEqualTo(1);
        assertThat(DP("20")).isEqualTo(1);
        assertThat(DP("11")).isEqualTo(2);
        assertThat(DP("26")).isEqualTo(2);
        assertThat(DP("27")).isEqualTo(1);
        assertThat(DP("30")).isEqualTo(0);
        assertThat(DP("01")).isEqualTo(0);
        assertThat(DP("99")).isEqualTo(1);
        assertThat(DP("100")).isEqualTo(0);
        assertThat(DP("123")).isEqualTo(3);
        assertThat(DP("101")).isEqualTo(1);
        assertThat(DP("110")).isEqualTo(1);
        assertThat(DP("103")).isEqualTo(1);
        assertThat(DP("000")).isEqualTo(0);
        assertThat(DP("007")).isEqualTo(0);
        assertThat(DP("1010")).isEqualTo(1);
        assertThat(DP("1012")).isEqualTo(2);
        assertThat(DP("2220")).isEqualTo(2);
        assertThat(DP("2626")).isEqualTo(4);
        assertThat(DP("123456789")).isEqualTo(3);
        assertThat(DP("9876543210")).isEqualTo(1);
        assertThat(DP("30")).isEqualTo(0);
        assertThat(DP("2626")).isEqualTo(4);
        assertThat(DP("2727")).isEqualTo(1);
    }

    @Test
    void name2() {
        assertThat(isCanMakeAlphabet('0', '1')).isTrue();
        assertThat(isCanMakeAlphabet('6', '2')).isTrue();
        assertThat(isCanMakeAlphabet('1', '1')).isTrue();

        assertThat(isCanMakeAlphabet('7', '2')).isFalse();
        assertThat(isCanMakeAlphabet('0', '3')).isFalse();
        assertThat(isCanMakeAlphabet('8', '0')).isFalse();
    }

    /*
    121074110

    12 10 7 4 1 10
    1 2 10 7 4 1 10
     */
}
