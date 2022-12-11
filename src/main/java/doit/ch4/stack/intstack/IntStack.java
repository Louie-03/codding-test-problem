package doit.ch4.stack.intstack;

import doit.ch4.exception.EmptyException;
import doit.ch4.exception.OverflowException;

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
            throw new OverflowException();
        }
        elements[size++] = num;
        return num;
    }

    public int peek() {
        if (size == 0) {
            throw new EmptyException();
        }
        return elements[size - 1];
    }

    public int pop() {
        if (size == 0) {
            throw new EmptyException();
        }
        return elements[--size];
    }

    public void dump() {
        for (int i = 0; i < size; i++) {
            if (i == 0) {
                System.out.print("[");
            }
            System.out.print(elements[i]);
            if (i != size - 1) {
                System.out.print(", ");
            } else {
                System.out.print("]");
            }
        }
        System.out.println();
    }
}
