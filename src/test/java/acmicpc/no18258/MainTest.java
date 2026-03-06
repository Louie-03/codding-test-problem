package acmicpc.no18258;

import org.junit.jupiter.api.Test;

import java.time.LocalTime;
import java.util.LinkedList;
import java.util.Queue;

import static org.assertj.core.api.Assertions.assertThat;

class MainTest {

    @Test
    void name() {
    }

    @Test
    void name2() {
        LocalTime a1 = LocalTime.now();
        for (int i = 0; i < 2000000; i++) {
            System.out.println(1);
        }
        LocalTime a2 = LocalTime.now();
        System.out.println("a1 = " + a1);
        System.out.println("a2 = " + a2);
    }

    @Test
    void name3() {
        LocalTime a1 = LocalTime.now();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 2000000; i++) {
            sb.append("1\n");
        }
        System.out.println(sb);
        LocalTime a2 = LocalTime.now();
        System.out.println("a1 = " + a1);
        System.out.println("a2 = " + a2);
    }

    @Test
    void stringBuilder_학습_테스트() {
        LocalTime a1 = LocalTime.now();
        for (int i = 0; i < 2000000; i++) {
            System.out.println(1);
        }
        LocalTime a2 = LocalTime.now();

        LocalTime b1 = LocalTime.now();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 2000000; i++) {
            sb.append("1\n");
        }
        System.out.println(sb);
        LocalTime b2 = LocalTime.now();
        System.out.println(a1);
        System.out.println(a2);
        System.out.println(b1);
        System.out.println(b2);
    }

    @Test
    void queue_학습_테스트() {
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i < 11; i++) {
            queue.add(i);
        }

        System.out.println("size : " + queue.size());

        while (!queue.isEmpty()) {
            System.out.println(queue.poll());
        }

        System.out.println("size : " + queue.size());
    }

    @Test
    void queue_pull_학습_테스트() {
        Queue<Integer> queue = new LinkedList<>();

        queue.add(5);

        assertThat(queue.poll()).isEqualTo(5);
        assertThat(queue.poll()).isNull();
    }
}