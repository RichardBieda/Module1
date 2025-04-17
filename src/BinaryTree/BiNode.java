package BinaryTree;

class BiNode<T> {

    private final T element;
    private BiNode<T> lesserNode;
    private BiNode<T> biggerNode;

    BiNode(T element) {
        this.element = element;
    }

    T getElement() {
        return this.element;
    }

    BiNode<T> getLesserNode() {
        return lesserNode;
    }

    void setLesserNode(BiNode<T> lesserNode) {
        if (this.lesserNode != null) {
            throw new RuntimeException("Nodes cannot be changed");
        }
        this.lesserNode = lesserNode;
    }

    BiNode<T> getBiggerNode() {
        return biggerNode;
    }

    void setBiggerNode(BiNode<T> biggerNode) {
        if (this.biggerNode != null) {
            throw new RuntimeException("Nodes cannot be changed");
        }
        this.biggerNode = biggerNode;
    }
}
