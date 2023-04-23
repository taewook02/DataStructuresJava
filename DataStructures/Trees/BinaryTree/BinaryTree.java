package DataStructures.Trees.BinaryTree;

import java.util.*;
import DataStructures.Trees.Node.Node;

public class BinaryTree<Key extends Comparable<Key>> {
    private Node root;

    // 생성자
    public BinaryTree() { root = null; }

    // root 노드 반환 
    public Node getRoot() { return root; }

    // root 노드 값 저장
    public void setRoot(Node newRoot) { root = newRoot; }

    // root가 null인지 확인하여 빈 트리인지 확인
    public boolean isEmpty() { return root == null; }

    // 전위 순회
    public void preorder(Node n) {
        if (n !=null) {
            System.out.print(n.getKey()+" ");
            preorder(n.getLeft());
            preorder(n.getRight());
        }
    }

    // 중위 순회
    public void inorder(Node n) {
        if (n != null) {
            inorder(n.getLeft());
            System.out.print(n.getKey()+" ");
            inorder(n.getRight());
        }
    }

    // 후위 순회
    public void postorder(Node n) {
        if (n != null) {
            postorder(n.getLeft());
            postorder(n.getRight());
            System.out.print(n.getKey()+" ");
        }
    }

    // 레벨 순회
    public void levelorder(Node root) {
        Queue <Node> q = new LinkedList <Node> ();
        Node t;
        q.add(root);
        while (!q.isEmpty()) {
            t = q.remove();
            System.out.print(t.getKey()+" ");
            if (t.getLeft() != null)
                q.add(t.getLeft());
            if (t.getRight() != null)
                q.add(t.getRight());
        }
    }

    // n을 루트로하는 (서브)트리에 있는 노드 수
    public int size(Node n) {
        if (n == null)
            return 0;
        else
            return (1 + size(n.getLeft()) + size(n.getRight()));
    }

    // n을 루트로 하는 서브 트리의 높이
    public int height(Node n) {
        if (n == null) {
            return 0;
        } else {
            return (1 + Math.max(height(n.getLeft()), height(n.getRight())));
        }
    }

    // 두 개의 트리의 동일성 검사
    public static boolean isEqual(Node n, Node m) {
        if (n == null || m == null)
            return n == m;
        if (n.getKey().compareTo(m.getKey()) != 0)
            return false;
        
        return (isEqual(n.getLeft(), m.getLeft()) && isEqual(n.getRight(), m.getRight()));
    }
}
