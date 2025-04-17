package BinaryTree;

@FunctionalInterface
public interface Referrer<T> {

    int allocate(T element);
}
