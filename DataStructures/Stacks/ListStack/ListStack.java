package DataStructures.Stacks.ListStack;

import DataStructures.Nodes.Node;

import java.util.EmptyStackException;

// 단순연결리스트(node)로 구현한 stack
public class ListStack <E> {
    private Node <E> top; // stack의 top 항목을 가진 Node
    private int size; // stack의 항목 개수

    public ListStack() {
        top = null;
        size = 0;
    }

    public E peek() {
        //underflow시 에러 발생
        if (isEmpty()) throw new EmptyStackException();

        return top.getItem();
    }

    public void push(E newItem) {
        Node newNode = new Node(newItem, top);

        top = newNode;
        size++;
    }

    public E pop() {
        // underflow시 에러 발생
        if (isEmpty()) throw new EmptyStackException();

        E topItem = top.getItem();
        top = top.getNext();
        size--;

        return topItem;
    }

    public int size() { return size; }
    public boolean isEmpty() { return size==0; }

    public void print() {
        Node n = top;
        for (int i=0; i<size(); i++) {
            System.out.print(n.getItem()+" ");
            if (n.getNext()!=null) n = n.getNext();
        }
        System.out.println();
    }
}
