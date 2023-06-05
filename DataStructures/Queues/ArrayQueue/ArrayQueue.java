package DataStructures.Queues.ArrayQueue;

import java.util.NoSuchElementException;

public class ArrayQueue <E> {
    private E[] q; // 큐를 저장할 배열
    private int front, rear, size;

    // 생성자
    public ArrayQueue() {
        q = (E[]) new Object[2]; // 크기가 2인 배열 생성
        front = rear = size = 0;
    }

    // 큐에 저장된 항목의 수 리턴
    public int size() { return size; }

    // 큐가 비어있으면 true를 반환
    public boolean isEmpty() { return (size==0); }

    // rear 다음에 항목 삽입
    public void add(E newItem) {
        // overflow가 발생하면 (비어있는 원소가 1개인 경우) 큐의 크기를 2배로 확장
        if ((rear + 1) % q.length == front)
            resize(q.length * 2);

        rear = (rear + 1) % q.length;
        q[rear] = newItem; // 새 항목 삽입

        size++;
    }

    // front 항목 삭제
    public E remove() {
        // underflow 오류 발생
        if (isEmpty())
            throw new NoSuchElementException();

        front = (front + 1) % q.length;
        E item = q[front];

        q[front] = null;
        size--;

        if (size > 0 && size == q.length/4)
            resize(q.length / 2);
        
        return item;
    }

    // 큐의 크기 조절
    private void resize(int newSize) {
        // newSize 크기의 새로운 배열 t 생성
        Object[] t = new Object[newSize];

        // 큐의 항목들을 t 배열에 복사
        for (int i=1, j=front+1; i<size+1; i++, j++)
            t[i] = q[j%q.length];
        
        front = 0;
        rear = size;

        // q에 배열 t값 대입
        q = (E[]) t;
    }

    public void print() {
        System.out.print("항목수: " + size + "/ ");
        for (E e : q) {
            System.out.print(e + " ");
        }
        System.out.print("\n");
    }
}
