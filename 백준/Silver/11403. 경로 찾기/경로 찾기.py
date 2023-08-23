from collections import deque
import sys
input = sys.stdin.readline

n = int(input())
graph = [list(map(int, input().split())) for _ in range(n)]
route = [[] for _ in range(n + 1)]
for i in range(n):
    for j in range(n):
        if graph[i][j] == 1:
            route[i + 1].append(j + 1)

# 경로 찾기
def search(x):
    visited = [0] * (n)
    q = deque([x])

    while q:
        x = q.popleft()

        for num in route[x]:
            if visited[num - 1] == 0:
                q.append(num)
                visited[num - 1] = 1 # 첫 번째 시작하는 점을 안넣기 위해 여기서 넣는다.

    return visited

for x in range(n):
    print(*search(x + 1))
