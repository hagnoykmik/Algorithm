from collections import deque
import sys
imput = sys.stdin.readline

a, p = map(int, input().split())
sequence = []

q = deque([(a)])

while q:
    num = q.popleft()

    # 중복되면 중단
    if num in sequence:
        print(sequence.index(num))
        break
    
    # 숫자 쪼개서 리스트에 담기
    split_num = list(map(int, str(num)))

    # P번 곱한 수
    next_num = list(map(lambda x: x ** p, split_num))
    q.append(sum(next_num))
    sequence.append(num)