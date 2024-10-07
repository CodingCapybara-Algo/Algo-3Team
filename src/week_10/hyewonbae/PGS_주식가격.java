package week_10.hyewonbae;

/**
 * 초 단위로 기록된 주식가격이 담긴 배열 prices
 * 각 가격의 요소들에 대해 가격이 떨어지지 않은 기간을 계산하여 리턴
 * */
import java.util.Arrays;
public class PGS_주식가격 {
    static int[] solution(int[] prices) {
        int[] result = new int[prices.length];  // 모든 요소가 0으로 초기화

        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                // i번째가 j번째보다 크다면 (값이 떨어졌다면)
                if (prices[i] > prices[j]) {
                    // 몇 초 뒤에 떨어지는 지 값 넣기
                    result[i] = j - i;
                    break;
                }
            }
            // result[i]가 0일 때 (끝까지 배열을 돌았을 때 떨어지는 가격이 없을 때)
            if (result[i] == 0) {
                // 남은 기간을 전체 길이로 계산
                result[i] = prices.length - 1 - i;
            }
        }

        return result;
    }
    public static void main(String[] args) throws Exception {

        // Test Case 1
        int[] prices = {1, 2, 3, 2, 3};
        int[] result = solution(prices);
        System.out.println(Arrays.toString(result));
    }

}
