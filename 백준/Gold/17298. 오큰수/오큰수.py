from collections import deque
import sys
input = sys.stdin.readline

n = int(input())
sequence = list(map(int, input().split()))
stack = []
result = [] # 자신보다 큰 수 담는 리스트


# 진행방향 거꾸로 검사한다
for number in sequence[::-1]:
    # 자기보다 작으면 stack에서 제거
    while stack and stack[-1] <= number:
        stack.pop()

    # 자기 보다 큰 수 중 제일 왼쪽(위쪽)에 있는 수 담기
    if stack:
        result.append(stack[-1])
    else:
        result.append(-1)
    stack.append(number)

result.reverse() # 다시 진행방향으로 바꿔주기

print(*result)