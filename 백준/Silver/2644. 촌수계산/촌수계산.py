from collections import deque
import sys
input = sys.stdin.readline

n = int(input())
qx, qy = map(int, input().split())
m = int(input())
relationship = [[] for _ in range(n + 1)] 
for _ in range(m):
    x, y = map(int, input().split()) # 부모->자식, 자식->부모 촌수 똑같으니까 양방향관계
    relationship[x].append(y)
    relationship[y].append(x)
visited = [False] * (n + 1)

# bfs
q = deque([(qx, 0)])

while q:
    x, r = q.popleft()
    visited[x] = True

    if x == qy:
        print(r)
        break

    for nx in relationship[x]:
        if not visited[nx]:
            visited[nx] = True
            q.append((nx, r + 1))
if x != qy:
    print(-1)