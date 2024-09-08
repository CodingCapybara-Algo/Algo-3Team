package week_9.JHJ08;

import java.util.*;

public class PGS_같은숫자는싫어 {

    static int[] solution(int []arr) {

        // ArrayDeque를 사용하여 마지막으로 추가된 값을 저장할 큐
        ArrayDeque<Integer> q = new ArrayDeque<>();
        // 결과 값을 저장할 리스트
        ArrayList<Integer> list = new ArrayList<>();

        // 배열을 순회하면서 중복되지 않은 값만 리스트에 저장
        for (int i = 0; i < arr.length; i++) {
            // 큐가 비어있지 않은 경우 (즉, 이전 값이 존재할 때)
            if (!q.isEmpty()) {
                // 큐의 마지막 값을 가져옴 (직전에 넣은 값)
                int data = q.peekLast();
                // 현재 배열 값이 직전 값과 다르면 큐에 추가하고 리스트에도 추가
                if (data != arr[i]) {
                    q.add(arr[i]);
                    list.add(arr[i]);
                }
            }
            else
            {
                // 큐가 비어있을 때는 바로 값을 추가
                q.add(arr[i]);
                list.add(arr[i]);
            }
        }

        // 리스트에 저장된 결과 값을 int[] 배열로 변환하여 반환
        int[] answer = list.stream().mapToInt(Integer::intValue).toArray();

        return answer;
    }

    public static void main(String[] args)
    {
        int [] arr1 = {1,1,3,3,0,1,1};
        int [] answers1= solution(arr1);

        for(int i=0; i<answers1.length; i++)
        {
            System.out.print(answers1[i] + " ");
        }
        System.out.println();

        int [] arr2 = {4,4,4,3,3};
        int [] answers2= solution(arr2);

        for(int i=0; i<answers2.length; i++)
        {
            System.out.print(answers2[i] + " ");
        }
        System.out.println();
    }
}
