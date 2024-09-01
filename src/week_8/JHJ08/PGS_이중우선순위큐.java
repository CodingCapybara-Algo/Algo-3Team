package week_8.JHJ08;

import java.util.*;

public class PGS_이중우선순위큐 {

    static int[] solution(String[] operations) {

        // 우선순위 큐
        PriorityQueue<Integer> queue = new PriorityQueue<>();

        // 최대값을 삭제하기 위해 사용될 임시 리스트
        ArrayList<Integer> array = new ArrayList<>();

        // 주어진 명령어 배열을 순회
        for(int i = 0; i < operations.length; i++) {

            String tmp = operations[i];
            String[] arr_tmp = tmp.split(" ");

            // D : 삭제
            if(arr_tmp[0].equals("D")) {
                // -1 : 최소값 삭제
                if(arr_tmp[1].equals("-1")) {
                    queue.poll();
                }
                // 1 : 최대값 삭제
                if(arr_tmp[1].equals("1")) {
                    // 최대값을 삭제하기 위해 큐의 모든 요소를 임시 리스트로 이동
                    array.clear();

                    while (!queue.isEmpty()) {
                        int num = queue.poll();
                        // 큐의 마지막 원소가 최대값이므로, 삭제할 원소가 아닌 경우에만 리스트에 추가
                        if(queue.size() > 0) {
                            array.add(num);
                        }
                    }

                    // 리스트의 모든 원소를 다시 큐에 추가
                    for(int num : array) {
                        queue.add(num);
                    }
                }
            }
            // I : 추가
            else if(arr_tmp[0].equals("I")) {
                queue.add(Integer.parseInt(arr_tmp[1]));
            }
        }

        int max = 0;
        int min = 0;

        // 최소값
        if(!queue.isEmpty())
        {
            min = queue.poll();
            max = min;
        }

        // 최대값 갱신
        while (!queue.isEmpty()) {
            max = queue.poll();
        }

        // 결과를 배열에 담아 반환
        int[] answer = new int[2];
        answer[0] = max; // 최대값
        answer[1] = min; // 최소값

        return answer;
    }

    public static void main(String[] args)
    {
        String [] operations1 = {"I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1"};
        int [] answer1 = solution(operations1);
        System.out.println(answer1[0] + "/" + answer1[1]);

        String [] operations2 = {"I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"};
        int [] answer2 = solution(operations2);
        System.out.println(answer2[0] + "/" + answer2[1]);
    }
}
