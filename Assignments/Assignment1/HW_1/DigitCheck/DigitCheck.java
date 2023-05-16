// 자료구조(S1029) 과제 #1 (60201670 남태욱)

package HW_1.DigitCheck;

import java.util.Scanner;

public class DigitCheck {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print(" : ");

        int num = sc.nextInt();

        System.out.println(num + "의 자릿수 : " + countDigits(num));

        System.out.println(num + "의 각 자릿수 합 : " + sumDigits(num));

        sc.close();
    }

    public static int countDigits(int n) {
        if (n == 0) { // base case
            return 0;
        }
        else { // recursive case
            return 1 + countDigits(n / 10);
        }
    }

    public static int sumDigits(int n) {
        if (n < 0) { // 음수가 주어진 경우 절댓값
            n = -n;
        }
        
        if (n < 10) { // base case
            return n;
        }
        else { // recursive case
            return (n % 10) + sumDigits(n / 10);
        }
    }
}