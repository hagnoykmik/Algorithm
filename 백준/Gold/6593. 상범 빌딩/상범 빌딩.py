from collections import deque
import sys
input = sys.stdin.readline

# 탈출
def escape(start_f, start_r, start_c ):
        
    q = deque([(start_f, start_r, start_c, 0)])

    while q:
        f, r, c, time = q.popleft()

        # 동서남북
        for d in range(4):
            nr = r + dr[d]
            nc = c + dc[d]

            if 0 <= nr < R and 0 <= nc < C and not visited[f][nr][nc]: 
                # 탈출지점
                if building[f][nr][nc] == 'E':
                    return time + 1

                if building[f][nr][nc] == '.':
                    q.append((f, nr, nc, time + 1))
                    visited[f][nr][nc] = 1

        # 상하
        for h in range(2):
            nf = f + df[h]

            if 0 <= nf < L and not visited[nf][r][c]:
                # 탈출지점
                if building[nf][r][c] == 'E':
                    return time + 1

                if building[nf][r][c] == '.':
                    q.append((nf, r, c, time + 1))
                    visited[nf][r][c] = 1

    return "Trapped!"


df = [-1, 1]
dr = [-1, 1, 0, 0]
dc = [0, 0, -1, 1]

while True:
    L, R, C = map(int, input().split())
    # 종료조건
    if (L, R, C) == (0, 0, 0):
        break

    building = []
    visited = [[[0] * C for _ in range(R)] for _ in range(L)]
    start_f, start_r, start_c = 0, 0, 0


    # 층 입력받기
    for _ in range(L):
        floor = [list(input().strip()) for _ in range(R)]
        building.append(floor)
        input() # 각 층 사이에는 빈 줄이 있다


    # 상범이 위치 찾기
    for i in range(L):
        for j in range(R):
            for k in range(C):
                if building[i][j][k] == 'S':
                    start_f, start_r, start_c = i, j, k
                    break
        if (start_f, start_r, start_c) != (0, 0, 0): # 상범이 찾았으면 삼중 for문 탈출!
            break

    # 탈출하러가기
    result = escape(start_f, start_r, start_c)
    if result != 'Trapped!':
        print(f'Escaped in {result} minute(s).')
    else:
        print('Trapped!')