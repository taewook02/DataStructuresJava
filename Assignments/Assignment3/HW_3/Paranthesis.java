// 자료구조(6076) 과제 #3 (60201670 남태욱)

public class Paranthesis {
    public static void main(String[] args) {

        System.out.println("<< 자료구조(6076) 과제 #3 (60201670 남태욱) >>");

        String str = new String("{{(){()}}}");
        System.out.println(str);
        checkPaired(str);

        str = new String("{{(){()})()}");
        System.out.println("\n" + str);
        checkPaired(str);

        str = new String("({{}}()){({{}})()})");
        System.out.println("\n" + str);
        checkPaired(str);
    }

    public static void checkPaired(String str) {
        int len = str.length();
        ListStack <Character> s = new ListStack <Character> ();
        String res = new String("");

        for (int i=0; i<len; i++) {
            Character c = str.charAt(i);
            Character top = ' ';

            if (!s.isEmpty()) {
                top = s.peek();
            }

            if (c=='(') {
                s.push(c);
                res += c;
            }else if (c=='{') {
                s.push(c);
                res += c;
            } else if (c==')') {
                if (top=='(') { // 괄호 쌍이 맞는 경우
                    s.pop();
                    res += c;
                } else { // 괄호 쌍이 맞지 않거나 s가 빈 스택
                    break;
                }
            } else if (c=='}') {
                if (top=='{') { // 괄호 쌍이 맞는 경우
                    s.pop();
                    res += c;
                } else { // 괄호 쌍이 맞지 않거나 s가 빈 스택
                    break;
                }
            } else { // 다른 문자인 경우
                continue;
            }
        }

        if (str.equals(res)) {
            System.out.println("괄호 쌍이 맞습니다.");
        } else {
            System.out.println(res + "^^^부터 괄호 쌍이 맞지  않습니다.");
        }
    }
}
