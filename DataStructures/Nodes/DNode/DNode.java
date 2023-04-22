package DataStructures.Nodes.DNode;

public class DNode <E> {
    private E item;
    private DNode previous;
    private DNode next;

    // 생성자
    public DNode(E newItem, DNode p, DNode q) { // 노드 값, 이전 노드, 다음 노드
        item = newItem;
        previous = p;
        next = q;
    }

    public E getItem() { return item; }
    public DNode getPrevious() { return previous; }
    public DNode getNext() { return next; }

    public void setItem(E newItem) { item = newItem; }
    public void setPrevious(DNode p) { previous = p; }
    public void setNext(DNode q) { next = q; }
}
