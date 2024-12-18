package Lesson15;

public class MyLinkedList<T> {

    private Node<T> head;

    public MyLinkedList() {
    }

    public MyLinkedList(T...data) {
        for (T t : data) {
            add(t);
        }
    }

    public void add(T data) {
        if (head != null) {
            Node<T> tmp = head;
            while (tmp.next != null) {
                tmp = tmp.next;
            }
            tmp.next = new Node<>(data);
        } else {
            head = new Node<>(data);
        }
    }

    public void add(int index, T data) {
        if (index < 0) {
            System.out.println("Index out of bounds");
            return;
        }
        Node<T> newElement = new Node<>(data);
        if (index == 0) {
            newElement.next = head;
            head = newElement;
            return;
        }
        Node<T> tmp = head;
        int size = 0;
        while (tmp.next != null) {
            if (size++ == index-1) {
                break;
            }
            tmp = tmp.next;
        }
        if (index > size) {
            System.out.println("index out of bounds");
            return;
        }
        newElement.next = tmp.next;
        tmp.next = newElement;
    }

    public void remove(T data) {
        if (head.data.equals(data)) {
            head = head.next;
            return;
        }
        Node<T> tmp = head;
        while (tmp.next != null) {
            if (tmp.next.data.equals(data)) {
                tmp.next = tmp.next.next;
                return;
            }
            tmp = tmp.next;
        }
    }

    public void remove(int index) {
        if (index < 0) {
            System.out.println("index out of bounds");
            return;
        }
        if (index == 0) {
            head = head.next;
            return;
        }
        Node<T> tmp = head;
        int size = 0;
        while (tmp.next != null) {
            if (++size == index) {
                tmp.next = tmp.next.next;
                return;
            }
            tmp = tmp.next;
        }
        if (index > size) {
            System.out.println("index out of bounds");
        }
    }

    public T get(int index) {
        if (index < 0) {
            System.out.println("Index out of bounds");
            return null;
        }
        Node<T> result = head;
        int size = 0;
        while (result.next != null) {
            if (size++ == index) {
                break;
            }
            result = result.next;
        }
        if (index > size) {
            System.out.println("index out of bounds");
            return null;
        }
        return result.data;
    }

    public T getNthElementFromTail(int index) {
        if (index < 1) {
            System.out.println("index out of bounds");
            return null;
        }
        Node<T> tmp = head;
        Node<T> delayedElement = head;
        int size = 1;
        while (tmp.next != null) {
            tmp = tmp.next;
            if (size++ >= index) {
                delayedElement = delayedElement.next;
            }
        }
        if (index > size) {
            System.out.println("index out of bounds");
            return null;
        }
        return delayedElement.data;
    }

    public void set(int index, T data) {
        if (index < 0) {
            System.out.println("index out of bounds");
            return;
        }
        Node<T> tmp = head;
        int size = 0;
        while (tmp.next != null) {
            if (size++ == index) {
                break;
            }
            tmp = tmp.next;
        }
        if (index > size) {
            System.out.println("index out of bounds");
            return;
        }
        tmp.data = data;
    }

    public int size() {
        Node<T> tmp = head;
        int size = 0;
        while (tmp != null) {
            tmp = tmp.next;
            size++;
        }
        return size;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        Node<T> nextElement = head;
        while (nextElement != null) {
            sb.append(nextElement.data.toString());
            if (nextElement.next != null) sb.append(", ");
            nextElement = nextElement.next;
        }
        sb.append("}");
        return sb.toString();
    }
}
