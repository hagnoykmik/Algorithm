# 회전
def rotate():
    for i in range(min(n, m) // 2):
        d = 0
        switch_value = board[i][i]
        x, y = i, i
        wall_x = n - i
        wall_y = m - i
        while True:

            nx = x + dx[d]
            ny = y + dy[d]

            # 범위가 벗어나면
            if nx < i or nx >= wall_x or ny < i or ny >= wall_y:
                d += 1
                continue

            board[nx][ny], switch_value = switch_value, board[nx][ny]

            x, y = nx, ny

            # 종료 조건
            if (x, y) == (i, i):
                break
    # print(board)


n, m, r = map(int, input().split())
board = [list(map(int, input().split())) for _ in range(n)]

dx = [1, 0, -1, 0]
dy = [0, 1, 0, -1]
d = 0


for _ in range(r):
    rotate()

for k in range(n):
    print(*board[k])
