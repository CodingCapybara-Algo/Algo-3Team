package week_10.JHJ08;

import java.util.Arrays;

public class PGS_주식가격 {

    static public int[] solution(int[] prices) {

        int[] answer = new int[prices.length];

        for (int i=0; i<prices.length-1; i++) {

            int cnt = 0;
            for (int j=i+1; j<prices.length; j++)
            {
                cnt++;

                if(prices[i] > prices[j])
                {
                    break;
                }
            }

            answer[i] = cnt;
        }

        answer[prices.length - 1] = 0;

        return answer;
    }

    public static void main(String[] args)
    {
        int[] prices = {1, 2, 3, 2, 3};

        System.out.println(Arrays.toString(solution(prices)));

    }
}
