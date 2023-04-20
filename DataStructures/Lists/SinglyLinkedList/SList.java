package DataStructures.Lists.SinglyLinkedList;

import DataStructures.Nodes.Node;

import java.util.NoSuchElementException;

public class SList <E extends Comparable<E>> {
    protected Node head;
    private int size;

    public SList() {
        head = null; // 연결리스트의 첫 노드
        size = 0; // 노드 수
    }

    public int search(E target) { // 연결리스트의 항목 검색
        Node p = head;

        for (int k=0; k<size; k++) { // 몇번째 노드인지
            if (target == p.getItem()) return k; // 노드 탐색에 성공 시 몇번째 노드인지 반환
            p = p.getNext();
        }

        return -1; // 탐색에 실패
    }

    public void insertFront(E newItem) { // 연결리스트의 맨 앞에 노드 삽입
        head = new Node(newItem, head); // head를 기존 노드를 참조하는 새 노드로 교체
        size++;
    }

    public void insertAfter(E newItem, Node p) { // p 노드 뒤에 새 노드 삽입
        p.setNext(new Node(newItem, p.getNext())); // 기존에 p 노드가 참조하던 노드를 참조하는 새로운 노드를 생성하고, p 노드가 해당 노드를 참조하도록 설정
        size++;
    }

    public void deleteFront() {
        if (isEmpty()) throw new NoSuchElementException(); // SList가 비어있는 경우 에러 발생
        head = head.getNext(); // head 노드를 기존 head가 참조하던 노드로 교체
        size--; // 줄어든 노드 수 기록
    }

    public void deleteAfter(Node p) {
        if (p==null) throw new NoSuchElementException(); // 해당 노드를 찾지 못한 경우 에러 발생
        Node t = p.getNext(); // p가 참조하는 노드를 t에 저장
        p.setNext(t.getNext()); // p가 참조하는 노드를 t가 참조하는 노드로 교체
        t.setNext(null); // t의 참조 노드를 제거 (Slist에서 삭제)
        size--; // 줄어든 노드 수 기록
    }

    public boolean isEmpty() {
        return size==0;
    }

    public void print() {
        Node p = head;
        while (p.getItem() != null) {
            System.out.print(p.getItem());
            System.out.print(" ");
            if (p.getNext() == null) break;
            p = p.getNext();
        }
        System.out.println();
    }

    public int getSize() {
        return size;
    }
}
