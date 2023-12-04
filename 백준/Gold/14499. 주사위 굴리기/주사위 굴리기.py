# 주사위 굴리기
def move_dice(d):
    ndice = [0] * 6

    # 동쪽
    if d == 1:
        ndice[0] = dice[0]
        ndice[1] = dice[4]
        ndice[2] = dice[2]
        ndice[3] = dice[5]
        ndice[4] = dice[3]
        ndice[5] = dice[1]
    # 서쪽
    elif d == 2:
        ndice[0] = dice[0]
        ndice[1] = dice[5]
        ndice[2] = dice[2]
        ndice[3] = dice[4]
        ndice[4] = dice[1]
        ndice[5] = dice[3]
    # 북쪽
    elif d == 3:
        ndice[0] = dice[1]
        ndice[1] = dice[2]
        ndice[2] = dice[3]
        ndice[3] = dice[0]
        ndice[4] = dice[4]
        ndice[5] = dice[5]
    # 남쪽
    else:
        ndice[0] = dice[3]
        ndice[1] = dice[0]
        ndice[2] = dice[1]
        ndice[3] = dice[2]
        ndice[4] = dice[4]
        ndice[5] = dice[5]

    # 원래 주사위에 복사
    for i in range(6):
        dice[i] = ndice[i]


n, m, x, y, k = map(int, input().split())
board = [list(map(int, input().split())) for _ in range(n)]
command_list = list(map(int, input().split()))
dice = [0] * 6
dx = [0, 0, 0, -1, 1]
dy = [0, 1, -1, 0, 0]

for d in command_list:
    nx = x + dx[d]
    ny = y + dy[d]

    # 만약 바깥으로 이동시키려고 하는 경우에는 해당 명령을 무시
    if 0 > nx or nx >= n or 0 > ny or ny >= m:
        continue

    # 주사위 굴리기
    move_dice(d)

    # 칸이 0이면 주사위 바닥 복사
    if board[nx][ny] == 0:
        board[nx][ny] = dice[3] # 바닥
    # 아니면 칸 숫자를 주사위바닥에 복사
    else:
        dice[3] = board[nx][ny]
        board[nx][ny] = 0

    # 주사위 상단 숫자 출력
    print(dice[1])

    x, y = nx, ny
