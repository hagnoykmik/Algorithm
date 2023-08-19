import sys
from collections import deque

n, m = map(int, sys.stdin.readline().split())
maze = [list(map(int, sys.stdin.readline().strip())) for _ in range(n)]
visited = [[False] * (m) for _ in range(n)]

# 이동방향
dx = [0, 0, -1, 1]
dy = [-1, 1, 0, 0]

# bfs (최소거리)
q = deque([(0, 0, 1)]) # x, y, cnt
visited[0][0] = True   # 방문처리

while q:
    x, y, cnt = q.popleft()
    
    # 도착이면 중단
    if x == n - 1 and y == m - 1:
            print(cnt)
            break
    
    for i in range(4):
        # 이동
        nx = x + dx[i]
        ny = y + dy[i]

        if 0 <= nx < n and 0 <= ny < m and not visited[nx][ny] and maze[nx][ny] == 1:
            q.append((nx, ny, cnt+1))
            visited[nx][ny] = True
