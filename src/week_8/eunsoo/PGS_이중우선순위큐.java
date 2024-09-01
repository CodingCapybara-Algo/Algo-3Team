package week_8.eunsoo;

import java.util.Arrays;
import java.util.PriorityQueue;


public class PGS_이중우선순위큐 {
    public static int[] solution(String[] operations) {
        int[] answer = {};
        //최소값 큐 : 오름차순 정렬
        PriorityQueue<Integer> min_q = new PriorityQueue<>();
        //최댓값 큐 : 내림차순 정렬
        PriorityQueue<Integer> max_q = new PriorityQueue<>(
                (o1, o2) -> Integer.compare(o2, o1));

        for(String op:operations) {
            if(op.equals("D -1")) {
                if(!min_q.isEmpty()){
                    int num = min_q.poll(); //최소값 큐에 첫 원소
                    max_q.remove(num); //최대값 큐도 동기화
                }
            }
            else if(op.equals("D 1")) {
                if(!max_q.isEmpty()) {
                    int num = max_q.poll();
                    min_q.remove(num);
                }
            }
            else {
                String[] str = op.split(" ");
                min_q.offer(Integer.parseInt(str[1])); //숫자 추가
                max_q.offer(Integer.parseInt(str[1])); //동기화
            }
        }

        if(min_q.isEmpty()) return new int[] {0,0};
        return new int[] {max_q.poll(), min_q.poll()};
    }

    public static void main(String[] args) {
        int[] answer = solution(new String[] {"I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1"});
        System.out.println(Arrays.toString(answer));
    }
}
