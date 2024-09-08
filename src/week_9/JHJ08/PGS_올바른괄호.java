package week_9.JHJ08;

import java.util.*;

public class PGS_올바른괄호 {

    static boolean solution(String s) {

        boolean answer = true;

        Stack<String> stack = new Stack<>();

        for(int i=0; i<s.length(); i++)
        {
            if(s.charAt(i) == '(')
            {
                stack.add("(");
            }
            else if(s.charAt(i) == ')')
            {
                if(!stack.isEmpty())
                {
                    stack.pop();
                }
                else
                {
                    return false;
                }
            }
        }

        if(!stack.isEmpty())
        {
            answer = false;
        }

        return answer;
    }

    public static void main(String[] args)
    {
        System.out.println(solution("()()"));
        System.out.println(solution("(())()"));
        System.out.println(solution(")()("));
        System.out.println(solution("(()("));
    }
}
