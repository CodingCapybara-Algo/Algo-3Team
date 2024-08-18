package week_6.JHJ08;

import java.util.*;
public class PGS_최소직사각형 {

    static int solution(int[][] sizes) {
        int answer = 0;

        // 가로 길이를 저장할 배열 선언
        int [] width_sizes = new int[sizes.length];

        // 세로 길이를 저장할 배열 선언
        int [] height_sizes = new int[sizes.length];

        for(int i=0; i<sizes.length; i++)
        {
            // 입력받은 명함의 가로와 세로 길이 중 더 큰 항목을 가로 길이라고 지정
            if(sizes[i][0] >= sizes[i][1])
            {
                width_sizes[i] = sizes[i][0];
                height_sizes[i] = sizes[i][1];
            }
            else
            {
                width_sizes[i] = sizes[i][1];
                height_sizes[i] = sizes[i][0];
            }
        }

        Arrays.sort(width_sizes);
        Arrays.sort(height_sizes);

        int width = width_sizes[sizes.length-1];
        int height = height_sizes[sizes.length-1];

        //System.out.println(width + "/" + height);

        answer = width*height;

        return answer;
    }

    public static void main (String[] args) {
        //sizes	result
        int [][] sizes1 = {{60, 50}, {30, 70}, {60, 30}, {80, 40}};
        System.out.println(solution(sizes1));
        //[[60, 50], [30, 70], [60, 30], [80, 40]]	4000

        int [][] sizes2 = {{10, 7}, {12, 3}, {8, 15}, {14, 7}, {5, 15}};
        System.out.println(solution(sizes2));
        //[[10, 7], [12, 3], [8, 15], [14, 7], [5, 15]]	120

        int [][] sizes3 = {{14, 4}, {19, 6}, {6, 16}, {18, 7}, {7, 11}};
        System.out.println(solution(sizes3));
        //[[14, 4], [19, 6], [6, 16], [18, 7], [7, 11]]	133
    }

}
