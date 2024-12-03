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
        if (index < size || index < 0) {
            return elements[index];
        } else {
            System.out.println("index is out of bounds");
            return null;
        }
    }

    public void set(int index, String newElement) {
        if (index < 0 || index > size -1) {
            System.out.println("index out of bounds");
            return;
        }
        elements[index] = newElement;
    }

    public int getSize() {
        return size;
    }

    public boolean contains(String string) {
        for (int i = 0; i < size; i++) {
            if (elements[i].equals(string)) {
                return true;
            }
        }
        return false;
    }

    public void trimToSize() {
        String[] newArray = new String[size];
        for (int i = 0; i < size; i++) {
            newArray[i] = elements[i];
        }
        elements = newArray;
    }

    public void remove(String string) {
        for (int i = 0; i < size; i++) {
            if (elements[i].equals(string)) {
                if (i < size -1) {
                    for (int j = i; j < size -1; j++) {
                        elements[j] = elements[j + 1];
                    }
                    elements[size-1] = null;
                    size--;
                    break;
                } else {
                    elements[i] = null;
                    size--;
                }
            }
        }
    }

    public void remove(int index) {
        if (index < 0 || index > size -1) {
            System.out.println("index out of bounds");
            return;
        }
        if (index < size -1) {
            for (int i = index; i < size -1; i++) {
                elements[i] = elements[i + 1];
            }
            elements[size-1] = null;
            size--;
        } else {
            elements[index] = null;
            size--;
        }
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

    private void size() {
        int growingSize = elements.length + (elements.length / 2) + 1;
        String[] newArray = new String[growingSize];
        for (int i = 0; i < elements.length; i++) {
            newArray[i] = elements[i];
        }
        elements = newArray;
    }
}
