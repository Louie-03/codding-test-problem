package doit.ch4.stack.gstack;

import doit.ch4.exception.EmptyException;
import doit.ch4.exception.OverflowException;

public class GStack<E> {
    private final Object[] elements;
    private final int capacity;
    private int size;

    public GStack(int capacity) {
        this.elements = new Object[capacity];
        this.capacity = capacity;
    }

    public GStack() {
        this(10);
    }

    public int size() {
        return size;
    }

    public int capacity() {
        return capacity;
    }

    public E push(E num) {
        if (capacity == size) {
            throw new OverflowException();
        }
        elements[size++] = num;
        return num;
    }

    public E peek() {
        if (size == 0) {
            throw new EmptyException();
        }
        return (E) elements[size - 1];
    }

    public E pop() {
        if (size == 0) {
            throw new EmptyException();
        }
        return (E) elements[--size];
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
