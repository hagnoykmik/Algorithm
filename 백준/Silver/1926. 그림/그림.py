from collections import deque
import sys
input = sys.stdin.readline

def search(i, j):
    width = 0
    visited[i][j] = 1
    q = deque([(i, j)])

    while q:
        x, y = q.popleft()
        width += 1

        for d in range(4):
            nx = x + dx[d]
            ny = y + dy[d]
            # print(nx, ny)
            if 0 <= nx < n and 0 <= ny < m and not visited[nx][ny] and paper[nx][ny] == 1:
                q.append((nx, ny))
                visited[nx][ny] = 1
    
    return width



n, m = map(int, input().split())
paper = [list(map(int, input().split())) for _ in range(n)]
visited = [[0] * m for _ in range(n)]
dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]
cnt = 0
w_list = []


for i in range(n):
    for j in range(m):
        if paper[i][j] == 1 and not visited[i][j]:
            w_list.append(search(i, j))
            cnt += 1

if cnt > 0:
    print(cnt)
    print(max(w_list))
else:
    print(0)
    print(0)
