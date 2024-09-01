package week_8.JHJ08;

import java.util.*;

public class PGS_더맵게 {

    static int solution(int[] scoville, int K) {
        int answer = 0;

        PriorityQueue<Integer> p_queue = new PriorityQueue<>(); // 낮은 숫자가 우선순위가 더 높은 우선순위 큐 생성

        for(int i=0; i<scoville.length; i++)
        {
            p_queue.add(scoville[i]);
        }

        while(p_queue.size() >= 2)
        {
            int data1 = p_queue.poll(); // 제일 작은 스코빌 지수

            if(data1 >= K) // 스코빌 지수가 7이면 종료
            {
                break;
            }

            int data2 = p_queue.poll(); // 두번째로 작은 스코빌 지수

            int new_data = data1 + (data2 * 2);

            p_queue.add(new_data);

            answer++;
        }

        if(p_queue.peek() < K)
        {
            answer = -1;
        }

        return answer;
    }

    public static void main(String[] args)
    {
        int[] scoville = {1, 2, 3, 9, 10, 12};
        int K = 7;

        int answer = solution(scoville,K);
        System.out.println(answer);

    }
}
