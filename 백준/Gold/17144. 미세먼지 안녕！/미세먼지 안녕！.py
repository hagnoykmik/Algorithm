from collections import deque


# 미세먼지와 공기청정기 위치 확인
def dust():
    for r in range(R):
        for c in range(C):
            if room[r][c] != 0:
                if room[r][c] == -1:
                    cleaner.append((r, c))
                else:
                    q.append((r, c, room[r][c]))


def diffusion():
    dr = [-1, 1, 0, 0]
    dc = [0, 0, -1, 1]

    sum_dust = [[0] * C for _ in range(R)]

    while q:
        r, c, a = q.popleft() # 미리 넣어놓은 값이라 값을 더해줘도 영향을 안 미침
        cnt = 0

        for i in range(4):
            nr = r + dr[i]
            nc = c + dc[i]

            # 인접한 방향에 미세먼지 확산 시키기
            if 0 <= nr < R and 0 <= nc < C and room[nr][nc] != -1:
                cnt += 1
                room[nr][nc] += a // 5

        # 다 돌았으면 확산시킨만큼 줄이기
        room[r][c] -= (a // 5) * cnt


# 위쪽 청소
def clean_up():
    up = [(0, 1), (-1, 0), (0, -1), (1, 0)]
    d = 0

    # 위쪽 공기청정기 위치
    r, c = cleaner[0]

    # 시작 위치(항상 1번 열에 설치)
    sr, sc = r, 1
    change = 0  # 바꿀값

    while True:
        # 종료조건
        if (sr, sc) == (r, c):
            break

        # 다음 위치
        nr = sr + up[d][0]
        nc = sc + up[d][1]

        # 다음 위치가 마지막 행, 열이면 방향바꾸기
        if nr < 0 or nr >= R or nc < 0 or nc >= C:
            d += 1
            continue

        # 자리바꾸기(swap)
        room[sr][sc], change = change, room[sr][sc]

        # 다음칸으로 이동
        sr, sc = nr, nc


# 아래쪽 청소
def clean_down():
    down = [(0, 1), (1, 0), (0, -1), (-1, 0)]
    d = 0

    r, c = cleaner[1]

    sr, sc = r, 1
    change = 0

    while True:
        # 종료 조건
        if (sr, sc) == (r, c):
            break

        # 다음 위치
        nr = sr + down[d][0]
        nc = sc + down[d][1]

        # 다음 위치가 마지막 행, 열이면 방향바꾸기
        if nr < 0 or nr >= R or nc < 0 or nc >= C:
            d += 1
            continue

        # 자리 바꾸기
        room[sr][sc], change = change, room[sr][sc]

        sr, sc = nr, nc


R, C, T = map(int, input().split())
room = [list(map(int, input().split())) for _ in range(R)]
cleaner = deque([])
q = deque([])


for _ in range(T):
    # 0. 미세먼지 위치 찾기
    dust()

    # 1. 미세먼지의 확산
    diffusion()

    # # 2. 공기청정기 작동
    clean_up()    # 위
    clean_down()  # 아래

# 3. 남은 먼지의 양 더해주기
answer = 0
for k in range(R):
    answer += sum(room[k])

print(answer + 2)

