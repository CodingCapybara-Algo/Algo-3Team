package week_7.JHJ08;

import java.util.*;

public class PGS_전력망을둘로나누기 {

    static ArrayList <ArrayList<Integer>> graph;
    static boolean [] v;
    static int cnt = 0 ;

    static void init()
    {
        Arrays.fill(v, false);
        cnt = 0;
    }

    static void dfs(int start, int end, int idx)
    {
        v[idx] = true;

        for(int i=0; i<graph.get(idx).size(); i++)
        {
            int tmp = graph.get(idx).get(i);

            if((idx == start && tmp == end) || (idx == end && tmp == start))
            {
                continue;
            }
            else
            {
                if(!v[tmp])
                {
                    dfs(start, end, tmp);
                    cnt++;
                }
            }
        }
    }

    static int solution(int n, int[][] wires) {

        int answer = -1;

        graph = new ArrayList<>();
        v = new boolean[n+1];

        for(int i=0;i<=n; i++)
        {
            graph.add(new ArrayList<>());
        }

        for (int[] wire : wires) {
            graph.get(wire[0]).add(wire[1]);
            graph.get(wire[1]).add(wire[0]);
        }

        int min = 9999;

        for (int[] wire : wires) {
            dfs(wire[0], wire[1], 1);

            //System.out.println(cnt+1 + " / " + (n - (cnt+1)));

            int tmp1 = cnt + 1; // 1번 송전탑과 연결된 송전탑 개수
            int tmp2 = n - (cnt + 1); // 1번 송전탑과 연결되지 않은 송전탑 개수

            if (min > Math.abs(tmp1 - tmp2)) {
                min = Math.abs(tmp1 - tmp2);
            }

            init(); // 방문 체크 배열, cnt 변수 초기화
        }

        answer = min;

        return answer;
    }

    public static void main(String[] args) {

        int n1 = 9;
        int [][] wires1 = {{1,3},{2,3},{3,4},{4,5},{4,6},{4,7},{7,8},{7,9}};
        System.out.println(solution(n1, wires1));

        int n2 = 4;
        int [][] wires2 = {{1,2},{2,3},{3,4}};
        System.out.println(solution(n2, wires2));

        int n3 = 7;
        int [][] wires3 = {{1,2},{2,7},{3,7},{3,4},{4,5},{6,7}};
        System.out.println(solution(n3, wires3));

    }
}
