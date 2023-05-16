package 과제.과제2.HW_2_SLIST;
// 자료구조(6076) 과제 #2 (60201670 남태욱)
//package HW_2_SList;

public class Node <E extends Comparable<E>> {
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

    public void insertAfter(E target, Node p) {
    }
}
