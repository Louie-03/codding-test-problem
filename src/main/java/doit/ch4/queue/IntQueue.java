package doit.ch4.queue;

import doit.ch4.exception.EmptyException;
import doit.ch4.exception.OverflowException;

public class IntQueue {
    private final int[] elements;
    private int capacity;
    private int size;

    public IntQueue(int capacity) {
        this.elements = new int[capacity];
        this.capacity = capacity;
    }

    public IntQueue() {
        this(10);
    }

    public int enque(int element) {
        if (size == capacity) {
            throw new OverflowException();
        }
        elements[size++] = element;
        return element;
    }

    public int deque() {
        if (isEmpty()) {
            throw new EmptyException();
        }
        int element = elements[0];
        for (int i = 0; i < --size; i++) {
            elements[i] = elements[i + 1];
        }
        return element;
    }

    public int peek() {
        if (isEmpty()) {
            throw new EmptyException();
        }
        return elements[0];
    }

    public int indexOf(int x) {
        for (int i = 0; i < size; i++) {
            if (elements[i] == x) {
                return i;
            }
        }
        return -1;
    }

    public void clear() {
        size = 0;
    }

    public int capacity() {
        return capacity;
    }

    public int size() {
        return size       ;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == capacity;
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
