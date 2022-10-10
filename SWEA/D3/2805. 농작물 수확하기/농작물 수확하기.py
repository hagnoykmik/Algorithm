t = int(input())
for tc in range(1, t + 1):
    n = int(input())
    farm = [list(map(int, input())) for _ in range(n)]
    sum_crops = 0

    m = n // 2
    # n개 더하기
    for i in range(m + 1):
        for j in range(m - i, m + i + 1):
            sum_crops += farm[i][j]

    for x in range(n - 1, m, -1):
        for y in range(m-(n-x-1), m+(n-x-1)+1):
            sum_crops += farm[x][y]

    print(f'#{tc} {sum_crops}')