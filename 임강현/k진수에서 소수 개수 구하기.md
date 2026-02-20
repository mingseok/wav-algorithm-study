### k진수에서 소수 개수 구하기 - 92335번
```JAVA
/**
* 진수 변환: Integer.toString(int n, int k) -> int 타입의 숫자 n을 k진수로 변환
* split("0+") 정규식 사용으로 연속된 0을 하나로 처리
* 1 이하는 소수 아님
* 2는 유일한 짝수 소수
* 2를 제외한 짝수는 소수 아님
* 3부터 √num 까지만 검사
* i는 2씩 증가 (홀수만 검사해서 소수판별 성능 최적화)
*/

import java.util.*;

class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        String str = Integer.toString(n, k);
        String[] numbers = str.split("0+");
        for (String number : numbers) {
            long num = Long.parseLong(number);
            if (isPrime(num)) answer++;
        }
        return answer;
    }
    private static boolean isPrime(long num) {
        if (num <= 1) return false;
        if (num == 2) return true;
        if (num % 2 == 0) return false;
        for (long i = 3; i * i <= num; i += 2) {
            if (num % i == 0) return false;
        }
        return true;
    }
}
```