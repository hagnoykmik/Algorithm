from collections import deque
import sys
input = sys.stdin.readline

def bfs(start):
    q = deque([(start)])

    while q:
        node = q.popleft()

        for next_node in relationship[node]:
            if not visited[next_node]:
                q.append(next_node)
                visited[next_node] = True


n, m = map(int, input().split())
relationship = [[] for _ in range(n + 1)]
visited = [False] * (n + 1)
cnt = 0

for _ in range(m):
    u, v = map(int, input().split())
    relationship[u].append(v)
    relationship[v].append(u)


# 연결된 요소 찾기
for start in range(1, n + 1):
    if not visited[start]:
        bfs(start)
        cnt += 1

print(cnt)