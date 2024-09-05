package week_9.hyewonbae;
/**
 * 각 기능은 진도가 100% 일 때 서비스에 반영할 수 있음.
 * 뒤에 있는 기능이 먼저 개발되어도,
 * 앞에 있는 기능이 100%가 되어 배포될 때 반영할 수 있음.
 * 배포는 하루에 한 번만 수행
 *
 * 작업 진도 < 100
 * 작업 속도 <= 100
 * return 배포마다 몇 개의 기능이 배포되는지
 * */

import java.util.*;
public class PGS_기능개발 {

    static ArrayList<Integer> solution(int[] progresses, int[] speeds) {
        ArrayDeque<Integer> queue = new ArrayDeque<>();

        // 각 기능이 완료되기까지 필요한 작업일수 계산
        for (int i = 0; i < progresses.length; i++) {
            int work_days = (100-progresses[i]) % speeds[i];
            if(work_days == 0){
                queue.offer((100-progresses[i]) / speeds[i]);
            } else {
                queue.offer(((100-progresses[i]) / speeds[i]) + 1);
            }
        }

//        System.out.println(queue);  // queue = [7, 3, 9]

        ArrayList<Integer> answer = new ArrayList<>();
        while(!queue.isEmpty()){
            int first_work_day = queue.poll();
            int count = 1;

            // 다음 기능들이 첫번째 작업 일수보다 작거나 같은 경우 함께 배포
            while(!queue.isEmpty() && first_work_day >= queue.peek()){
                queue.poll();
                count++;
            }

            // 배포될 기능의 개수를 결과에 추가
            answer.add(count);
        }
        return answer;
    }

    public static void main(String[] args) throws Exception {
        // TEST CASE 1
        int[] progresses = {93, 30, 55};
        int[] speeds = {1, 30, 5};
        System.out.println(solution(progresses, speeds));

        // TEST CASE 2
//        int[] progresses = {95, 90, 99, 99, 80, 99};
//        int[] speeds = {1, 1, 1, 1, 1, 1};
//        System.out.println(solution(progresses, speeds));
    }
}
