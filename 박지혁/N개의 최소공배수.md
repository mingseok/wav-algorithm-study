## N개의 최소공배수
## https://school.programmers.co.kr/learn/courses/30/lessons/12953?language=python3

```python
def solution(arr):
    answer = arr[0]

    for i in range(1, len(arr)):
        a = answer
        b = arr[i]

        while b != 0:
            r = a % b
            a = b
            b = r

        gcd = a

        answer = answer * arr[i] // gcd

    return answer
```

시간복잡도 : O(N)
