import sys
sys.setrecursionlimit(10000)


def dfs(x, y):
    visited[x][y] = True

    for d in range(4):
        nx = x + dx[d]
        ny = y + dy[d]

        # 범위를 안 벗어나고 & 값이 1이고 & 방문안했으면 이동
        if 0 <= nx < m and 0 <= ny < n and ground[nx][ny] == 1 and not visited[nx][ny]:
            dfs(nx, ny)


# 상하좌우
dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

t = int(input())
for tc in range(1, t+1):
    m, n, k = map(int, input().split())  # 행, 열, 배추위치개수

# 배추밭 만들기
    ground = [[0] * n for _ in range(m)]
    for i in range(k):
        x, y = map(int, input().split())
        ground[x][y] = 1  # 배추가 심어져 있는 위치는 1로 바꿔준다

# 방문 처리 리스트 만들기
    visited = [[False] * n for _ in range(m)]
    cnt = 0  # 지렁이 셀 변수

# 행순회를 하면서 1이면서 False인 곳을 탐색
    for r in range(m):
        for c in range(n):
            if ground[r][c] == 1 and not visited[r][c]:
                cnt += 1
                dfs(r, c)

    print(cnt)