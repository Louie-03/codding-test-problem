package doit.intstack;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class IntStackTest {
    @Test
    void name() {
        IntStack stack = new IntStack();

        assertThat(stack.capacity()).isEqualTo(10);
        assertThat(stack.size()).isEqualTo(0);

        stack.push(1);
        stack.push(2);

        assertThat(stack.size()).isEqualTo(2);
        assertThat(stack.peek()).isEqualTo(2);

        assertThat(stack.pop()).isEqualTo(2);
        assertThat(stack.size()).isEqualTo(1);

        assertThat(stack.pop()).isEqualTo(1);
        assertThat(stack.size()).isEqualTo(0);

        assertThat(stack.capacity()).isEqualTo(10);

        assertThatThrownBy(() -> stack.peek())
                .isInstanceOf(EmptyIntStackException.class);

        assertThatThrownBy(() -> stack.pop())
                .isInstanceOf(EmptyIntStackException.class);
    }

    @Test
    void name2() {
        IntStack stack = new IntStack(0);

        assertThatThrownBy(() -> stack.push(1))
                .isInstanceOf(OverflowIntStackException.class);
    }
}
