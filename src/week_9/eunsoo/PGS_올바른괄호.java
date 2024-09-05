package week_9.eunsoo;

import java.util.ArrayDeque;
/* 올바른 괄호
 * [입력] s: 괄호 문자열
 * [출력] 바르게 짝지어진 문자열인지의 여부 (T/F)
 * [방법] 스택 -> "(" 추가 -> ")" 만나면 "(" 제거 -> 비어있음T / 아님F
 */

public class PGS_올바른괄호 {
    public static boolean solution(String s) {

        int close = 0; //닫힌 괄호 수
        ArrayDeque<Character> stack = new ArrayDeque<>();
        for(int i=0; i<s.length(); i++) stack.add(s.charAt(i));
        while(!stack.isEmpty()) {
            char bracket = stack.pollLast();
            if(bracket == ')') close++;
            else { // == '('
                if(close == 0) return false;
                else close--;
            }
            //System.out.println("닫힌 괄호 수: "+close);
            //System.out.println("스택: "+stack.toString());
        }

        if(close >= 1) return false; // "("로 다 뺐는데 ")" 개수가 남으면 false
        return true;
    }

    public static void main(String[] args) {
        boolean answer = solution("(())()");
        System.out.println(answer);
    }

}
