package DataStructures.Trees.AVLTree;

public class AVLTree<Key extends Comparable<Key>, Value> {
    public Node<Key, Value> root;

    // 생성자
    public AVLTree(Key newId, Value newName, int newHt) {
        this.root = new Node<>(newId, newName, newHt);
    }

    // 루트 값 반환
    public Node<Key, Value> getRoot() {
        return this.root;
    }

    // 회전 연산

    // 오른쪽 회전
    private Node<Key, Value> rotateRight(Node<Key, Value> n) {
        Node<Key, Value> x = n.getLeft(); // n의 왼쪽 자식을 x로 설정
        n.setLeft(x.getRight()); // x의 오른쪽 자식을 n의 왼쪽 자식으로 설정
        x.setRight(n); // n을 x의 오른쪽 자식으로 설정
        n.setHeight(Math.max(n.getLeft().getHeight(), n.getRight().getHeight()) + 1); // 높이 갱신
        x.setHeight(Math.max(x.getLeft().getHeight(), x.getRight().getHeight()) + 1); // 높이 갱신
        return x;
    }

    // 왼쪽 회전
    private Node<Key, Value> rotateLeft(Node<Key, Value> n) {
        Node<Key, Value> x = n.getRight(); // n의 오른쪽 자식을 x로 설정
        n.setRight(x.getLeft()); // x의 왼쪽 자식을 n의 오른쪽 자식으로 설정
        x.setLeft(n); // n을 x의 왼쪽 자식으로 설정
        n.setHeight(Math.max(n.getLeft().getHeight(), n.getRight().getHeight()) + 1); // 높이 갱신
        x.setHeight(Math.max(x.getLeft().getHeight(), x.getRight().getHeight()) + 1); // 높이 갱신
        return x;
    }

    // 삽입 연산
    public void put(Key k, Value v) {
        this.root = put(this.root, k, v);
    }

    public Node<Key, Value> put(Node<Key, Value> n, Key k, Value v) {
        if (n == null) { // 맨 아래에 도착한 경우 높이 1인 노드 생성후 반환
            return new Node<>(k, v, 1);
        }

        int t = k.compareTo(n.getKey());
        if (t < 0) { // k < n
            n.setLeft(put(n.getLeft(), k, v)); // 왼쪽 서브트리로 내려감
        } else if (t > 0) { // k > n
            n.setRight(put(n.getRight(), k, v)); // 오른쪽 서브트리로 내려감
        } else { // k == n 이미 트리에 있음
            n.setValue(v); // Value만 갱신
            return n;
        }
        n.setHeight(Math.max(n.getLeft().getHeight(), n.getRight().getHeight()) + 1); // 높이 갱신
        return balance(n); // 노드 n의 균형을 점검하고 바로 잡기
    }

    // 불균형 처리 연산
    private Node<Key, Value> balance(Node<Key, Value> n) {
        if (bf(n) > 1) { // 왼쪽 서브트리가 더 높은 불균형
            if (bf(n.getLeft()) < 0) { // 왼쪽 자식의 오른쪽 서브트리가 더 높은 경우
                n.setLeft(rotateLeft(n.getLeft()));
            }
            n = rotateRight(n);
        } else if (bf(n) < -1) { // 오른쪽 서브트리가 더 높은 불균형
            if (bf(n.getRight()) > 0) { // 오른쪽 자식의 왼쪽 서브트리가 더 높은 경우
                n.setRight(rotateRight(n.getRight()));
            }
            n = rotateLeft(n);
        }
        return n;
    }

    // 왼쪽 서브트리와 오른쪽 서브트리의 높이 차 계산
    private int bf(Node<Key, Value> n) {
        return n.getLeft().getHeight() - n.getRight().getHeight();
    }

    // 삭제 연산
    public void delete() {
    }
}
