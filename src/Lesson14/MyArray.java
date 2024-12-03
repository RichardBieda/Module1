package Lesson14;

public class MyArray {

    private final int startLength = 10;
    private String[] elements = new String[startLength];
    private int size;

    public MyArray() {
    }

    public MyArray(String...elements) {
        for (String s : elements) {
            add(s);
        }
    }

    public void add(String element) {
        if (size < elements.length) {
            elements[size++] = element;
        } else {
            size();
            elements[size++] = element;
        }
    }

    public String get(int index) {
        if (index < size) {
            return elements[index];
        } else {
            System.out.println("index is out of bounds");
        }
        return null;
    }

    public void size() {
        int growingSize = elements.length + (elements.length / 2) + 1;
        String[] newArray = new String[growingSize];
        for (int i = 0; i < elements.length; i++) {
            newArray[i] = elements[i];
        }
        elements = newArray;
    }

    public int getSize() {
        return size;
    }

    public void trimToSize() {
        String[] newArray = new String[size];
        for (int i = 0; i < size; i++) {
            newArray[i] = elements[i];
        }
        elements = newArray;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("[");
        for (int i = 0; i < size; i++) {
            if (i < size-1) {
                result.append(elements[i] + ",");
            } else {
                result.append(elements[i]);
            }
        }
        result.append("]");
        return result.toString();
    }
}
