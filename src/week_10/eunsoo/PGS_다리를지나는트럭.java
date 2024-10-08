package week_10.eunsoo;

import java.util.ArrayDeque;

/* 다리를 지나는 트럭
 * [입력] bridge_length: 가능한 트럭 수, weight: 가능한 무게,
 * truck_weights: 트럭별 무게 1차원 배열
 * [출력] 모든 다리가 건너기까지 최소 시간 (초)
 * [방법]
 * 1. 다리 올라가기
 * 2. 다리 더 건너기 (weight 이하면)
 * 3. 건너기 완료 (bridge_length 다 차 있으면)
 */

public class PGS_다리를지나는트럭 {
    public static int solution(int bridge_length, int weight, int[] truck_weights) {
        // 현재 시간, 무게
        int time = 0, totalW = 0;

        // 대기 우선순위 큐
        ArrayDeque<Integer> waitQ = new ArrayDeque<>();

        // 트럭 순서대로
        for (int i = 0; i < truck_weights.length; i++) {
            int truckW = truck_weights[i];
            while (true) {
                //1. 다리 올라가기 (큐 비었으면)
                if (waitQ.isEmpty()) {
                    waitQ.offer(truckW);
                    time++;
                    totalW += truckW;
                    break;
                }
                //3. 건너기 완료 (큐 꽉 찼으면)
                else if (waitQ.size() == bridge_length) {
                    totalW -= waitQ.poll();
                }
                // 2. 다리 더 건너기 (큐 안 비었으면)
                else {
                    if (truckW + totalW <= weight) { // (weight 이하면
                        waitQ.offer(truckW);
                        time++;
                        totalW += truckW;
                        break;
                    } else { // (weight 넘으면)
                        waitQ.offer(0); //한 칸씩 건너게 밀어주기
                        time++;
                    }
                }
            }
        }
        return time + bridge_length;
    }

    public static void main(String[] args) {
        int answer = solution(2, 10, new int[]{7, 4, 5, 6});
        System.out.println(answer);
    }
}
