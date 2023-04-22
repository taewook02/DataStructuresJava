package DataStructures.Queues.ListQueue;

import java.util.NoSuchElementException;
import DataStructures.Nodes.Node.Node;

public class ListQueue <E> {
    private Node <E> front, rear;
    private int size; // 큐의 항목 수

    public ListQueue() {
        front = rear = null;
        size = 0;
    }

    public int size() { return size; }
    public boolean isEmpty() { return size == 0; }

    // 큐의 rear에 항목 추가
    public void add(E newItem) {
        Node newNode = new Node(newItem, null);

        if (isEmpty())
            front = newNode;
        else
            rear.setNext(newNode);

        rear = newNode;
        size++;
    }

    // 큐의 front 항목 제거 후 리턴
    public E remove() {
        // underflow시 에러 발생
        if (isEmpty())
            throw new NoSuchElementException();

        E frontItem = front.getItem();
        front = front.getNext();

        size--;

        if(isEmpty()) rear = null;

        return frontItem;
    }

    public void print() {
        Node p = front;
        while (p.getItem() != null) {
            System.out.print(p.getItem());
            System.out.print(" ");
            if (p.getNext() == null) break;
            p = p.getNext();
        }
        System.out.print("\n");
    }
}
