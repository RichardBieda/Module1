package Lesson18;

public class ArrayQueue<T> {

    private static final int DEFAULT_CAPACITY = 100;
    private int capacity;
    private int front = 0;
    private int rear = 0;
    private final Object[] internalArray;

    public ArrayQueue() {
        this.capacity = DEFAULT_CAPACITY;
        internalArray = new Object[capacity];
    }

    public ArrayQueue(int capacity) {
        this.capacity = capacity;
        internalArray = new Object[this.capacity];
    }

    public boolean add(T element) {
        if (isFull()) {
            System.out.println("Queue is full");
            return false;
        } else if (element == null) {
            System.out.println("NullPointer exception");
            return false;
        }
        internalArray[rear++] = element;
        rear = rear % capacity;
        return true;
    }

    public boolean isFull() {
        if (front == rear && internalArray[front] != null) {
            return true;
        } else {
            return false;
        }
    }

    @SuppressWarnings("unchecked")
    public T peek() {
        return (T) internalArray[front];
    }

    public T poll() {
        T t = peek();
        remove();
       return t;
    }

    public void remove() {
        if (internalArray[front] != null) {
            internalArray[front++] = null;
            front = front % capacity;
        } else {
            System.out.println("Queue is empty");
        }
    }

    public int size() {
        if (front == rear) {
            if (internalArray[front] == null) {
                return 0;
            } else {
                return capacity;
            }
        } else if (front < rear) {
            return rear - front;
        } else {
            return capacity - front + rear;
        }
    }

    public String toString() {
       String sb = "[";
        int pointer = front;
        for (int i = 0; i < capacity; i++) {
            if (internalArray[pointer +i] != null) {
                sb += internalArray[pointer +i] + ", ";
            }
            if (pointer + i == capacity -1) {
                pointer = pointer - capacity;
            }
        }
        sb += "]";
        String result = sb.replaceAll(", ]", "]");

        return result;
    }
}
