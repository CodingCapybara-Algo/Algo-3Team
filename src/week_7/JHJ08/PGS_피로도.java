package week_7.JHJ08;

import java.util.*;


public class PGS_피로도 {

    static boolean [] v; // 방문 확인
    static int cnt = 0; // 던전 방문 횟수 체크
    static int max = -999999; // 던정 최대 방문 횟수 체크

    // 최대로 방문할수 있는 횟수를 체크해주는 함수
    static void chk(int hp, final int[][] dungeons)
    {
        // 최대 방문 횟수 갱신
        if(cnt > max)
        {
            max = cnt;
        }

        // 던전 개수 == 최대 방문 횟수
        if(cnt == dungeons.length)
        {
            return;
        }

        for(int i=0; i<dungeons.length; i++)
        {
            // 현재 피로도가 던전에 들어갈 수 있는 조건 피로도보다 크거나 같은지 확인
            if(hp >= dungeons[i][0])
            {
                // 방문했던 던전인지 확인
                if(!v[i])
                {
                    v[i] = true;
                    cnt++; // 방문하지 않았던 던전이고, 들어갈수 있는 조건을 만족할 경우 cnt에 1을 더해준다.
                    chk(hp - dungeons[i][1], dungeons);
                    v[i] = false;
                    cnt--;
                }
            }

        }
    }

    static int solution(int k, int[][] dungeons) {
        int answer = -1;

        v = new boolean[dungeons.length];

        chk(k,dungeons);
        answer = max;

        return answer;
    }

    public static void main(String[] args) {

        int k = 80;
        int [][] dungeons = {{80,20},{50,40},{30,10}};

        System.out.println(solution(k,dungeons));
    }
}
