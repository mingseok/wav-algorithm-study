### OX퀴즈(Java)
```JAVA
/**
* OX퀴즈(Java)
* 덧셈, 뺄셈 수식들이 'X [연산자] Y = Z' 형태로 들어있는 문자열 배열 quiz가 매개변수로 주어집니다. 
* 수식이 옳다면 "O"를 틀리다면 "X"를 순서대로 담은 배열을 return
*/

class Solution {
    public String[] solution(String[] quiz) {

        String[] answer = new String[quiz.length];
        int result;
        
        for(int i = 0; i < quiz.length; i++) {

            // quiz 형식: "숫자 연산자 숫자 = 결과"
            String text = quiz[i];   
            String[] split_text = text.split(" "); 
            
            int a = Integer.parseInt(split_text[0]);
            int b = Integer.parseInt(split_text[2]);
            int c = Integer.parseInt(split_text[4]);
            
            result = split_text[1].equals("+") ? a + b : a - b;
            answer[i] = result == (c) ? "O" : "X";
           
    }
        
        return answer;
    }
}

```