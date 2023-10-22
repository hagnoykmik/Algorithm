from collections import deque
import sys
input = sys.stdin.readline

# 토마토 익히기
def tomato(q):
    while q:
        i, r, c, day = q.popleft()

        # 다른 층 앞뒤
        for j in range(2):
            ni = i + di[j]

            if 0 <= ni < h and box[ni][r][c] == 0:
                q.append((ni, r, c, day + 1))
                box[ni][r][c] = 1 

        # 같은 층 인접한 곳
        for d in range(4):
            nr = r + dr[d]
            nc = c + dc[d]

            if 0 <= nr < n and 0 <= nc < m and box[i][nr][nc] == 0:
                q.append((i, nr, nc, day + 1))
                box[i][nr][nc] = 1

    return day

m, n, h = map(int, input().split())
box = []
for _ in range(h):
    box.append([list(map(int, input().split())) for _ in range(n)])
q = deque([])
di = [-1, 1]
dr = [-1, 1, 0, 0]
dc = [0, 0, -1, 1]

for i in range(h):
    for r in range(n):
        for c in range(m):
            if box[i][r][c] == 1:
                q.append((i, r, c, 0))

# 익은 토마토가 없으면 -1 출력
if not q:
    print(-1)

else:
    result = tomato(q)

    unripe_tomato = 0
    # 안익은 토마토가 있으면 -1 출력
    for f in range(h):
        for idx, line in enumerate(box[f]):
            # 안익은 토마토가 있으면
            if line.count(0) > 0:
                unripe_tomato += 1
                break # 탈출
    # 탈출해서 안익은 토마토가 있으면 -1 출력
    if unripe_tomato > 0:
        print(-1)
    # for문 정상적으로 다 돌았으면 며칠걸렸는지 출력
    else:
        print(result)
