package DataStructures.HashTables.QuadProbing;

public class QuadProbing<Key, Value> {
    // 테이블 크기
    private final int MOD = 13;

    // 항목 갯수
    private int N = 0;

    // 해시 테이블
    private Key[] arr = (Key[]) new Object[MOD];
    // key 관련 데이터 저장
    private Value[] dat = (Value[]) new Object[MOD];

    // 해시 함수
    private int hash(Key k) {
        return (k.hashCode() & 0x7fffffff) % MOD;
    }

    // 삽입 연산
    public void put(Key k, Value d) {
        int initPos = hash(k); // 초기 위치
        int i = initPos;
        int j = 1;
        int loopLimit = 20; // 저장 시도 횟수 제한

        do {
            if (arr[i] == null) { // 삽입 위치 발견
                arr[i] = k; // key를 저장
                dat[i] = d; // 데이터를 저장
                N++; // 항목 수 1 증가
                return;
            }
            if (arr[i].equals(k)) { // 해당 key가 이미 존재
                dat[i] = d; // 데이터만 갱신
            }
            i = (initPos + j * j++) % MOD; // i를 다음 위치로
            loopLimit--; // 반복 횟수 갱신
        } while (loopLimit > 0);

        System.out.println("Failed to save data"); // 저장 실패
    }

    // 탐색 연산
    public Value get(Key k) {
        int initPos = hash(k);
        int i = initPos;
        int j = 1;
        int loopLimit = 20; // 탐색 제한 횟수

        while (arr[i] != null && loopLimit > 0) { // arr[i]가 empty가 아닌 경우
            if (arr[i].equals(k)) { // 탐색 성공
                return dat[i];
            }
            i = (initPos + j * j++) % MOD; // i를 다음 위치로
        }
        return null; // 탐색 실패
    }
}
