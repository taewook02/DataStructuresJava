package DataStructures.Trees.AVLTree;

public class Node<Key extends Comparable<Key>, Value> {
    private Key id;
    private Value name;
    private int height;
    private Node<Key, Value> left, right;

    // 생성자
    public Node(Key newID, Value newName, int newHt) {
        this.id = newID;
        this.name = newName;
        this.height = newHt;
        this.left = this.right = null;
    }

    public Key getKey() { return this.id; }

    public Value getValue() {
        return this.name;
    }

    public int getHeight() {
        return this.height;
    }

    public Node<Key, Value> getLeft() {
        return this.left;
    }

    public Node<Key, Value> getRight() {
        return this.right;
    }

    public void setKey(Key newId) {
        this.id = newId;
    }

    public void setValue(Value newName) {
        this.name = newName;
    }

    public void setHeight(int newHt) {
        this.height = newHt;
    }

    public void setLeft(Node<Key, Value> newLeft) {
        this.left = newLeft;
    }

    public void setRight(Node<Key, Value> newRight) {
        this.right = newRight;
    }
}
