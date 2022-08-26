
t = int(input())

for tc in range(1, t + 1):
    puzzle = [list(map(int, input().split())) for _ in range(9)]

    result = 1     # 정상적인 스도쿠일 때 기본값
    # 행, 열 담기
    for i in range(9):
        col_check = [0] * 10
        row_check = [0] * 10
        for j in range(9):
            row_check[puzzle[i][j]] = 1   # 행
            col_check[puzzle[j][i]] = 1   # 열
        # 검사
        for n in range(1, 10):
            if col_check[n] != 1 or row_check[n] != 1:  # 하나씩만 담긴게 아니라면
                result = 0
                break

    # 3 x 3 구간 담기
    for r in range(3):
        for c in range(3):
            check = [0] * 10
            for k in range(3):
                for l in range(3):
                    check[puzzle[3*r+k][3*c+l]] = 1   # 확인만 하면 되니까 일차원 리스트에 넣는다
            # 검사
            for n in range(1, 10):
                if check[n] != 1:
                    result = 0
                    break

    print(f'#{tc} {result}')