
# 델타검색 (좌, 우, 위)
dx = [0, 0, -1]
dy = [-1, 1, 0]

for tc in range(1, 11):
    t = input()
    ladder = [list(map(int, input().split())) for _ in range(100)]

    # 마지막 지점 찾기
    for idx, num in enumerate(ladder[-1]):
        if num == 2:
            x, y = 99, idx
            break

    # 이제 거꾸로 올라가보자
    while x > 0:  # 0행까지 가보자고
        for i in range(3):
            nx = x + dx[i]
            ny = y + dy[i]

            # 범위 확인과 & 이동할 위치의 값이 1인지 확인
            if 0 <= nx < 100 and 0 <= ny < 100 and ladder[nx][ny] == 1:
                ladder[x][y] = 0  # 지나간 길은 표시해줌
                x, y = nx, ny

    # 출력
    print(f'#{tc} {y}')
