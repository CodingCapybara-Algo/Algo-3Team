package week_6.hyewonbae;

import java.util.*;
import java.io.*;

/**
 * 1번 수포자 : 12345
 * 2번 수포자 : 21232425
 * 3번 수포자 : 3311224455
 *
 * 각 학생의 답 패턴이 문제의 정답 배열과의 일치도를 계산하여
 * 가장 많은 정답을 맞춘 학생의 번호를 반환
 * */
public class PGS_모의고사 {
    static int[] solution(int[] answers) {
//      int[] answers  = {1, 2, 3, 4, 5}
//      int[] answers  = {1, 3, 2, 4, 2}
        int[] pattern1 = {1, 2, 3, 4, 5};   //2
        int[] pattern2 = {2, 1, 2, 3, 2, 4, 2, 5};  //2
        int[] pattern3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};    //2

        // 맞춘 개수를 담을 배열
        int[] score = new int[3];

        for (int i = 0; i < answers.length; i++) {  // 0 1 2 3 4
            if (answers[i] == pattern1[i % pattern1.length]) {
                score[0]++;
            }
            if (answers[i] == pattern2[i % pattern2.length]) {
                score[1]++;
            }
            if (answers[i] == pattern3[i % pattern3.length]) {
                score[2]++;
            }
        }

        // System.out.println(score[0]+" " + score[1]+" " + score[2]);
        // 가장 많이 맞춘 개수
        int maxScore = Math.max(score[0], Math.max(score[1], score[2]));

        List<Integer> result = new ArrayList<>();

        // 같은 점수인 경우 오름차순으로 들어가게 됨.
        for (int i = 0; i < score.length; i++) {
            if (score[i] == maxScore) {
                result.add(i + 1);
            }
        }

        // List를 배열로 변환
        return result.stream().mapToInt(i -> i).toArray();
    }


    public static void main(String[] args) throws Exception{
        // TEST CASE 1
//        int[] answers = {1,2,3,4,5};      // 1

        // TEST CASE 2
        int[] answers = {1,3,2,4,2};        // 1 2 3

        int [] result = solution(answers);

        for(int r : result) System.out.print(r + " ");
    }
}
