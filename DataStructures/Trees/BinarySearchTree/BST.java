package DataStructures.Trees.BinarySearchTree;

class BST <Key extends Comparable<Key>, Value> {
    public Node<Key, Value> root;
    public Node<Key, Value> getRoot() { return root; }

    // 생성자
    public BST(Key newId, Value newName) {
        root = new Node<Key, Value>(newId, newName);
    }

    // 탐색 연산 메소드
    public Value get(Key k) { return get(root, k); }
    public Value get(Node<Key, Value> n, Key k) {
        // 탐색에 실패한 경우 null 반환
        if (n == null) return null;

        // compareTo 메소드로 k와 id값 비교
        int t = n.getKey().compareTo(k);

        // id > k인 경우 왼쪽 서브트리 탐색
        if (t > 0) return get(n.getLeft(), k);
        // id < k인 경우 오른쪽 서브트리 탐색
        else if (t < 0) return get(n.getLeft(), k);
        // id == k인 경우 해당 노드의 value 반환 (탐색 성공)
        else return (Value) n.getValue();
    }

    // 삽입 연산 메소드
    public void put(Key k, Value v) { root = put(root, k, v); }
    public Node<Key, Value> put(Node<Key, Value> n, Key k, Value v) {
        // null
        if (n == null) return new Node<Key, Value>(k, v);

        // compareTo 메소드로 k와 id값 비교
        int t = n.getKey().compareTo(k);

        // id > k인 경우 왼쪽 서브트리 탐색
        if (t > 0) n.setLeft(put(n.getLeft(), k, v));
        // id < k인 경우 오른쪽 서브트리 탐색
        else if (t < 0) n.setRight(put(n.getRight(), k, v));
        // id == k인 경우
        else n.setValue(v);
        return n;
    }

    public void print(Node<Key, Value> root) {
    }

    public void deleteMin() {
    }

    public void delete(Key i) {
    }

    public void deleteMax() {
    }

    public Value max() {
        return null;
    }

    public Value min() {
        return null;
    }

    public Value height() {
        return null;
    }
}
