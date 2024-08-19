package week_6.eunsoo;

/* 소수찾기
 * [입력] 숫자 문자열
 * [출력] 가능한 숫자 중 소수
 */

public class PGS_소수찾기 {
    //문자열 가능한 숫자 확인
    private static boolean isContain(int[] num, int k) {
        int[] temp = num.clone();
        while (k > 0) {
            if (temp[k % 10] == 0) return false;
            temp[k % 10]--;
            k /= 10;
        }
        return true;
    }

    //소수 판별
    public static boolean isPrime(int num){
        if (num < 2) return false; //2미만 X
        for(int i=2; i*i<=num; i++){ //2이상
            if(num % i == 0) return false; //나눠지면 X
        }
        return true;
    }

    public static int solution(String numbers) {
        int answer = 0;

        int[] num = new int[10];
        String[] split = numbers.split("");
        for (String s : split) {
            num[Integer.parseInt(s)]++;
        }

        for (int i = 2; i < 10000000; i++) {
            if (isPrime(i) && isContain(num, i)) {
                answer++;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        int answer = solution("17");
        System.out.println(answer);
    }
}
