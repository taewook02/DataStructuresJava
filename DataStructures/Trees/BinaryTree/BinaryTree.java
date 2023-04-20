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

    // 미완
}
