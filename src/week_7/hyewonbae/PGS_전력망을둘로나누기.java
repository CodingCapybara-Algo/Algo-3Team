package week_7.hyewonbae;
/**
 * n개의 송전탑과 연결된 트리형태의 전선정보 wires
 * 전선들 중 하나를 끊어 두 개의 전력망으로 분할
 * 송전탑 개수의 차이가 가장 비슷하도록 구분
 * return 송전탑 개수의 차이(절댓값)
 * */
import java.io.*;
import java.util.*;

public class PGS_전력망을둘로나누기 {

    static int answer;
    static ArrayList<Integer>[] graph;      // 인접리스트 생성
    /**
     * @param n 송전탑의 총 개수
     * @param wires 전선 정보를 담고 있는 2차원 배열
     * @return 송전탑 개수의 차이(절댓값)
     * */
    static int solution(int n, int[][] wires) {
        graph = new ArrayList[n+1];
        answer = Integer.MAX_VALUE;     // 최소값 초기화

        for(int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        // 인접행렬 그래프 생성
        for(int i=0;i<wires.length;i++) {
            int from = wires[i][0];
            int to = wires[i][1];
            graph[from].add(to);
            graph[to].add(from);
        }

        // 간선을 차례대로 하나씩 제거 후 dfs 탐색
        for(int i =0;i<wires.length;i++) {
            int from = wires[i][0];
            int to = wires[i][1];

            // 전선 제거
            graph[from].remove(Integer.valueOf(to));
            graph[to].remove(Integer.valueOf(from));

            // 방문처리 여부를 위한 배열
            boolean[] visited = new boolean[n+1];

            // 송접탑의 개수 (하나의 전력망)
            int cnt = dfs(1,visited);

            // 송전탑 개수의 차이 계산
            int diff = Math.abs(cnt-(n-cnt));   // 노드 수의 차이
            // 최소값 갱신
            answer = Math.min(answer,diff);

            // 끊었던 전선 다시 연결
            graph[from].add(to);
            graph[to].add(from);
        }
        return answer;
    }

    /**
     * dfs 탐색
     * 주어진 노드에서 탐색하여 연결된 송접탑의 개수 계산
     *
     * @param node 현재 노드
     * @param visited 방문 여부 확인 배열
     * @return 현재 노드에서 연결된 송전탑의 개수
     * */
    static int dfs(int node, boolean[] visited) {
        visited[node] = true;
        int cnt = 1;

        for(int next : graph[node]) {
            if(!visited[next]) {
                cnt += dfs(next,visited);
            }
        }
        return cnt;
    }


    public static void main(String[] args) throws Exception {
        // TEST CASE 1
        int n = 9;
        int[][] wires = {{1,3},{2,3},{3,4},{4,5},{4,6},{4,7},{7,8},{7,9}};
        System.out.println(solution(n,wires));  // 3

        // TEST CASE 2
//        int n = 4;
//        int[][] wires = {{1,2},{2,3},{3,4}};
//        System.out.println(solution(n,wires));    // 0

        // TEST CASE 3
//        int n = 7;
//        int[][] wires = {{1,2},{2,7},{3,7},{3,4},{4,5},{6,7}};
//        System.out.println(solution(n,wires));    // 1

    }
}
