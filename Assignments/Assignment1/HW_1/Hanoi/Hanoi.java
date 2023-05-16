// 자료구조(S1029) 과제 #1 (60201670 남태욱)

package 과제.과제1.HW_1.Hanoi;

public class Hanoi {
    public static void main(String[] args) {
        System.out.println("원판이 3개인 경우\n(원판 이름 : 크기가 작은-큰 순서 1-2-3-4)\n\n");
        solveHanoi(3, 'A', 'B', 'C'); // 원판이 3개인 경우

        System.out.println("\n\n원판이 4개인 경우\n(원판 이름 : 크기가 작은-큰 순서 1-2-3)\n\n");
        solveHanoi(4, 'A', 'B', 'C'); // 원판이 4개인 경우
    }

    public static void solveHanoi(int n, char from, char by, char to) {
        if (n == 1) { // base case
            System.out.println("Move Disk " + n + " " + from + " to " + to); // 원판 하나를 그대로 목적지로 옮기기
            return;
        }
        else { // recursive case
            solveHanoi(n-1, from, to, by); // n-1개의 원판을 중간 막대로 옮기기
            System.out.println("Move Disk " + n + " " + from + " to " + to);
            solveHanoi(n-1, by, from ,to); // 중간막대에 있는 n-1개의 원판을 목적지로 옮기기
        }
    }
}
