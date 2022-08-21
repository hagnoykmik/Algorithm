# 델타와의 절댓값 누적합
t = 10

for tc in range(1, t+1):
    n = int(input())
    board = [list(map(int, input().split())) for _ in range(n)]
    sum_d = 0
    # 델타값 구하기(상좌하우)
    dx = [-1, 0, 1, 0]
    dy = [0, -1, 0, 1]

    for x in range(n):
        for y in range(n):
            for i in range(4):
                nx = x + dx[i]
                ny = y + dy[i]

    # 범위 설정
                if nx < 0 or nx >= n or ny < 0 or ny >= n:
                    continue

    # 절대값 구하기
                d = board[nx][ny] - board[x][y]

                if d < 0:
                    d = d * -1
                else:
                    d = d * 1
    # 절대값들의 누적합
                sum_d += d

    print(f'#{tc} {sum_d}')
