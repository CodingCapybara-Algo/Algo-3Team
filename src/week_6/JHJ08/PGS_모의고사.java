package week_6.JHJ08;

import java.util.ArrayList;
import java.util.Arrays;

public class PGS_모의고사 {

    static int[] solution(int[] answers) {

        int[] answer = {};
        int [] count = new int[3]; // 1번, 2번, 3번 사람의 정답을 맞춘 개수 저장하는 배열

        int [] pattern1 = {1,2,3,4,5}; // 1번 수포자가 정답을 찍는 방식
        int [] pattern2 = {2,1,2,3,2,4,2,5}; // 2번 수포자가 정답을 찍는 방식
        int [] pattern3 = {3,3,1,1,2,2,4,4,5,5}; // 3번 수포자가 정답을 찍는 방식

        // 각 수포자들이 찍는 방식의 답과 진짜 정답과 비교 후 각각의 사람의 정답의 개수를 배열에 저장
        for(int i=0; i<answers.length; i++)
        {
            if(pattern1[i%pattern1.length] == answers[i])
            {
                count[0]++;
            }

            if(pattern2[i%pattern2.length] == answers[i])
            {
                count[1]++;
            }

            if(pattern3[i%pattern3.length] == answers[i])
            {
                count[2]++;
            }
        }

        // 테스트코드1
        /*for(int i=0; i<count.length; i++)
        {
            System.out.println(i+"번째 : " + count[i]);
        }*/

        ArrayList <Integer> list = new ArrayList<>();

        // 1번 사람으로 값 초기 설정
        list.add(1);
        int max = count[0];

        // 가장 답을 많이 맞춘 사람을 list에 저장
        for(int i=1; i<3; i++)
        {
            if(max < count[i])
            {
                list.clear();
                list.add(i+1);
                max = count[i];
            }
            else if(max == count[i])
            {
                list.add(i+1);
            }
        }

        // 테스트 코드2
        /*for(int i=0; i<list.size(); i++)
        {
            System.out.println(list.get(i));
        }*/

        answer = list.stream()
                .mapToInt(i -> i)
                .toArray();

        // 결과 반환
        return answer;
    }

    public static void main (String[] args) {
        
        int [] answers1 = {1,2,3,4,5};
        System.out.println(Arrays.toString(solution(answers1)));
        //[1,2,3,4,5]	[1]

        int [] answers2 = {1,3,2,4,2};
        System.out.println(Arrays.toString(solution(answers2)));
        //[1,3,2,4,2]	[1,2,3]
    }

}
