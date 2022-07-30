package doit.intstack;

import java.util.Arrays;

public class IntStack {
    private int[] elements;
    private int size;
    private int capacity;

    public IntStack(int capacity) {
        this.elements = new int[capacity];
        this.capacity = capacity;
    }

    public IntStack() {
        this(10);
    }

    public int size() {
        return size;
    }

    public int capacity() {
        return capacity;
    }

    public int push(int num) {
        if (capacity == size) {
            throw new OverflowIntStackException();
        }
        elements[size++] = num;
        return num;
    }

    public int peek() {
        if (size == 0) {
            throw new EmptyIntStackException();
        }
        return elements[size - 1];
    }

    public int pop() {
        if (size == 0) {
            throw new EmptyIntStackException();
        }
        return elements[--size];
    }

    public void dump() {
        System.out.println(Arrays.toString(elements));
    }
}
