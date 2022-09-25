
for tc in range(1, int(input())+ 1):
    n, k = map(int, input().split())
    board = [list(map(int, input().split())) for _ in range(n)]
    result = 0

    for r in range(n):
        cnt_w = 0       # 가로 개수
        for c in range(n):
            if board[r][c] == 1:
                cnt_w += 1
            else:
                if cnt_w == k:
                    result += 1
                cnt_w = 0
        if cnt_w == k:
            result += 1

    # 세로 탐색
    for r in range(n):
        cnt_h = 0       # 세로 개수
        for c in range(n):
            if board[c][r] == 1:
                cnt_h += 1
            else:
                if cnt_h == k:
                    result += 1
                cnt_h = 0
        if cnt_h == k:
            result += 1

    print(f'#{tc} {result}')
