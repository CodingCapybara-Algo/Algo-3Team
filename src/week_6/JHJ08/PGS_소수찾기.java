package week_6.JHJ08;

import java.util.*;

public class PGS_소수찾기 {

    static Set<Integer> sets = new HashSet<>();

    static void perm(int cnt, int R, String [] data, String [] res, boolean [] v)
    {
        if(cnt == R)
        {
            StringBuilder tmp = new StringBuilder();
            for(int j=0; j<cnt; j++)
            {
                tmp.append(res[j]);
            }

            sets.add(Integer.parseInt(tmp.toString()));

            return;
        }

        for(int i=0; i<data.length; i++)
        {
            if(!v[i])
            {
                v[i] = true;
                res[cnt] = data[i];
                perm(cnt+1, R, data, res, v);
                v[i] = false;
            }
        }
    }

    static boolean isPrime(int num) {

        if (num <= 1) return false;

        if (num == 2) return true;  // 2는 소수

        if (num % 2 == 0) return false;  // 짝수는 소수가 아님

        for (int i = 3; i <= Math.sqrt(num); i += 2)
        {
            if (num % i == 0) return false;
        }

        return true;
    }

    static int solution(String numbers) {

        int answer = 0;

        // 1. 순열을 이용해서 numbers 문자열을 통해 만들 수 있는 숫자들을 sets에 저장
        String [] data = new String[numbers.length()];
        for(int i=0; i<numbers.length(); i++)
        {
            data[i] = String.valueOf(numbers.charAt(i));
        }

        for(int i=1; i<=numbers.length(); i++)
        {
            perm(0, i, data, new String[i], new boolean [numbers.length()]);
        }

        // 2. sets에 저장된 숫자들 확인
        for (int num : sets) {

            if(isPrime(num))
            {
                answer++;
            }
        }

        return answer;
    }

    public static void main (String[] args) {

        String numbers1 = "17";
        System.out.println(solution(numbers1));

        String numbers2 = "011";
        System.out.println(solution(numbers2));

    }

}
