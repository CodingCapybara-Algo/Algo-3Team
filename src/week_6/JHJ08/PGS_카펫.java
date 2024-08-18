package week_6.JHJ08;

import java.util.Arrays;

public class PGS_카펫 {

    static int[] solution(int brown, int yellow) {

        int[] answer = new int[2];

        for(int row=1; row<=(brown/4); row++)
        {
            // ex> 세로 갈색 격자의 수가 4개, 전체 갈색 격자의 수 24인 경우
            // ********
            // *//////*
            // *//////*
            // *//////*
            // *//////*
            // ********

            // 가로 갈색 격자 개수 = 24 - 4*2 = 16
            // 가로 한변의 격자 개수 = 16/2 = 8

            int b_col = ((brown - (row*2))/2);
            int b_row = row+2;

            if(b_row <= b_col) // 카펫의 가로 길이는 세로 길이와 같거나 세로 길이보다 길다.
            {
                int y_row = b_row - 2;
                int y_col = b_col - 2;

                int tmp = y_row * (y_col); // 노란색 격자 개수 계산

                if(tmp == yellow) // 계산된 격자 개수와 매개변수로 입력받은 노란색 격자 개수가 같은지 확인
                {
                    //System.out.println(b_col+"/"+b_row);

                    answer[0] = b_col;
                    answer[1] = b_row;

                    break;
                }

            }
        }

        return answer;
    }

    public static void main (String[] args) {

        int [] res1 = solution(10,2);
        System.out.println(Arrays.toString(res1));

        int [] res2 = solution(8,1);
        System.out.println(Arrays.toString(res2));

        int [] res3 = solution(24,24);
        System.out.println(Arrays.toString(res3));

        //brown	    yellow	return
        //10	    2	    [4, 3]
        //8	        1	    [3, 3]
        //24	    24	    [8, 6]
    }
}
