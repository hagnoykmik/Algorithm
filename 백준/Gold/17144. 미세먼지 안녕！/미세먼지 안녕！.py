from collections import deque

# 0. 미세먼지 확인
def search():
    for r in range(R):
        for c in range(C):
            if room[r][c] != 0:
                # 공기청정기 위치
                if room[r][c] == -1:
                    cleaner.append((r, c))
                else:
                    dust_list.append((r, c, room[r][c]))
'''
미세먼지가 확산된다. 확산은 미세먼지가 있는 모든 칸에서 동시에 일어난다.
(r, c)에 있는 미세먼지는 인접한 네 방향으로 확산된다.
인접한 방향에 공기청정기가 있거나, 칸이 없으면 그 방향으로는 확산이 일어나지 않는다.
확산되는 양은 Ar,c/5이고 소수점은 버린다. 즉, ⌊Ar,c/5⌋이다.
(r, c)에 남은 미세먼지의 양은 Ar,c - ⌊Ar,c/5⌋×(확산된 방향의 개수) 이다.
'''
# 1. 미세먼지 확산
def diffusion():
    # 네방향
    dr = [-1, 1, 0, 0]
    dc = [0, 0, -1, 1]

    while dust_list:
        r, c, a = dust_list.popleft()
        cnt = 0

        # (r, c)에 있는 미세먼지는 인접한 네 방향으로 확산된다.
        for i in range(4):
            nr = r + dr[i]
            nc = c + dc[i]

            if 0 <= nr < R and 0 <= nc < C and room[nr][nc] != -1:
                # 확산되는 양은 Ar,c/5이고 소수점은 버린다. 즉, ⌊Ar,c/5⌋이다.
                room[nr][nc] += a // 5
                cnt += 1

        # (r, c)에 남은 미세먼지의 양은 Ar,c - ⌊Ar,c/5⌋×(확산된 방향의 개수) 이다.
        room[r][c] -= (a // 5) * cnt
        

# 2. 공기청정기 작동
'''공기청정기가 작동한다.
공기청정기에서는 바람이 나온다.
위쪽 공기청정기의 바람은 반시계방향으로 순환하고, 아래쪽 공기청정기의 바람은 시계방향으로 순환한다.
바람이 불면 미세먼지가 바람의 방향대로 모두 한 칸씩 이동한다.
공기청정기에서 부는 바람은 미세먼지가 없는 바람이고, 공기청정기로 들어간 미세먼지는 모두 정화된다.
'''
def  clean_up():
    # 반시계 방향
    up_r = [0, -1, 0, 1]
    up_c = [1, 0, -1, 0]
    d = 0

    cleaner_r, cleaner_c = cleaner[0]

    r, c = cleaner_r, 1
    previous = 0

    while True:
        # 종료 조건
        if (r, c) == (cleaner_r, cleaner_c):
            break

        nr = r + up_r[d]
        nc = c + up_c[d]

        # 범위를 넘어가면 방향바꾸기
        if 0 > nr or nr >= R or  0 > nc or nc >= C:
            d += 1
            continue

        # 자리 바꾸기
        room[r][c], previous = previous, room[r][c]

        r, c = nr, nc


def clean_down():
    # 반시계 방향
    down_r = [0, 1, 0, -1]
    down_c = [1, 0, -1, 0]
    d = 0

    cleaner_r, cleaner_c = cleaner[1]

    r, c = cleaner_r, 1
    previous = 0

    while True:
        # 종료 조건
        if (r, c) == (cleaner_r, cleaner_c):
            break

        nr = r + down_r[d]
        nc = c + down_c[d]

        # 범위를 넘어가면 방향바꾸기
        if 0 > nr or nr >= R or 0 > nc or nc >= C:
            d += 1
            continue

        # 자리 바꾸기
        room[r][c], previous = previous, room[r][c]

        r, c = nr, nc


R, C, T = map(int, input().split())
room = [list(map(int, input().split())) for _ in range(R)]
cleaner = []
dust_list = deque([])

for _ in range(T):
    # 0. 미세먼지 확인
    search()

    # 1. 미세먼지 확산
    diffusion()

    # 2. 공기청정기 작동
    clean_up()    # 위
    clean_down()  # 아래

answer = 0
for k in room:
    answer += sum(k)

print(answer + 2)