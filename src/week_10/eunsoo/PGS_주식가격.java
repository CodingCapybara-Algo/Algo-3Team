package week_10.eunsoo;

import java.util.Arrays;

/* 주식가격
 * [입력] prices : 초별 가격 (1차원 배열)
 * [출력] 가격이 떨어지지 않은 시간 (1차원 배열)
 * [방법] for문 사용으로 떨어졌는지 확인
 */
public class PGS_주식가격 {
    public static int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        for (int i = 0; i < prices.length; i++) {
            int p = prices[i];
            int time = 0;
            for (int j = i + 1; j < prices.length; j++) {
                int n = prices[j];
                if (n < p) {
                    time++;
                    answer[i] = time;
                    break;
                } else {
                    time++;
                }
                if (time > 0 && j == prices.length - 1) {
                    answer[i] = time;
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        int[] answer = solution(new int[]{1, 2, 3, 2, 3});
        System.out.println(Arrays.toString(answer));
    }
}
