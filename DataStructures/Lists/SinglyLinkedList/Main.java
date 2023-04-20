package DataStructures.Lists.SinglyLinkedList;

public class Main {
    public static void main(String[] args) {
        SList<String> s = new SList<String>();

        s.insertFront("orange"); s.insertFront("apple");
        s.insertAfter("cherry", s.head.getNext());
        s.insertFront("pear");

        s.print();
        System.out.println("s의 길이 : " + s.getSize());
        System.out.println("체리는 " + s.search("cherry") + "번째에 있다.");
        System.out.println("키위는 " + s.search("kiwi") + "번째에 있다.");
        s.deleteAfter(s.head);
        s.print();
        System.out.println("s의 길이 : " + s.getSize());
        s.deleteFront();
        s.print();
        System.out.println("s의 길이 : " + s.getSize());
    }
}
