package doit.stack.gstack;

import doit.ch4.stack.gstack.GStack;
import doit.ch4.exception.EmptyException;
import doit.ch4.exception.OverflowException;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class GStackTest {

    @Test
    void name() {
        GStack<String> stack = new GStack<>();

        assertThat(stack.capacity()).isEqualTo(10);
        assertThat(stack.size()).isEqualTo(0);

        stack.push("1");
        stack.push("2");

        stack.dump();

        assertThat(stack.peek()).isEqualTo("2");
        assertThat(stack.size()).isEqualTo(2);

        assertThat(stack.pop()).isEqualTo("2");
        assertThat(stack.size()).isEqualTo(1);

        assertThat(stack.pop()).isEqualTo("1");
        assertThat(stack.size()).isEqualTo(0);

        assertThat(stack.capacity()).isEqualTo(10);

        assertThatThrownBy(() -> stack.peek())
                .isInstanceOf(EmptyException.class);

        assertThatThrownBy(() -> stack.pop())
                .isInstanceOf(EmptyException.class);
    }

    @Test
    void name2() {
        GStack<Integer> stack = new GStack<>(0);

        assertThatThrownBy(() -> stack.push(1))
                .isInstanceOf(OverflowException.class);
    }
}
