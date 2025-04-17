package BinaryTree;

import java.util.Objects;

public final class BiTree<T> {

    private BiNode<T> root;
    private final Referrer<T> allocator;

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
            } else {
                addRecursive(node.getLesserNode(), element, newNodeValue);
            }
            return;
        }

        if (newNodeValue > nodeValue) {
            if (node.getBiggerNode() == null) {
                node.setBiggerNode(new BiNode<>(element));
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

    public T get(T element) {
        return null;
    }

    private static class DefaultReferrer<T> implements Referrer<T> {
        @Override
        public int allocate(T element) {
            return Objects.hash(element);
        }
    }
}
