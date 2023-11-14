import sys
input = sys.stdin.readline

n = int(input())
towers = [(i + 1, t) for i, t in enumerate(map(int, input().split()))]
stack = [towers[0]]
result = [0]

for j in range(1, n):
    tower = towers[j][1]
    razer = 0

    # 비교할 대상이 있으면
    while stack: 
        # 왼쪽에 있는 탑이 나보다 작으면 쓸모없어지니까 없앤다
        if tower > stack[-1][1]:
            stack.pop() 
        
        # 나보다 크면 레이저 수신 가능
        else:
            razer = stack[-1][0]
            break
        
    stack.append((j + 1, tower))
    result.append(razer)

print(*result)

