package DataStructures.Trees.BinarySearchTree;

public class BST<Key extends Comparable<Key>, Value> {
    public Node<Key, Value> root;

    // 생성자
    public BST(Key newId, Value newName) {
        this.root = new Node<>(newId, newName);
    }

    // 루트 값 반환
    public Node<Key, Value> getRoot() {
        return this.root;
    }

    // 탐색 연산
    public Value get(Key k) {
        return get(this.root, k); // 루트부터 탐색 시작
    }

    private Value get(Node<Key, Value> n, Key k) {
        if (n == null) { // 탐색 실패
            return null;
        }
        int t = n.getKey().compareTo(k);

        if (t > 0) { // n > k
            return get(n.getLeft(), k); // 왼쪽 값으로 다시 탐색
        } else if (t < 0) { // n < k
            return get(n.getRight(), k); // 오른쪽 값으로 다시 탐색
        } else { // n == k
            return n.getValue();
        }
    }

    // 삽입 연산
    public void put(Key k, Value v) {
        this.root = put(this.root, k, v); // 루트부터 삽입 시작
    }

    private Node<Key, Value> put(Node<Key, Value> n, Key k, Value v) {
        if (n == null) { // 맨 아래에 삽입되는 경우
            return new Node<>(k, v);
        }

        int t = n.getKey().compareTo(k);
        if (t > 0) { // n > k
            n.setLeft(put(n.getLeft(), k, v)); // 왼쪽 서브트리에 삽입하고 내려감
        } else if (t < 0) { // n < k
            n.setRight(put(n.getRight(), k, v)); // 오른쪽 서브트리에 삽입하고 내려감
        } else { // n == k
            n.setValue(v); // 노드의 name을 v로 변경
        }

        return n;
    }

    // 최솟값 찾기 연산
    public Key min() {
        if (root == null) { // 빈 트리인 경우
            return null;
        }
        return min(root).getKey(); // 최소값의 key를 반환
    }

    private Node<Key, Value> min(Node<Key, Value> n) {
        if (n.getLeft() == null) { // 최솟값을 발견
            return n;
        }
        return min(n.getLeft()); // 재귀함수로 왼쪽으로 내려감
    }

    // 최솟값 삭제 연산
    public void deleteMin() {
        if (this.root == null) { // 빈 트리인 경우
            System.out.println("Tree is already empty");
        }
        this.root = deleteMin(this.root);
    }

    private Node<Key, Value> deleteMin(Node<Key, Value> n) {
        if (n.getLeft() == null) {
            return n.getRight();
        }
        n.setLeft(deleteMin(n.getLeft()));
        return n;
    }

    // 삭제 연산
    public void delete(Key k) {
        this.root = delete(this.root, k);
    }

    private Node<Key, Value> delete(Node<Key, Value> n, Key k) {
        if (n == null) {
            return null;
        }

        int t = n.getKey().compareTo(k);
        if (t > 0) { // n > k
            n.setLeft(delete(n.getLeft(), k)); // 왼쪽으로 내려감
        } else if (t < 0) {
            n.setRight(delete(n.getRight(), k)); // 오른쪽으로 내려감
        } else { // n == k 발견
            if (n.getRight() == null) { // 오른쪽 자식이 null
                return n.getLeft();
            }
            if (n.getLeft() == null) { // 왼쪽 자식이 null
                return n.getRight();
            }
            Node<Key, Value> target = n;
            n = min(target.getRight()); // 삭제할 노드 자리로 올 노드(하위 노드 중 삭제할 노드 다음으로 작은 노드)를 찾기
            n.setRight(deleteMin(target.getRight())); // target이 제거된 오른쪽 하위 트리를 연결
            n.setLeft(target.getLeft()); // 왼쪽 하위 트리를 연결
        }
        return n;
    }
}
