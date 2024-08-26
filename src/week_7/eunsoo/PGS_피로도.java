package week_7.eunsoo;

/* 피로도
 * [입력] k: 유저 현재 피로도,
 * dungeons: 각 던전별 {최소필요,소모}피로도 2차원 배열
 * [출력] 유저가 탐험할 수 있는 최대 던전 수
 * [방법] 중복 없는 순열 -> 최대 던전수 출력
 */

public class PGS_피로도 {
    static int max = Integer.MIN_VALUE;
    static int[][] d;
    static boolean[] v;

    public static void perm(int cnt, int N, int k, int enter) {
        // cnt:깊이, N:최대개수, k:현재피로도, enter:던전입장수
        if(cnt == N) {
            max = Integer.max(max, enter);
            return;
        }
        for(int i = 0; i < N; i++) {
            if(v[i]) continue;
            v[i] = true;
            if(k >= d[i][0]) { // (내 피로도) >= (최소 필요 피로도)
                int nowHeal = k-d[i][1];
                //System.out.println("소모될 체력: "+d[i][1]);
                //System.out.println("현재 체력: "+nowHeal);
                //System.out.println("던전 입장수: "+(enter+1)+"\n");
                perm(cnt+1,N,nowHeal,enter+1);
            }
            else { // (내 피로도) < (최소 필요 피로도)
                perm(cnt+1,N,k,enter); //다음으로 PASS
            }
            v[i] = false;
        }
    }

    public static int solution(int k, int[][] dungeons) {
        d = dungeons;
        v = new boolean[dungeons.length];
        perm(0, dungeons.length, k, 0);
        return max;
    }

    public static void main(String[] args) {
        int answer = solution(80, new int[][] {{80,20},{50,40},{30,10}});
        System.out.println(answer);
    }
}
