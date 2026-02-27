## JadenCase 문자열 만들기(Java)
## https://school.programmers.co.kr/learn/courses/30/lessons/12951


```JAVA

class Solution {
    public String solution(String s) {
    
        boolean isFirst = true;
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ' ') {
                sb.append(c);
                isFirst = true;
            }
            else {
                if (isFirst) {
                    c = Character.toUpperCase(c);
                } else {
                    c = Character.toLowerCase(c);
                }
                sb.append(c);
                isFirst = false;
            }
        }
        return sb.toString();
    }
}

```

시간복잡도 : O(n)
