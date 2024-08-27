package week_8.hyewonbae;
/**
 * 섞은 음식의 스코빌 지수 = 가장 맵지 않은 음식의 스코빌 지수 + (두 번째로 맵지 않은 음식의 스코빌 지수 * 2)
 * return 모든 음식의 스코빌 지수가 K 이상일 때 섞어야 하는 최소 횟수
 * */
import java.util.*;

public class PGS_더맵게 {
    /**
     * 우선순위 큐 PriorityQueue 를 사용
     * @param scoville 모든 음식의 스코빌 지수 배열
     * @param K 스코빌 지수
     * return 섞어야 하는 최소 횟수 count
     * */
    static int solution(int[] scoville, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        // 스코빌 지수 배열을 우선순위 큐 pq에 저장
        for( int sco : scoville){
            pq.add(sco);
        }

        // count 초기화
        int count = 0;

        // pq가 최소 2개 이상일 때 최소값이 K보다 작으면 반복 , 즉 pq의 최소값이 K면 종료        while(pq.size() > 1 && pq.peek() < K) {
        while(pq.size() > 1 && pq.peek() < K) {
            int min = pq.poll();
            int min2 = pq.poll();

            int scoNum = min+(min2*2);
            pq.add(scoNum);         // 섞은 스코빌 지수를 다시 큐에 담기
            count ++;               // 횟수 증가
        }

        if(pq.peek() < K){
            return -1;
        }

        return count;
    }

    public static void main(String[] args) throws Exception {

        // TEST CASE
        int [] scoville = {1,2,3,9,10,12};
        int K = 7;
        int result = solution(scoville, K);
        System.out.println(result);
    }

}
