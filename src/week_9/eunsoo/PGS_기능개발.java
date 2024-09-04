package week_9.eunsoo;

/* 기능개발
 * [입력] progresses: 작업진도, speeds: 개발속도 1차원 배열
 * - 진도 100일 때 배포 (앞 기능보다 먼저 배포될 수 X)
 * [출력] 각 배포마다 배포되는 기능 수
 * [방법] 큐에 기능 순서대로 넣고 -> 개발속도만큼 계속 더해가며 -> 100 채우면 빠져나오고 count!
 */


import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;

public class PGS_기능개발 {
    public static int[] solution(int[] progresses, int[] speeds) {
        ArrayList<Integer> list = new ArrayList<>();
        int cnt = 0;

        ArrayDeque<Integer> progressQ = new ArrayDeque<>(); //작업진도 큐
        for(int p:progresses) progressQ.add(p);
        ArrayDeque<Integer> speedQ = new ArrayDeque<>(); //개발속도 큐
        for(int s:speeds) speedQ.add(s);

        while(progressQ.peek() < 100) {
            //1. 개발 속도에 따른 작업 진도 갱신
            for(int i=0; i<progressQ.size(); i++) {
                //최상위 작업진도 + 개발속도
                int speed = speedQ.poll(), progress = progressQ.poll();
                progressQ.add(speed + progress);
                speedQ.add(speed);
            }
            //2. 앞에서부터 100 넘는 기능 있으면
            while(!progressQ.isEmpty() && progressQ.peek() >= 100) {
                progressQ.poll(); //작업진도 큐,
                speedQ.poll(); //개발속도 큐 모두 지우고,
                cnt++; //카운트
            }
            //3. 정답 배열에 카운트 추가
            if(cnt >= 1) {
                list.add(cnt);
                cnt = 0; //초기화
            }

            if(progressQ.isEmpty()) break; //4. 모두 끝나면 종료
        }

        //5. ArrayList -> int[] 변환
        int[] answer = new int[list.size()];
        for(int i=0; i<list.size(); i++) answer[i] = list.get(i);
        return answer;
    }

    public static void main(String[] args) {
        int[] answer = solution(new int[] {95, 90, 99, 99, 80, 99},
                new int[] {1, 1, 1, 1, 1, 1});
        System.out.println(Arrays.toString(answer));
    }

}
