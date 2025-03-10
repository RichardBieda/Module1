package Module1_Final_Project;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

final class BFNode {

    private final char sign;
    private boolean isWord;
    private int count;
    private Map<Character,BFNode> children;

    BFNode(char newSign) {
        sign = newSign;
    }

    char getSign() {
        return sign;
    }

    void setCount(int count) {
        this.count = count;
    }

    Map<Character, BFNode> getChildren() {
        return children;
    }

    void setChildrenIfAbsent() {
        if (this.children == null) {
            this.children = new HashMap<>();
        }
    }

    void setIsWord(boolean isWord) {
        this.isWord = isWord;
    }

    @Override
    public int hashCode() {
        return Objects.hash(sign);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BFNode)) return false;
        BFNode other = (BFNode) o;
        return this.sign == other.sign;
    }
}
