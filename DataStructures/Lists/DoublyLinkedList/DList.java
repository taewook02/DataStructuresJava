package DataStructures.Lists.DoublyLinkedList;

import java.util.NoSuchElementException;
import DataStructures.Nodes.DNode.DNode;

public class DList <E> {
    protected DNode head, tail;
    protected int size;

    protected DList() {
        head = new DNode (null, null, null);
        tail = new DNode (null, head, null); // tail의 이전 노드를 head로 설정
        head.setNext(tail); // head의 다음 노드를 tail로 설정
        size = 0;
    }

    // 새 노드를 노드 p 앞에 삽입
    public void insertBefore(DNode p, E newItem) {
        DNode t = p.getPrevious();
        DNode newNode = new DNode(newItem, t, p);
        p.setPrevious(newNode);
        t.setNext(newNode);
        size++;
    }

    // 새 노드를 노드 p 뒤에 삽입
    public void insertAfter(DNode p, E newItem) {
        DNode t = p.getNext();
        DNode newNode = new DNode(newItem, p, t);
        p.setPrevious(newNode);
        t.setNext(newNode);
        size++;
    }

    // 노드를 삭제
    public void delete(DNode x) {
        if (x==null) throw new NoSuchElementException();
        DNode f = x.getPrevious();
        DNode r = x.getNext();
        f.setNext(r);
        r.setPrevious(f);
        size--;
    }
}
