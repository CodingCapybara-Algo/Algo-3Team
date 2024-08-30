package week_8.hyewonbae;
/**
 * 하드디스크는 한 번에 하나의 작업만 수행
 * 작업 요청은 일반적으로 요청 순서대로 처리
 * 작업을 수행하지 않을 때에는 먼저 요청이 들어온 작업부터 처리
 *
 * jobs [작업이 요청되는 시점, 작업이 소요시간]
 * return 작업의 요청부터 종료까지 걸린 시간의 최소 평균(소수점 이하는 버림)
 * */

import java.util.*;

public class PGS_디스크컨트롤러 {
    static int solution(int[][] jobs) {
        int answer = 0;
        int end = 0;        // 현재 시간
        int total = 0;      // 총 대기시간 합계
        int index = 0;      // 현재 작업 배열의 인덱스
        int count = 0;      // 완료된 작업 수

        // 작업 배열 : 요청 오름차순으로 정렬
        Arrays.sort(jobs,((o1, o2) -> o1[0] - o2[0]));
        // 우선순위 큐 : 소요시간 오름차순으로 정렬
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);

        while(true){
            // 모든 작업이 완료되었으면 종료
            if(count == jobs.length) break;

            // 수행 가능한 작업을 pq에 저장
            while (index < jobs.length && jobs[index][0] <= end) {
                pq.offer(jobs[index]);

                // 우선순위 큐의 상태 출력
//                System.out.println(index);
//                System.out.println("Added to Queue: " + Arrays.toString(jobs[index]));
//                System.out.println("Current Queue State: " + Arrays.deepToString(pq.toArray()));

                index++;
            }

            if(!pq.isEmpty()) {
                // 작업 소요시간이 가장 짧은 작업 빼내기
                int[] current_job = pq.poll();
                total += end + current_job[1] - current_job[0];     // 현재시간 + 작업 소요시간 - 요청 대기시간
                end += current_job[1];      // 현재시간에 소요시간 업데이트
                count++;                    // 다음 작업
            } else {
                // 큐에 작업이 없다면
                // 요청 시간이 가장 빠른 작업 추가
                end = jobs[index][0];
            }
        }

        answer = total / jobs.length;
        return answer;
    }

    public static void main(String[] args) throws Exception {
        // TEST CASE
        int[][] jobs = {{0,3}, {1,9}, {2,6}};
        int result = solution(jobs);
        System.out.println(result);
    }
}
