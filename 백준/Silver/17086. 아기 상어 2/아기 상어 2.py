from collections import deque
import sys
input = sys.stdin.readline

def bfs(x, y):
    visited = [[False] * m for _ in range(n)]
    q = deque([(x, y, 0)])
    visited[x][y] = True # 방문처리

    while q:
        x, y, cnt = q.popleft() # 현재 위치

        for i in range(8):
            nx = x + dx[i]
            ny = y + dy[i]

            if 0 <= nx < n and 0 <= ny < m and not visited[nx][ny]: # 갈 수 있는 범위
                if fishbowl[nx][ny] == 1:
                    return cnt + 1
                else:
                    q.append((nx, ny, cnt + 1))
                    visited[nx][ny] = True

                    
n, m = map(int, input().split())
fishbowl = [list(map(int, input().split())) for _ in range(n)]
distance = [[0] * m for _ in range(n)]

# 확인 방향
dx = [-1, 1, 0, 0, -1, 1, -1, 1]
dy = [0, 0, -1, 1, -1, 1, 1, -1]

for x in range(n):
    for y in range(m):
        if fishbowl[x][y] == 0 and not distance[x][y]:
            distance[x][y] = bfs(x, y)

print(max(map(max, distance)))