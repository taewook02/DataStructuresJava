package DataStructures.HashTables.Chaining;

public class Chaining<Key, Value> {
    // 테이블 크기
    private int MOD = 13;
    // 해시테이블
    private Node[] arr = new Node[MOD];

    // 해시 함수
    private int hash(Key k) {
        return (k.hashCode() & 0x7fffffff) % MOD;
    }

    // 탐색 연산
    public Value get(Key k) {
        int i = hash(k);
        for (Node x = arr[i]; x != null; x = x.getNext()) { // 연결 리스트 탐색
            if (k.equals(x.getKey())) { // 탐색 성공
                return (Value) x.getData();
            }
        }
        return null; // 탐색 실패
    }

    // 삽입 연산
    public void put(Key k, Value d) {
        int i = hash(k);
        for (Node x = arr[i]; x != null; x = x.getNext()) { // 연결 리스트 탐색
            if (k.equals(x.getKey())) { // key가 이미 존재
                x.setData(d); // 데이터만 갱신
                return;
            }
        }
        arr[i] = new Node(k, d, arr[i]); // 연결 리스트의 첫 노드로 삽입
    }
}
