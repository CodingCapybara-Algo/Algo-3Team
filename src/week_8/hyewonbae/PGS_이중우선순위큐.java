package week_8.hyewonbae;

import java.util.*;

/**
 * 이중우선순위 큐
 * 명령어      | 수신 탑
 * I 숫자     | 큐에 숫자 삽입
 * D 1       | 큐에 최댓값 삭제
 * D -1      | 큐에 최솟값 삭제
 *
 * 조건 1. 최댓값 / 최솟값 삭제 연산 시, 둘 이상인 경우 하나만 삭제
 * 조건 2. 빈 큐에 데이터를 삭제하라는 연산인 경우 무시
 *
 * return 모든 연산 처리 후,
 * 큐가 비어있으면 [0,0]
 * 비어있지 않으면 [최댓값, 최솟값]
 * */
public class PGS_이중우선순위큐 {
    static int[] solution(String[] operations) {
        int[] answer = new int[2];

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();             // 최소힙
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b)->b-a);   // 최대힙

        for (String operation : operations) {
            String token = operation.split(" ")[0];
            int value = Integer.parseInt(operation.split(" ")[1]);

            // 빈 큐에 데이터를 삭제하라는 연산이 주어질 경우, 해당 연산은 무시
            if(minHeap.isEmpty() && token.equals("D")) {
                continue;
            }

            if(token.equals("I")){
                minHeap.offer(value);
                maxHeap.offer(value);
            } else if(token.equals("D")){
                if (value == 1){
                    int max = maxHeap.poll();
                    minHeap.remove(max);        // 동기화 작업
                } else if(value == -1){
                    int min = minHeap.poll();
                    maxHeap.remove(min);        // 동기화 작업
                }
            }
//            System.out.println("min" + " " + minHeap);
//            System.out.println("max" + " " +maxHeap);
        }
        if(minHeap.isEmpty()){
            answer[0] = 0;
            answer[1] = 0;
        } else{
            answer[0]=maxHeap.peek();
            answer[1]=minHeap.peek();
        }

        return answer;
    }

    public static void main(String[] args) {
        // TEST CASE 1
        String[] operations ={"I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1"};
        // TEST CASE 2
//        String[] operations ={"I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"};

        int[] result = solution(operations);
        for(int k :result)System.out.print(k+" ");
    }
}
