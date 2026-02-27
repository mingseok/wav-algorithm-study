## Multiply Strings

- https://leetcode.com/problems/multiply-strings/description/

```java
class Solution {
    public String multiply(String num1, String num2) {
        StringBuilder result = new StringBuilder();
        int[] acc = new int[num1.length() * num2.length() + 1];
        int num1Digit, num2Digit;

        for (int i = 0; i < num1.length(); i++) {
            num1Digit = num1.charAt(num1.length() - 1 - i) - '0';

            for (int j = 0; j < num2.length(); j++) {
                num2Digit = num2.charAt(num2.length() - 1 - j) - '0';
                acc[i + j] += num1Digit * num2Digit;
            }
        }

        for (int i = 0; i < acc.length; i++) {
            if (acc[i] >= 10) {
                acc[i + 1] += acc[i] / 10;
            }
            result.insert(0, acc[i] % 10);
        }

        while (result.charAt(0) == '0' && result.length() > 1) {
            result.deleteCharAt(0);
        }

        return result.toString();
    }
}
```
