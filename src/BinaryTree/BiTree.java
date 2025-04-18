package BinaryTree;

import java.util.Iterator;
import java.util.Objects;

public final class BiTree<T> {

    private BiNode<T> root;
    private final Referrer<T> allocator;
    private int size;

    public BiTree() {
        this(new DefaultReferrer<>());
    }

    public BiTree(Referrer<T> allocator) {
        this.allocator = allocator;
    }

    public T getRoot() {
        return root.getElement();
    }

    public void add(T element) {
        if (root == null) {
            root = new BiNode<>(element);
            size++;
            return;
        }
        int newNodeValue = allocator.allocate(element);
        addRecursive(root, element , newNodeValue);
    }

    private void addRecursive(BiNode<T> node, T element, int newNodeValue) {
        int nodeValue = allocator.allocate(node.getElement());
        if (newNodeValue < nodeValue) {
            if (node.getLesserNode() == null) {
                node.setLesserNode(new BiNode<>(element));
                size++;
            } else {
                addRecursive(node.getLesserNode(), element, newNodeValue);
            }
            return;
        }

        if (newNodeValue > nodeValue) {
            if (node.getBiggerNode() == null) {
                node.setBiggerNode(new BiNode<>(element));
                size++;
            } else {
                addRecursive(node.getBiggerNode(), element, newNodeValue);
            }
        }
    }

    @SafeVarargs
    public final void addAll(T... elements) {
        for (T t : elements) {
            add(t);
        }
    }

    public int getValue(T element) {
        return allocator.allocate(element);
    }

    public T getElement(int value) {
        return getElementsRecursive(root, value);
    }

    private T getElementsRecursive(BiNode<T> node, int value) {
        int nodeValue = allocator.allocate(node.getElement());
        if (nodeValue == value) {
            return node.getElement();
        }
        if (value < nodeValue && node.getLesserNode() != null) {
            return getElementsRecursive(node.getLesserNode(), value);
        } else if (value > nodeValue && node.getBiggerNode() != null) {
            return getElementsRecursive(node.getBiggerNode(), value);
        }
        return null;
    }

    public Iterator<T> getIterator() {
        Iterator<T> it = new BiTreeIterator<>(root);
        return it;
    }

    private static class DefaultReferrer<T> implements Referrer<T> {
        @Override
        public int allocate(T element) {
            return Objects.hash(element);
        }
    }
}
