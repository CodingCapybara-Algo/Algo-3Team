package week_8.eunsoo;

import java.util.Arrays;
import java.util.PriorityQueue;

/* 디스크 컨트롤러
 * [입력] jobs : {요청,종료} 2차원배열
 * [출력] 소요(종료-요청) 평균 시간
 * [방법] 우선순위 큐 -> 요청시간 및 소요시간 정렬
 */

public class PGS_디스크컨트롤러 {
    public static int solution(int[][] jobs) {
        //요청시간 정렬
        Arrays.sort(jobs, (o1, o2) -> Integer.compare(o1[0], o2[0]));

        //소요시간 정렬
        PriorityQueue<int[]> q = new PriorityQueue<>(
                (o1, o2) -> Integer.compare(o1[1],o2[1])
        );

        int idx=0, start=0, end=0, cost=0;
        while(idx < jobs.length || !q.isEmpty()) {
            //현재 시점까지 도착한 모든 작업을 큐에 추가
            while(idx < jobs.length && jobs[idx][0] <= start) q.offer(jobs[idx++]);
            //아무것도 없으면 다음 작업 요청시간으로 이동
            if (q.isEmpty()) {
                start = jobs[idx][0];
                continue;
            }

            int[] time = q.poll();
            end = start + time[1];
            cost += end - time[0];
            start = end;
        }

        return cost/jobs.length;
    }

    public static void main(String[] args) {
        int answer = solution(new int[][] {{0,3}, {1,9}, {2,6}});
        System.out.println(answer);
    }
}
