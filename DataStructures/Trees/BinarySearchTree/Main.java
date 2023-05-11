package DataStructures.Trees.BinarySearchTree;

public class Main {

    public static void main(String[] args) {

        System.out.println();
        BST<Integer, String> bst = new BST<>(50, "Apple");

        bst.put(60, "Banana");
        bst.put(20, "Melon");
        bst.put(10, "Orange");
        bst.put(40, "Tangerine");
        bst.put(25, "Kiwi");
        bst.put(15, "Grape");
        bst.put(80, "Strawberry");
        bst.put(70, "Cherry");
        bst.put(35, "Lemon");

        System.out.println("키와 값 10개 삽입 후 >>");
        bst.print(bst.getRoot());

        System.out.println("높이 = " + bst.height());
        System.out.println();

        System.out.println("키(40)의 값 = " + bst.get(40));
        System.out.println("키(80)의 값 = " + bst.get(80));
        System.out.println("키(77)의 값 = " + bst.get(77));

        System.out.println("최소 키값 = " + bst.min());
        System.out.println("최대 키값 = " + bst.max());
        System.out.println();

        System.out.println("2. 최소 키 삭제 후 >>");
        bst.deleteMin();
        bst.print(bst.getRoot());
        System.out.println();

        System.out.println("3. 15, 35 삭제 후 >>");
        bst.delete(15);
        bst.delete(35);
        bst.print(bst.getRoot());
        System.out.println();

        System.out.println("4. 최대 키 삭제 후 >>");
        bst.deleteMax();
        bst.print(bst.getRoot());
    }
}