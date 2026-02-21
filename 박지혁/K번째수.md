## K번째수
## https://school.programmers.co.kr/learn/courses/30/lessons/42748

```python
def solution(array, commands):
    answer = []
    new_array = []
    for command in commands:
        print(command)
        new_array = sorted(array[command[0]-1 : command[1]])
        answer.append(new_array[command[2]-1])
    return answer
```

파이썬의 정렬(Timsort)은 평균/최악 시간복잡도가 O(nlogn) 이다.

시간복잡도 : O(nlogn)
