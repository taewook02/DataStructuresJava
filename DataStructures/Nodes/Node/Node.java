package DataStructures.Nodes.Node;

public class Node <E> {
    private E item;
    private Node<E> next;

    public Node(E newItem, Node<E> p) {
        item = newItem; // 항목을 노드에 저장
        next = p; // 다음 노드 레퍼런스
    }

    public E getItem() { return item; } // 노드에 저장된 항목 반환
    public Node<E> getNext() { return next; } // 다음 노드 레퍼런스 반환
    public void setItem(E newItem) { item = newItem; } // 새 항목을 노드에 저장
    public void setNext(Node<E> n) { next = n; } // 다음 노드 레퍼런스 저장
}
