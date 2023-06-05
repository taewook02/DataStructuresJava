package DataStructures.Lists.CircularLinkedList;

import java.util.NoSuchElementException;
import DataStructures.Nodes.Node.Node;

public class CList<E> {
    private Node<E> last; // 리스트의 마지막 노드
    private int size; // 리스트의 노드 수

    // 생성자
    public CList() {
        last = null;
        size = 0;
    }

    public boolean isEmpty() {
        return size==0;
    }

    public int size() {
        return size;
    }

    // last가 가리키는 노드의 다음에 새 노드 삽입
    public void insert(E newItem) {
        Node<E> newNode = new Node<E>(newItem, null);

        if (last == null) {
            newNode.setNext(newNode);
            last = newNode;
        } else {
            newNode.setNext(last.getNext());
            last.setNext(newNode);
        }
        size++;
    }

    // 첫 노드를 삭제
    public void delete() {
        if (isEmpty()) throw new NoSuchElementException();

        Node<E> x = last.getNext();
        if (x==last) {
            last = null; // 리스트에 노드가 1개인 경우
        } else {
            last.setNext(x.getNext());
        }
        size--;
    }
}
