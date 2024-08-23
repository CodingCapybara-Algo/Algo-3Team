package week_7.hyewonbae;

/**
 * 사전에 알파벳 모음 A E I O U 만 사용하여 길이 5이하의 단어
 * A AA ... UUUUU
 * return 주어진 단어가 몇 번째 단어인지
 * */

import java.util.*;

public class PGS_모음사전 {
    // 단어 목록을 저장할 리스트
    static List<String> list;
    // 주어진 알파벳 모음
    static String [] words = {"A", "E", "I", "O", "U"};

    /**
     * 깊이 우선 탐색 (DFS)
     * @param str 현재까지 생성된 문자열
     * @param len 현재 문자열의 길이
     *
     * str:     len: 0
     * str: A    len: 1
     * str: AA    len: 2
     * str: AAA    len: 3
     * str: AAAA    len: 4
     * str: AAAAA    len: 5
     * str: AAAAE    len: 5
     * str: AAAAI    len: 5
     * str: AAAAO    len: 5
     * str: AAAAU    len: 5
     *
     * str: AAAE    len: 4
     * str: AAAEA    len: 5
     * str: AAAEE    len: 5
     * str: AAAEI    len: 5
     * str: AAAEO    len: 5
     * str: AAAEU    len: 5
     *
     * str: AAAI    len: 4
     * str: AAAIA    len: 5
     * str: AAAIE    len: 5
     * str: AAAII    len: 5
     * str: AAAIO    len: 5
     * str: AAAIU    len: 5
     * .
     * .
     * .
     *
     */
    static void dfs(String str, int len){
//        System.out.println("str: " + str + "    " + "len: " + len);
        list.add(str);
        if (len == 5){
            return;
        }
        for (int i = 0; i < 5; i++) {
            dfs(str+ words[i], len + 1);
        }
//        System.out.println("=============");
    }

    /**
     * 주어진 단어가 사전에서 몇 번째에 위치하는지 찾는 함수
     * @param word 찾고자 하는 단어
     * @return 단어가 사전에서 몇 번째 위치하는지의 인덱스
     */
    static int solution(String word){
        int answer=0;

        list = new ArrayList<>();

        dfs("", 0);

        int size = list.size();     //  단어 목록의 총 개수
//        System.out.println("size : " + size);

        // 리스트에서 위치 탐색
        for (int i = 0; i < size; i++) {
            if (list.get(i).equals(word)) {
                answer = i;
                break;
            }
        }
        return answer;
    }

    public static void main(String[] args) throws Exception {
        // TEST CASE 1
        String word = "AAAAE";          //6
        // TEST CASE 2
//        String word = "AAAE";         //10
        // TEST CASE 3
//        String word = "I";            //1563
        // TEST CASE 4
//        String word = "EIO";          //1189


        System.out.println(solution(word));

    }
}
