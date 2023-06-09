package DataStructures.HashTables.Chaining;

public class Node {
    private Object key;
    private Object data;
    private Node next;

    // 생성자
    public Node(Object newKey, Object newData, Node ref) {
        this.key = newKey;
        this.data = newData;
        this.next = ref;
    }

    public Object getKey() {
        return this.key;
    }

    public Object getData() {
        return this.data;
    }

    public Node getNext() {
        return this.next;
    }

    public void setKey(Object newKey) {
        this.key = newKey;
    }

    public void setData(Object newData) {
        this.data = newData;
    }

    public void setNext(Node newRef) {
        this.next = newRef;
    }
}
