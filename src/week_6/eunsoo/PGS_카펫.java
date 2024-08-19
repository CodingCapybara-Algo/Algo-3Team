package week_6.eunsoo;

/* 카펫
 * [입력] brown: 갈색 타일수, yellow: 노랑 타일수
 * - 노랑색 타일이 중앙, 갈색 타일은 테두리 1
 * [출력] 카펫 가로크기, 세로크기
 */
import java.io.*;
import java.util.*;

public class PGS_카펫 {
    public static int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int sum = brown + yellow;

        for (int i = 3; i < sum; i++) {
            int j = sum / i;

            if (sum % i == 0 && j >= 3) {
                int col = Math.max(i, j);
                int row = Math.min(i, j);
                int center = (col - 2) * (row - 2);

                if (center == yellow) {
                    answer[0] = col;
                    answer[1] = row;
                    return answer;
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        int[] answer = solution(10, 2);
        System.out.println(Arrays.toString(answer));
    }
}
