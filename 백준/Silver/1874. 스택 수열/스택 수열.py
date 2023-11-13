from collections import deque
import sys
input = sys.stdin.readline

n = int(input())
p = deque([]) # 만들어야하는 수열
for _ in range(n):
    p.append(int(input()))

stack = []
result = []

for number in range(1, n + 1):
    stack.append(number)
    result.append("+")

    # 스택에 넣은 수가 수열에 필요한 수면 뽑기
    while stack and stack[-1] == p[0]:
        stack.pop()
        p.popleft()
        result.append("-")

# 다 돌았는데도 완성 못했을 때 NO 출력
if stack:
    print("NO")
else:        
    for r in result:
        print(r)