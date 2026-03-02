## Non-negative Integers without Consecutive Ones

- https://leetcode.com/problems/non-negative-integers-without-consecutive-ones/description/

```java
class Solution {
    public int findIntegers(int n) {
        // f[k] = 길이 k(하위 k비트)에서 연속된 1이 없는 이진 문자열 개수
        // f[0]=1(빈 문자열), f[1]=2(0,1)
        int[] f = new int[32];
        f[0] = 1;
        f[1] = 2;
        for (int i = 2; i < 32; i++) {
            f[i] = f[i - 1] + f[i - 2];
        }

        int ans = 0;
        int prevBit = 0;

        // int는 31비트(0~30)만 봐도 충분하지만 안전하게 30까지(1e9 < 2^30)
        for (int k = 30; k >= 0; k--) {
            int curBit = (n >> k) & 1;

            if (curBit == 1) {
                // 현재 비트를 0으로 두는 경우 + 아래 k비트는 어떤 유효한 패턴이든 가능
                ans += f[k];

                // 연속된 1 발견 -> n 이하에서 더 진행 불가 (n 자체 포함 X)
                if (prevBit == 1) {
                    return ans;
                }
            }

            prevBit = curBit;
        }

        // 끝까지 연속된 1이 없으면 n 자체도 포함
        return ans + 1;
    }
}
```
