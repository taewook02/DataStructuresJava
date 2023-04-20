package DataStructures.Lists.ArrList;

import java.util.NoSuchElementException;

public class ArrList <E>
{
    private E a[];
    private int size;

    public ArrList() {
        a = (E[]) new Object[1];
        size=0;
    }

    public E peek(int k) { // k번째 항목 반환
        if(size==0) throw new NoSuchElementException(); // underflow
        return a[k];
    }

    public boolean isEmpty() {
        return size==0;
    }

    public void insertLast(E newItem) { // 맨 뒤에 삽입
        if (size == a.length) resize(a.length*2);
        a[size++] = newItem; // 끝에 새 항목 삽입
    }

    public void insert(E newItem, int k) { // k-1 번째 항목 다음에 삽입
        if (size == a.length) resize(a.length*2);
        
        for (int i = size-1; i >= k; i--) a[i+1] = a[i];
        a[k] = newItem;
        size++;
    }

    public void resize(int newSize) {
        Object[] t = new Object[newSize];
        for (int i = 0; i < size; i++)
            t[i] = a[i];
        a = (E[]) t;
    }

    public E delete(int k) {
        if (isEmpty())
            throw new NoSuchElementException();
        E item = a[k];
        for (int i = k; i < size; i++)
            a[i] = a[i+1];
        size--;
        if (size > 0 && size == a.length / 4)
            resize(a.length / 2);
        return item;
    }

    public void print() {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]);
            System.out.print(" ");
        }
        System.out.println();
    }
}
