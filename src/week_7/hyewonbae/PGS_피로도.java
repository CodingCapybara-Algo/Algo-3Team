package week_7.hyewonbae;

/**
 * [최소피로도, 소모피로도] 2차원 배열
 * k : 유저의 현재 피로도
 * 최소피로도 >= 소모피로도
 * return 최대 던전 수
 *
 * 입력 k:80, dungeons:[[80,20],[50,40],[30,10]]
 * */

public class PGS_피로도 {
    static int max= -1;
    static int solution(int k, int[][] dungeons){
        boolean[] visited = new boolean[dungeons.length];
        dfs(k,dungeons,0,visited);
        return max;
    }


    /**
     * 깊이 우선 탐색(DFS)
     *
     * @param k 현재 피로도
     * @param dungeons 던전 정보 배열 [최소피로도, 소모피로도]
     * @param count 현재까지 탐색한 던전 수
     * @param visited 각 던전의 방문 여부를 저장하는 배열
     */
    static void dfs(int k, int[][] dungeons, int count, boolean[] visited) {

        max = Math.max(max, count); // 현재까지 탐색한 던전 수가 최대값인지 확인

        for(int i=0;i<dungeons.length;i++){
            if(!visited[i] && k >= dungeons[i][0]) {
                visited[i] = true;
                dfs(k-dungeons[i][1],dungeons,count+1,visited);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) throws Exception{
        // TEST CASE
        int k = 80;
        int [][] dungeons = {{80,20},{50,40},{30,10}};

        int result = solution(k,dungeons);
        System.out.println(result);
    }
}
