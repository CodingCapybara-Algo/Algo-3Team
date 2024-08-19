package week_6.eunsoo;

import java.io.*;
import java.util.*;

/* 모의고사
 * 1번 : 1,2,3,4,5 x5
 * 2번 : 2,1,2,3,2,4,2,5 x5
 * 3번 : 3,3,1,1,2,2,4,4,5,5 x10
 * [입력] answers : 정답 1차원 배열
 * [출력] 가장 많이 맞춘 학생 번호
 * [분석] 나머지(%) 사용해 계산 -> a: i%5, b: i%8, c: i%10
 */

public class PGS_모의고사 {
    public static int[] solution(int[] answers) {
        int[] a = {5,1,2,3,4}; //1,2,3,4,5 -> % 위해서 5를 맨앞에
        int[] b = {5,2,1,2,3,2,4,2}; //2,1,2,3,2,4,2,5
        int[] c = {5,3,3,1,1,2,2,4,4,5}; //3,3,1,1,2,2,4,4,5,5
        int a_cnt=0, b_cnt=0, c_cnt=0;

        for(int i=1; i<=answers.length; i++) {
            if(answers[i-1] == a[i%5]) { a_cnt++; }
            if(answers[i-1] == b[i%8]) { b_cnt++; }
            if(answers[i-1] == c[i%10]) { c_cnt++; }
        }

        List<Integer> l = new ArrayList<>();
        if(a_cnt==b_cnt && b_cnt==c_cnt) { //3개 다 max
            l.add(1); l.add(2); l.add(3);
        }
        else { //2개만 max
            if(a_cnt==b_cnt && a_cnt>c_cnt) {
                l.add(1); l.add(2);
            }
            else if(a_cnt==c_cnt && a_cnt > b_cnt) {
                l.add(1); l.add(3);
            }
            else if(b_cnt==c_cnt && b_cnt > a_cnt) {
                l.add(2); l.add(3);
            }
            //1개만 max
            else if(a_cnt > b_cnt && a_cnt > c_cnt) l.add(1);
            else if(b_cnt > a_cnt && b_cnt > c_cnt) l.add(2);
            else if(c_cnt > a_cnt && c_cnt > b_cnt) l.add(3);
        }
        int[] answer = new int[l.size()];
        for(int i=0; i<l.size(); i++) answer[i]=l.get(i);
        return answer;
    }

    public static void main(String[] args) {
        int[] answer = solution(new int[] {1,2,3,4,5});
        System.out.println(Arrays.toString(answer));
    }
}
