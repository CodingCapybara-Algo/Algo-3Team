package week_10.hyewonbae;
/**
 * 1. 다리에는 최대 bridge_length대 가능
 * 2. 다리는 weight 이하 까지의 무게 견딜 수 있음
 * 3. 다리 위에서 한칸씩 움직일 때 마다 1초 흐름
 * */
import java.util.*;
public class PGS_다리를지나는트럭 {
    static int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> bridge = new LinkedList<>();
        int time = 0;
        int currentWeight = 0; // 현재 다리 위의 트럭들의 총 무게
        int truckIndex = 0; // 대기 중인 트럭을 가리키는 인덱스

        // 다리의 길이만큼 0을 채워서 초기화 (트럭이 없을 때를 나타냄)
        for (int i = 0; i < bridge_length; i++) {
            bridge.add(0);
        }

        while (!bridge.isEmpty()) {
            time++;

            // 다리 위에서 제일 앞에 있는 트럭, 초기에는 0 제거
            currentWeight -= bridge.poll();

            // 대기 중인 트럭이 있고, 다리 위에 더 트럭을 올릴 수 있는 경우
            if (truckIndex < truck_weights.length) {
                if (currentWeight + truck_weights[truckIndex] <= weight) {
                    // 다리를 건너는 트럭에 추가
                    bridge.add(truck_weights[truckIndex]);
                    currentWeight += truck_weights[truckIndex];
                    truckIndex++;
                } else {
                    // 다리 무게가 넘으면 대기
                    bridge.add(0);
                }
            }
        }

        return time;
    }

    public static void main(String[] args) {
        // Test Case 1
        int bridge_length = 2;
        int weight = 10;
        int[] truck_weights = {7, 4, 5, 6};

        // Test Case 2
//        int bridge_length = 100;
//        int weight = 100;
//        int[] truck_weights = {10};

        // Test Case 3
//        int bridge_length = 100;
//        int weight = 100;
//        int[] truck_weights = {10,10,10,10,10,10,10,10,10,10};

        int result = solution(bridge_length, weight, truck_weights);
        System.out.println(result);
    }
}
