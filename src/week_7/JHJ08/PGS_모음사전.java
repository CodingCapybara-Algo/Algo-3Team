package week_7.JHJ08;

import java.util.*;
public class PGS_모음사전 {


    static String [] data = { "A", "E", "I", "O", "U"};
    static ArrayList<String> list = new ArrayList<>();

    static void makeWord(String text, int depth){

        list.add(text);

        if(depth == 5){
            return;
        }

        for(int i = 0 ; i < 5; ++i)
        {
            makeWord(text + data[i], depth + 1);
        }
    }

    static int solution(String word) {

        int answer = 0;

        // 사전 만들기
        for(int i = 0 ; i < 5; ++i)
        {
            makeWord(data[i], 1);
        }

        int count = 0;
        for(String s : list){
            count++;
            if(s.equals(word))
            {
                return count;
            }
        }
        return answer;
    }

    public static void main(String[] args) {

        System.out.println(solution("AAAAE"));
        System.out.println(solution("AAAE"));
        System.out.println(solution("I"));
        System.out.println(solution("EIO"));

    }
}
