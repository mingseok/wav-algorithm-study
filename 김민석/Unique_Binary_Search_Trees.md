## Unique_Binary_Search_Trees

- https://leetcode.com/problems/unique-binary-search-trees/description/

```java
class Solution {
    int[] dp;

    public int numTrees(int n) {
        dp = new int[n + 1];
        dp[0] = 1;

        for (int i = 1; i <= n; i++) {//bottom-up dp
            for (int j = 0; j < i; j++) {
                dp[i] += dp[j] * dp[i - 1 - j];
            }
        }
        return dp[n];
    }
}
```
