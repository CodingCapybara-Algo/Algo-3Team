package week_9.eunsoo;

/* 같은 숫자는 싫어
 * [입력] 숫자(0~9) 1차원 배열
 * [출력] 연속 숫자 제거된 배열
 * [방법] 스택 -> 가장 마지막 원소(peekLast)와 동일하지 않으면 추가
 */


import java.util.ArrayDeque;
import java.util.Arrays;

public class PGS_같은숫자는싫어 {
    public static int[] solution(int []arr) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        stack.add(arr[0]); //초기화
        for(int a:arr) {
            if(stack.peekLast() != a) //마지막 원소와 다른 값이면
                stack.add(a); //추가
        }

        int[] answer = new int[stack.size()];
        int idx = 0;
        for(Integer a:stack) {
            answer[idx] = a;
            idx++;
        }
        return answer;
    }

    public static void main(String[] args) {
        int[] answer = solution(new int[] {1,1,3,3,0,1,1});
        System.out.println(Arrays.toString(answer));
    }

}
