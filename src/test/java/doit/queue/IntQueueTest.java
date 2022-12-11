package doit.queue;

import doit.ch4.queue.IntQueue;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class IntQueueTest {

    @Test
    void name() {
        IntQueue queue = new IntQueue();
        queue.enque(1);
        queue.enque(2);
        queue.enque(3);

        assertThat(queue.size()).isEqualTo(3);
        assertThat(queue.capacity()).isEqualTo(10);
        assertThat(queue.indexOf(2)).isEqualTo(1);

        assertThat(queue.deque()).isEqualTo(1);
        assertThat(queue.size()).isEqualTo(2);

        assertThat(queue.deque()).isEqualTo(2);
        assertThat(queue.peek()).isEqualTo(3);
        assertThat(queue.size()).isEqualTo(1);
    }
}
