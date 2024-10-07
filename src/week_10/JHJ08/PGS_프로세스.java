package week_10.JHJ08;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class PGS_프로세스 {

    static class TaskInfo
    {
        int index;
        int priority;

        TaskInfo(int index, int priority)
        {
            this.index = index;
            this.priority = priority;
        }
    }

    static public int solution(int[] priorities, int location) {

        int answer = 0;

        Queue<TaskInfo> queue = new ArrayDeque<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder()); // 최대힙

        for(int i=0; i<priorities.length; i++)
        {
            maxHeap.add(priorities[i]);
            queue.add(new TaskInfo(i, priorities[i]));
        }

        while(!queue.isEmpty() && !maxHeap.isEmpty())
        {
            TaskInfo cur = queue.poll();
            int max = maxHeap.peek();

            if(cur.priority == max)
            {
                // 프로세스 실행 가능한 경우
                answer++;

                // 최대힙의 정보 삭제 처리
                maxHeap.poll();

                // 찾으려고 했던 프로세스의 인덱스와 일치하는지 확인
                if(cur.index == location)
                {
                    break;
                }

            }
            else
            {
                queue.add(cur);
            }

        }

        return answer;
    }

    public static void main(String[] args)
    {
        int [] priorities1 = {2,1,3,2};
        int [] priorities2 = {1,1,9,1,1,1};

        int answer1 = solution(priorities1, 2);
        int answer2 = solution(priorities2, 0);

        System.out.println(answer1);
        System.out.println(answer2);


    }
}
