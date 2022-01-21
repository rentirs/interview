package ru.gb.lesson2;

import java.util.NoSuchElementException;

public class ArrayList<E extends Comparable<E>>{
    private E[] list;
    private int size;

    private final int DEFAULT_CAPACITY = 10;

    public ArrayList(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("capacity: " + capacity);
        }
        list = (E[]) new Comparable[capacity];
    }

    public ArrayList() {
        list = (E[]) new Comparable[DEFAULT_CAPACITY];
    }

    public void add(E item) {
        if (list.length == size) {
            addCapacity();
        }

        list[size] = item;
        size++;
    }

    public void add(int index, E item) {
        if (index >= 0 && index <= size) {
            if (list.length == size) {
                addCapacity();
            }
            for (int i = size; i > index; i--) {
                list[i] = list[i - 1];
            }
            list[index] = item;
            size++;
        } else {
            throw new IndexOutOfBoundsException("index: " + index + ", size: " + size);
        }
    }

    public void remove(int index) {
        if (isEmpty()) {
            throw new NoSuchElementException();
        } else if (index < 0 && index >= size) {
            throw new IndexOutOfBoundsException("index: " + index + ", size: " + size);
        }
        for (int i = index; i <= size; i++) {
            list[i] = list[i + 1];
        }
        size--;
        list[size] = null;
    }

    public boolean remove(E item) {
        int i = index(item);
        if (i == -1) {
            return false;
        }
        remove(i);
        return true;
    }

    public E get(int index) {
        if (index <= 0 || index > size()) {
            throw new IllegalArgumentException("index: " + index);
        }
        return list[index];
    }

    public int indexOf(E item) {
        return index(item);
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    private int index(E item) {
        int i;
        for (i = 0; i < size; i++) {
            if (list[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    private void addCapacity() {
        E[] arr = (E[]) new Comparable[list.length + (list.length / 2 + 1)];
        System.arraycopy(list, 0, arr, 0, list.length);
        list = arr;
    }
}
