package acmicpc.no11720;

import static acmicpc.no11720.Main.solution;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.stream.Collectors;
import org.junit.jupiter.api.Test;

class MainTest {

    private final String strings = "1234567890";

    @Test
    void name() {
        assertThat(solution(1, "1")).isEqualTo(1);
        assertThat(solution(5, "54321")).isEqualTo(15);
        assertThat(solution(25, "7000000000000000000000000")).isEqualTo(7);
        assertThat(solution(11, "10987654321")).isEqualTo(46);
    }

    @Test
    void integer_parseInt_학습_테스트() {
        assertThat(Integer.parseInt("123")).isEqualTo(123);
        assertThatThrownBy(() -> Integer.parseInt("123A"))
            .isInstanceOf(NumberFormatException.class);
    }

    @Test
    void string_chars_학습_테스트() {
        int[] ints = strings.chars().toArray();
        for (int i : ints) {
            System.out.println(i);
        }
    }

    @Test
    void collectors_toList_학습_테스트() {
//        기본형은 boxing해줘야 사용 가능
        strings.chars().boxed().collect(Collectors.toList())
            .forEach(System.out::println);
    }

    @Test
    void string_charAt_학습_테스트() {
        for (int i = 0; i < strings.length(); i++) {
            System.out.println(strings.charAt(i));
            System.out.println(Integer.valueOf(strings.charAt(i)));
            System.out.println();
        }
    }

}
