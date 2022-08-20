# 0. 입력값 받기

board = [list(input()) for _ in range(8)]

# 1. 하얀칸에 말이 몇 개 인지 출력
cnt = 0

for r in range(8):
    for c in range(8):
        # r이 짝수일 땐 c가 짝수이면 하얀색
        if r % 2 == 0 and c % 2 == 0 and board[r][c] == 'F':
            cnt += 1
        # r이 홀수일 땐 c가 홀수이면 하얀색
        elif r % 2 and c % 2 and board[r][c] == 'F':
            cnt += 1

print(cnt)