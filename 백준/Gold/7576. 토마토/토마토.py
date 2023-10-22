from collections import deque
import sys
input = sys.stdin.readline

def tomato(q):
    while q:
        r, c, day = q.popleft()

        for i in range(4):
            nr = r + dr[i]
            nc = c + dc[i]

            # 이동가능한 범위이고 익지 않은 토마토라면
            if 0 <= nr < n and 0 <= nc < m and box[nr][nc] == 0:
                q.append((nr, nc, day + 1))
                box[nr][nc] = 1

    return day


m, n = map(int, input().split())
box = [list(map(int, input().split())) for _ in range(n)]
dr = [-1, 1, 0, 0]
dc = [0, 0, -1, 1]
q = deque([])


# 익은 토마토(1) 찾기
for r in range(n):
    for c in range(m):
        if box[r][c] == 1:
            q.append((r, c, 0))

if q:
    result = tomato(q)

    # q가 비어있으면 토마토 익힐 수 없으니까 바로 -1 출력
    for idx, line in enumerate(box):
        if line.count(0) > 0:
            print(-1)
            break
    # 아니라면 토마토 익히러 가기
    else:   
        print(result)
else:
    print(-1)