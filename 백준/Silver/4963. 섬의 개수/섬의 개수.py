import sys
sys.setrecursionlimit(10000)


def dfs(x, y):
    visited[x][y] = True

    for d in range(8):
        nx = x + dx[d]
        ny = y + dy[d]

        if 0 <= nx < h and 0 <= ny < w and not visited[nx][ny] and graph[nx][ny] == 1:
            dfs(nx, ny)


# 상하좌우 + 대각선
dx = [-1, 1, 0, 0, -1, -1, 1, 1]
dy = [0, 0, -1, 1, -1, 1, 1, -1]


while True:
    w, h = map(int, input().split())

    graph = [list(map(int, input().split())) for _ in range(h)]
    if w == 0 and h == 0:
        break

    visited = [[False] * w for _ in range(h)]

    cnt = 0
    # 행순회

    for r in range(h):
        for c in range(w):
            if graph[r][c] == 1 and not visited[r][c]:
                cnt += 1
                dfs(r, c)
    print(cnt)
