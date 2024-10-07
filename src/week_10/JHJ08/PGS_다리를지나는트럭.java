package week_10.JHJ08;

import java.util.*;

public class PGS_다리를지나는트럭 {

    static class Truck_Info
    {
        int weight; // 트럭 무게
        int time; // 다리를 건너는데, 걸리는 시간

        Truck_Info(int weight, int time)
        {
            this.weight = weight;
            this.time = time;
        }
    }


    static public int solution(int bridge_length, int weight, int[] truck_weights) {

        int answer = 0;

        Queue<Integer> waitingTruckQueue = new ArrayDeque<>(); // 대기 트럭 정보를 담는 큐
        Set<Truck_Info> crossingTruckSet = new HashSet<>(); // 다리를 건너는 트럭 정보를 담는 set
        Queue <Integer> completedTruckQueue = new ArrayDeque<>(); // 다리를 지난 트럭 정보를 담는 큐


        for(int i=0; i<truck_weights.length; i++)
        {
            waitingTruckQueue.add(truck_weights[i]);
        }

        int currentWeightOnBridge = 0; // 다리를 건너는 트럭들의 무게 총합

        while(true)
        {
            if(completedTruckQueue.size() == truck_weights.length) // 모든 트럭이 다리를 건넌 경우, while문 종료
            {
                break;
            }

            // 다리를 건너는 트럭의 time을 1초씩 감소시키고, 0초가 되면 set에서 삭제
            Iterator<Truck_Info> iterator = crossingTruckSet.iterator();

            while (iterator.hasNext()) {

                Truck_Info truck = iterator.next();
                truck.time--; // time 1초씩 감소

                // time이 0초가 되는 경우
                if (truck.time == 0) {
                    completedTruckQueue.add(truck.weight); // 다리를 지난 트럭 정보를 저장하는 큐에 해당 트럭 무게 정보 추가
                    currentWeightOnBridge -= truck.weight; // 다리를 건너는 트럭의 무게합을 담고 있는 run_weight 변수에 해당 트럭 무게 빼기
                    iterator.remove(); // 다리를 건너는 트럭 정보를 저장하고 있는 set에서 해당 트럭 정보 삭제
                }
            }


            if(!waitingTruckQueue.isEmpty()) // 대기 중인 트럭 정보가 있는지 확인
            {
                int truckWeight = waitingTruckQueue.peek();

                if(crossingTruckSet.size() < bridge_length) // 다리에 최대로 올라갈수 있는 트럭 개수 확인
                {
                    if((currentWeightOnBridge + truckWeight) <= weight) // 다리에 최대로 올라갈 수 있는 무게 확인
                    {
                        // 두가지 조건을 만족하는 경우
                        currentWeightOnBridge += truckWeight;
                        crossingTruckSet.add(new Truck_Info(truckWeight, bridge_length));
                        waitingTruckQueue.poll();
                    }
                }

            }

            answer++;
        }

        return answer;
    }

    public static void main(String[] args)
    {
        int [] truck_weights1 = {7,4,5,6};
        int [] truck_weights2 = {10};
        int [] truck_weights3 = {10,10,10,10,10,10,10,10,10,10};

        System.out.println(solution(2,10,truck_weights1));
        System.out.println(solution(100,100,truck_weights2));
        System.out.println(solution(100,100,truck_weights3));

    }

}
