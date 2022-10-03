
def search(x, y, i, player):
    if board[x][y] == player:
        check.append((board[x][y], x, y))
        return
    
    check.append((board[x][y], x, y))
    nx = x + dx[i]
    ny = y + dy[i]

    if 0 <= nx < n and 0 <= ny < n and board[nx][ny] != 0:
        search(nx, ny, i, player)


# 상, 하, 좌, 우, 대각선들
dx = [-1, -1, -1, 0, 1, 1, 1, 0]
dy = [-1, 0, 1, 1, 1, 0, -1, -1]


t = int(input())
for tc in range(1, t + 1):
    n, m = map(int, input().split())

    # 게임판 초기 세팅
    board = [[0] * n for _ in range(n)]
    board[n // 2 - 1][n // 2 - 1] = 2
    board[n // 2 - 1][n // 2] = 1
    board[n // 2][n // 2 - 1] = 1
    board[n // 2][n // 2] = 2


    # 게임 시작
    for _ in range(m):
        x, y, player = map(int, input().split())

        # 범위안에 있고, 그 줄의 마지막에도 놓는 돌의 색이면 그 줄은 player의 색이 된다
        x, y = x - 1, y - 1   # 인덱스에 맞춰준다

        for i in range(8):
            check = [(player, x, y)]

            nx = x + dx[i]
            ny = y + dy[i]

            if 0 <= nx < n and 0 <= ny < n and board[nx][ny] != 0:
                search(nx, ny, i, player)

                # 검사
                if len(check) > 2 and check[0][0] == player and check[-1][0] == player:

                    # 색깔 바꿔주기
                    board[x][y] = player
                    for j in range(1, len(check) - 1):
                        board[check[j][1]][check[j][2]] = player

    white, black = 0, 0
    for p in range(n):
        for q in range(n):
            if board[p][q] == 1:
                black += 1
            elif board[p][q] == 2:
                white += 1

    print(f'#{tc} {black} {white}')