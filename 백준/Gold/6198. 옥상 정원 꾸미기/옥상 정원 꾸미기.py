import sys
input = sys.stdin.readline

n = int(input())
buildings = [int(input()) for _ in range(n)]
stack = []
check = 0

for building in buildings:
    # 자신을 볼 수 없는 자신보다 같거나 작으면 stack에서 빼준다.
    while stack and stack[-1] <= building:
        stack.pop()
    
    # stack에 자기 자신을 넣는다
    stack.append(building)
    # 자기자신을 볼 수 있는 빌딩 개수
    check += len(stack) - 1 # 자기 자신은 빼준다.

print(check)
