package week_9.hyewonbae;
/**
 * '(' 문자로 열렸으면, ')' 문자로 닫혀야 한다.
 * return 문자열 s 가 올바른 괄호이면 true, 아니면 false
 * */
import java.io.*;
import java.util.*;
public class PGS_올바른괄호 {
    static boolean solution(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.push(c);
            } else if (c == ')') {
                if (stack.isEmpty()) {
                    return false;
                } else if(stack.peek() == '('){
                    stack.pop();
                }
            }
        }

        // 스택이 비었을 경우 --> 괄호 쌍이 모두 맞아 pop() 됨.
        if (stack.isEmpty()) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) throws Exception{
        // TEST CASE 1
        String s = "()()";
        System.out.println(solution(s));        // true

        // TEST CASE 2
//        String s = "(())()";
//        System.out.println(solution(s));      // true

        // TEST CASE 3
//        String s = ")()(";
//        System.out.println(solution(s));      // false

        // TEST CASE 4
//        String s = "(()(";
//        System.out.println(solution(s));      // false
    }
}
