package DataStructures.Lists.ArrList;

public class Main
{
    public static void main(String[] args)
    {
        ArrList<String> s = new ArrList<String> ();

        s.insertLast("apple"); s.print();
        s.insertLast("orange"); s.print();
        s.insertLast("cherry"); s.print();
        s.insertLast("pear"); s.print();
        s.insert("grape", 1); s.print();
        s.insert("lemon", 4); s.print();
        s.insertLast("kiwi"); s.print();

        s.delete(4); s.print();
        s.delete(0); s.print();
        s.delete(0); s.print();
        s.delete(3); s.print();
        s.delete(0); s.print();

        System.out.println("1번째 항목은 " + s.peek(1) + "이다.\n");
    }
}
