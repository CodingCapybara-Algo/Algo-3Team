package week_10.hyewonbae;
/**
 * 큐에 대기중인 프로세스 하나 추출
 * 큐에 우선순위가 더 높은 프로세스가 있다면
 * yes --> 방금 꺼낸 프로세스를 다시 큐에 넣음
 * no --> 프로세스 실행(다시 넣지 않음)
 *
 * 입력 : 프로세스 우선순위 배열 priorities, 실행순서를 알고 싶은 프로세스의 위치 location
 * 출력 : 해당 location의 프로세스가 몇 번째로 실행되는지 return
 * */

import java.util.*;
public class PGS_프로세스 {
    static int solution(int[] priorities, int location) {
     PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
     int answer = 0;
     for(int num: priorities) {
         pq.add(num);
     }
//     System.out.println(pq);
     while(!pq.isEmpty()) {
         for(int i=0; i<priorities.length; i++) {
             if(priorities[i] == pq.peek()) {
                 pq.poll();
                 answer++;
                 if(i == location)
                     return answer;
             }
         }
     }
     return answer;
    }
    public static void main(String[] args) throws Exception {
        //Test case 1
        int[] priorities = {2, 1, 3, 2};
        int location = 2;

        //Test case 2
//        int[] priorities = {1, 1, 9, 1, 1, 1};
//        int location = 0;

        int result = solution(priorities,location);
        System.out.println(result);
    }

}
