package week_8.JHJ08;

import java.util.*;

public class PGS_디스크컨트롤러 {

    static class Job
    {
        int wait;
        int time;

        Job(int wait, int time)
        {
            this.wait = wait;
            this.time = time;
        }
    }

    static int solution(int[][] jobs) {
        // 대기 시간 기준으로 정렬
        Arrays.sort(jobs, Comparator.comparingInt(a -> a[0]));

        // 작업 시간 기준으로 정렬
        PriorityQueue<Job> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.time));

        int time = 0;  // 현재 시간
        int jobIndex = 0;  // 처리할 작업의 인덱스
        int totalWaitTime = 0;  // 총 대기 시간

        while (jobIndex < jobs.length || !pq.isEmpty()) {

            // 현재 시간까지 도착한 작업을 큐에 추가
            while (jobIndex < jobs.length && jobs[jobIndex][0] <= time) {
                pq.offer(new Job(jobs[jobIndex][0],jobs[jobIndex][1]));
                jobIndex++;
            }

            if (!pq.isEmpty()) {
                // 큐에서 처리 시간이 가장 짧은 작업을 꺼내어 처리
                //int[] job = pq.poll();
                Job cur_job = pq.poll();
                time += cur_job.time;  // 작업 처리 완료 시간
                totalWaitTime += (time - cur_job.wait);  // 대기 시간 계산
            }
            else
            {
                // 큐가 비어있는 경우, 다음 작업의 요청 시간으로 시간을 이동
                time = jobs[jobIndex][0];
            }
        }

        // 평균 대기 시간 계산
        return totalWaitTime / (jobs.length);
    }

    public static void main(String[] args)
    {
        int [][] jobs = {{0,3},{1,9},{2,6}};
        System.out.println(solution(jobs));
    }
}
