package DataStructures.Trees.BinarySearchTree;

public class Node<Key extends Comparable<Key>, Value> {
    private Key id;
    private Value name;
    private Node<Key, Value> left, right;

    public Node(Key newId, Value newName) {
        this.id = newId;
        this.name = newName;
        this.left = this.right = null;
    }

    public Key getKey() {
        return this.id;
    }

    public Value getValue() {
        return this.name;
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

    public void setLeft(Node<Key, Value> newLeft) {
        this.left = newLeft;
    }

    public void setRight(Node<Key, Value> newRight) {
        this.right = newRight;
    }
}
