## K번째수(Java)
## https://school.programmers.co.kr/learn/courses/30/lessons/42748

```JAVA
import java.util.Arrays;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        
         for(int i = 0; i < commands.length; i++){
            int start = commands[i][0] - 1;
            int end = commands[i][1];
            int k = commands[i][2] - 1;
            int[] temp = new int[end - start];

            for(int j=start; j<end; j++){
                temp[j-start] = array[j];
            }
            
            Arrays.sort(temp);
            answer[i] = temp[k];
        }
        return answer;
    }
}
```
