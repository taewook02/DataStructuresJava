package DataStructures.Stacks.ArrayStack;

import java.util.EmptyStackException;

// array로 구현한 stack
public class ArrayStack <E> {
    private E[] s; // stack을 저장할 배열
    private int top; // stack의 top 항목의 인덱스

    public ArrayStack() {
        s = (E[]) new Object[1];
        top = -1;
    }

    // stack의 top에 있는 item을 리턴
    public E peek() {
        //underflow시 에러 발생
        if (isEmpty()) throw new EmptyStackException();

        return s[top];
    }

    // newItem을 stack의 top에 삽입
    public void push(E newItem) {
        // overflow가 발생할경우 배열 크기를 2배로 확장
        if (size() == s.length) resize(2*s.length);

        // 새 항목을 push
        s[++top] = newItem;
    }

    // stack의 top에 있는 item을 제거하고 제거된 item을 반환
    public E pop() {
        // underflow시 에러 발생
        if (isEmpty()) throw new EmptyStackException();

        // top의 항목을 pop & null로 초기화
        E item = s[top];
        s[top--] = null;

        // stack이 배열 항목의 1/4만 차지하는 경우 배열의 크기를 1/2로 축소
        if (size()>0 && size()==s.length/4) resize(s.length/2);

        // 제거한 항목 반환
        return item;
    }

    public boolean isEmpty() {
        return s.length==0;
    }

    public int size() {
        return s.length;
    }

    public void resize(int newSize) {
        Object[] t = new Object[newSize];
        if (size() >= 0) System.arraycopy(s, 0, t, 0, size());
        s = (E[]) t;
    }

    public void print() {
        for (int i=0; i<size(); i++) 
            if (s[i]!=null) System.out.print(s[i]+" ");
        System.out.println();
    }
}
