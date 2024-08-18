package week_6.hyewonbae;

import java.util.HashSet;

public class PGS_소수찾기 {
    // 중복 숫자 제거하기 위해 HashSet 사용
    static HashSet<Integer> set = new HashSet<>();
    static char[] arr;          // 입력된 숫자 문자열 저장
    static boolean[] visited;   // 방문처리 배열

    static int solution(String numbers) {
        arr = numbers.toCharArray();    // 문자 배열로 변환
        visited = new boolean[numbers.length()];    // 초기화

        recur("", 0);

        int count = 0;
        for (int num : set) {
            if (isPrime(num)) {
                count++;        // 소수인 경우 count 증가
            }
        }
        return count;
    }

    /**
     * 가능한 숫자 조합을 생성
     * @param str 현재까지 생성된 숫자 조합 문자열
     * @param index 현재 조합의 깊이
     * */
    static void recur(String str, int index) {
        if (!str.equals("")) {
            int num = Integer.parseInt(str);
            set.add(num);
//            System.out.println(set);
        }

        // 숫자 조각에 대해 순회
        for (int i = 0; i < arr.length; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            recur(str + arr[i], index + 1);
            visited[i] = false;
        }
    }

    /**
     * 소수인지 판별하는 메소드
     * @param num 소수 여부를 확인할 숫자
     * @return 소수인 경우 true, 아니면 false 반환
     * */
    static boolean isPrime(int num) {
        if (num <= 1) return false;
        for (int i = 2; i <= Math.sqrt(num); i++) {     // Math.sqrt(num) : 제곱근
            if (num % i == 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        // TEST CASE 1
        String numbers = "17";
        int result = solution(numbers);
        System.out.println(result); // 출력: 3 ("7", "17", "71" 세 개의 소수가 있음)
        // TEST CASE 2
//        String numbers = "011";
//        int result = solution(numbers);
//        System.out.println(result); // 출력: 2 ("11", "101" 두 개의 소수가 있음)
    }
}
