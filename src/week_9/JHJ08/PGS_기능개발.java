package week_9.JHJ08;

import java.util.*;

public class PGS_기능개발 {

    static class Task {
        int progress; // 진행률
        int speed;    // 1일에 작업 가능한 작업량

        public Task(int progress, int speed) {
            this.progress = progress;
            this.speed = speed;
        }
    }

    static int[] solution(int[] progresses, int[] speeds) {
        ArrayDeque<Task> deq = new ArrayDeque<>();

        // Task 생성 후 큐에 삽입
        for (int i = 0; i < progresses.length; i++) {
            deq.add(new Task(progresses[i], speeds[i]));
        }

        List<Integer> result = new ArrayList<>();

        while (!deq.isEmpty()) {

            // 하루씩 작업 진척도 갱신
            Iterator<Task> iterator = deq.iterator();
            while (iterator.hasNext()) {
                Task cur_task = iterator.next();
                cur_task.progress += cur_task.speed;
            }

            // 완료된 작업 확인 및 삭제
            int del_cnt = 0;
            while (!deq.isEmpty()) {

                if(deq.peek().progress >= 100)
                {
                    deq.poll(); // 완료된 작업을 큐에서 제거
                    del_cnt++;
                }
                else
                {
                    break;
                }

            }

            // 완료된 작업이 있으면 리스트에 추가
            if (del_cnt > 0) {
                result.add(del_cnt);
            }
        }

        // 결과를 int 배열로 변환
        int[] answer = result.stream().mapToInt(i -> i).toArray();
        return answer;
    }

    public static void main(String[] args)
    {
        int [] progresses1 = {93, 30, 55};
        int [] speeds1 = {1, 30, 5};
        int [] answers1= solution(progresses1,speeds1);

        for(int i=0; i<answers1.length; i++)
        {
            System.out.print(answers1[i] + " ");
        }
        System.out.println();

        int [] progresses2 = {95, 90, 99, 99, 80, 99};
        int [] speeds2 = {1, 1, 1, 1, 1, 1};
        int [] answers2= solution(progresses2,speeds2);

        for(int i=0; i<answers2.length; i++)
        {
            System.out.print(answers2[i] + " ");
        }

        System.out.println();
    }
}
