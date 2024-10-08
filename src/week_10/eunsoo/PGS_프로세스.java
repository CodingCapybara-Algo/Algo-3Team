package week_10.eunsoo;

import java.util.ArrayDeque;

/* 프로세스
 * [입력] priorities : 우선순위 1차원 배열,
 * location : 몇번째로 실행될지 알고싶은 위치 (0부터 시작)
 * [출력] 특정 프로세스 실행 순서
 * [방법] ArrayDeque 사용
 * 1. 큐에 프로세스 하나 꺼내기
 * 2. 우선순위 더 높은 프로세스 있으면 다시 넣기
 * 3. 없으면 방금 꺼낸 프로세스 실행
 */
public class PGS_프로세스 {
    public static int solution(int[] priorities, int location) {
        int answer = 0;
        ArrayDeque<int[]> q = new ArrayDeque<>();
        // 큐 - {인덱스, 우선순위} 2차원 배열
        for (int i = 0; i < priorities.length; i++) q.add(new int[]{i, priorities[i]});

        while (!q.isEmpty()) {
            // 1. 큐에 프로세스 하나 꺼내기
            int[] array = q.poll();
            int idx = array[0], prior = array[1];
            // 최댓값 확인 - 우선순위큐
            boolean isMax = true;
            for (int[] arr : q) {
                if (arr[1] > prior) isMax = false;
            }

            // 3. 없으면 방금 꺼낸 프로세스 실행
            if (isMax) {
                answer++;
                if (idx == location) return answer;
                // 2. 우선순위 더 높은 프로세스 있으면 다시 넣기
            } else {
                q.offer(new int[]{idx, prior});
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        int answer = solution(new int[]{1, 1, 9, 1, 1, 1}, 0);
        System.out.println(answer);
    }
}