## Russian Doll Envelopes

- https://leetcode.com/problems/russian-doll-envelopes/description/

```java
import java.util.Arrays;

class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        if (envelopes == null || envelopes.length == 0) return 0;

        // (w asc, h desc)
        Arrays.sort(envelopes, (a, b) -> {
            if (a[0] != b[0]) return Integer.compare(a[0], b[0]);
            return Integer.compare(b[1], a[1]);
        });

        // LIS on heights (strictly increasing)
        int n = envelopes.length;
        int[] dp = new int[n];
        int len = 0;

        for (int i = 0; i < n; i++) {
            int h = envelopes[i][1];

            // lower_bound(dp[0..len), h)
            int idx = Arrays.binarySearch(dp, 0, len, h);
            if (idx < 0) idx = -(idx + 1);

            dp[idx] = h;
            if (idx == len) len++;
        }

        return len;
    }
}
```
