package BinaryTree;

import java.util.*;

public class BiTreeIterator<T> implements Iterator<T> {

    private BiNode<T> current;
    private final Deque<BiNode<T>> list;

    BiTreeIterator(BiNode<T> root) {
        this.current = root;
        this.list = new LinkedList<>();
        if (current != null) list.add(current);
    }

    @Override
    public boolean hasNext() {
        return !list.isEmpty();
    }

    @Override
    public T next() {
        BiNode<T> tmp = list.poll();
        current = tmp;
        if (tmp.getLesserNode() != null) list.addLast(tmp.getLesserNode());
        if (tmp.getBiggerNode() != null) list.addLast(tmp.getBiggerNode());
        return tmp.getElement();
    }
}
