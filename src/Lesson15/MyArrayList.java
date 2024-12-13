package Lesson15;

import java.util.Arrays;

public class MyArrayList<T> {

    private Node<T> head;
    private int size;

    public MyArrayList() {
    }

    public MyArrayList(T...data) {
        for (T t : data) {
            add(t);
        }
    }

    public void add(T data) {
        if (head != null) {
            Node<T> nextElement = head;
            for (int i = 0; i < size; i++) {
                if (nextElement.next == null) {
                    nextElement.next = new Node<>(data);
                    size++;
                    return;
                }
                nextElement = nextElement.next;
            }
        } else {
            head = new Node<>(data);
            size++;
        }
    }

    public void add(int index, T data) {
        if (index < 0 || index > size -1) {
            System.out.println("Index out of bounds");
            return;
        }
        Node<T> oldElement = head;
        Node<T> newElement = new Node<>(data);
        for (int i = 0; i < index; i++) {
            oldElement = oldElement.next;
        }
        newElement.next = oldElement.next;
        oldElement.next = newElement;
        size++;
    }

    public T get(int index) {
        if (index < 0 || index > size -1) {
            System.out.println("Index out of bounds");
            return null;
        }
        Node<T> result = head;
        for (int i = 0; i < index; i++) {
            result = result.next;
        }
        return result.data;
    }

    public int size() {
        return size;
    }

    @Override
    public String toString() {
        String[] array = new String[size];
        Node<T> nextElement = head;
        for (int i = 0; i < size; i++) {
            array[i] = nextElement.data.toString();
            if (nextElement.next == null) break;
            nextElement = nextElement.next;
        }
        return Arrays.toString(array);
    }
}
