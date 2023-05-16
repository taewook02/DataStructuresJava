// 자료구조(6076) 과제 #4 (60201670 남태욱)

import java.util.Arrays;

public class PostExp {
    public static void main(String[] args) {
        System.out.println("자료구조(6076) 과제#4 (60201670 남태욱)");
        checkPaired("A-B+C/D");
        checkPaired("A/B-C*D");
        checkPaired("A-B*C+D/E-F");
        checkPaired("(A-B)*C-(D/(E+F))");
    }

    public static void checkPaired(String str) {
        Character[] operators = {'+', '-', '*', '/'};
        Character [] brackets = {'(', ')'};

        ListStack <Character> s = new ListStack <Character> ();

        int len = str.length();
        boolean isInBrackets = false;

        for (int i=0; i<len; i++) {
            Character c = str.charAt(i);

            if (Arrays.asList(operators).contains(c)) { // 연산자
                if (s.isEmpty()) { // 스택이 비어있는 경우
                    s.push(c);
                } else {
                    if (!isInBrackets) { // 괄호 밖에 있는 경우
                        while (!s.isEmpty()) {
                            int tmpPrec = (c=='+'||c=='-') ? 1 : 2;
                            int topPrec = (s.peek()=='+'||s.peek()=='-') ? 1 : 2;
                            if (topPrec < tmpPrec) {
                                break;
                            } else {
                                System.out.print(s.pop());
                            }
                        }
                        s.push(c);
                    }
                    else { // 괄호 안에 있는 경우
                        s.push(c);
                    }
                }
            } else if (Arrays.asList(brackets).contains(c)) { // 괄호
                if (c == '(') { // 여는 괄호
                    s.push(c);
                    isInBrackets = true;
                } else if (c == ')') { // 닫는 괄호
                    while (!s.isEmpty()) {
                        if (s.peek()=='(') {
                            s.pop();
                            break;
                        } else {
                            System.out.print(s.pop());
                        }
                    }
                    isInBrackets = false;
                }
            } else { // 피연산자
                System.out.print(c);
            }
        }
        while (!s.isEmpty()) {
            System.out.print(s.pop());
        }
        System.out.println();
    }
}