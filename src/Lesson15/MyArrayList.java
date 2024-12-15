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
            Node<T> tmpElement = head;
            for (int i = 0; i < size; i++) {
                if (tmpElement.next == null) {
                    tmpElement.next = new Node<>(data);
                    size++;
                    return;
                }
                tmpElement = tmpElement.next;
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
        Node<T> newElement = new Node<>(data);
        if (index == 0) {
            newElement.next = head;
            head = newElement;
            size++;
            return;
        }
        Node<T> tmpElement = head;
        for (int i = 1; i < index; i++) {
            tmpElement = tmpElement.next;
        }
        newElement.next = tmpElement.next;
        tmpElement.next = newElement;
        size++;
    }

    public void remove(T data) {
        if (head.data.equals(data)) {
            head = head.next;
            size--;
            return;
        }
        Node<T> tmp = head;
        for (int i = 1; i < size; i++) {
            if (tmp.next.data.equals(data)) {
                tmp.next = tmp.next.next;
                size--;
                return;
            }
            tmp = tmp.next;
        }
    }

    public void remove(int index) {
        if (index < 0 || index > size -1) {
            System.out.println("index out of bounds");
            return;
        }
        if (index == 0) {
            head = head.next;
            size--;
            return;
        }
        Node<T> tmp = head;
        for (int i = 1; i < index; i++) {
            tmp = tmp.next;
        }
        tmp.next = tmp.next.next;
        size--;
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

    public void set(int index, T data) {
        if (index < 0 || index > size -1) {
            System.out.println("index out of bounds");
            return;
        }
        Node<T> tmp = head;
        for (int i = 0 ; i < index; i++) {
            tmp = tmp.next;
        }
        tmp.data = data;
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
