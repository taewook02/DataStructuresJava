package DataStructures.Lists.DoublyLinkedList;

import java.util.NoSuchElementException;
import DataStructures.Nodes.DNode.DNode;

public class DList<E> {
    protected DNode<E> head, tail;
    protected int size;

    protected DList() {
        head = new DNode<E> (null, null, null);
        tail = new DNode<E> (null, head, null); // tail의 이전 노드를 head로 설정
        head.setNext(tail); // head의 다음 노드를 tail로 설정
        size = 0;
    }

    // 새 노드를 노드 p 앞에 삽입
    public void insertBefore(DNode<E> p, E newItem) {
        DNode<E> t = p.getPrevious();
        DNode<E> newNode = new DNode<E>(newItem, t, p);
        p.setPrevious(newNode);
        t.setNext(newNode);
        size++;
    }

    // 새 노드를 노드 p 뒤에 삽입
    public void insertAfter(DNode<E> p, E newItem) {
        DNode<E> t = p.getNext();
        DNode<E> newNode = new DNode<E>(newItem, p, t);
        t.setPrevious(newNode);
        p.setNext(newNode);
        size++;
    }

    // 노드를 삭제
    public void delete(DNode<E> x) {
        if (x==null) throw new NoSuchElementException();
        DNode<E> f = x.getPrevious();
        DNode<E> r = x.getNext();
        f.setNext(r);
        r.setPrevious(f);
        size--;
    }

    public void print() {
        DNode<E> p = head.getNext();
        while (p != null) {
            System.out.print(p.getItem());
            System.out.print(" ");
            p = p.getNext();
        }
        System.out.println();
    }
}
