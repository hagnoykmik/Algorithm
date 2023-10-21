from collections import deque
import sys
input = sys.stdin.readline

def clean(r, c, d):
    answer = 0
    q = deque([(r, c, d)])

    while q:
        r, c, d = q.popleft()

        # 1. 현재 칸이 아직 청소되지 않은 경우, 현재 칸을 청소한다.
        if room[r][c] == 0:
            room[r][c] = -1
            answer += 1

        for i in range(d, d - 4, -1):
            i = (i + 3) % 4
            nr = r + dr[i]
            nc = c + dc[i]

            # 3. 현재 칸의 주변 4칸 중 청소되지 않은 빈 칸이 있는 경우,
            # 3-1. 반시계 방향으로 90도 회전한다.
            # 3-2. 바라보는 방향을 기준으로 앞쪽 칸이 청소되지 않은 빈 칸인 경우 한 칸 전진한다.
            if room[nr][nc] == 0:
                q.append((nr, nc, i))
            # 3-3. 1번으로 돌아간다.
                break
            
        # 2. 현재 칸의 주변 4칸 중 청소되지 않은 빈 칸이 없는 경우,
        else:            
            # 2-1. 바라보는 방향을 유지한 채로 한 칸 후진할 수 있다면 한 칸 후진하고 1번으로 돌아간다.
            back = (d + 2) % 4 # 후진방향(반대방향)
            nr = r + dr[back]
            nc = c + dc[back]

            if room[nr][nc] != 1:
                q.append((nr, nc, d))

            # 2-2. 바라보는 방향의 뒤쪽 칸이 벽이라 후진할 수 없다면 작동을 멈춘다.
            else:
                break

    return answer


n, m = map(int, input().split())
robot_r, robot_c, d = map(int, input().split())
room = [list(map(int, input().split())) for _ in range(n)]
# 북(0), 동(1), 남(2), 서(3)
dr = [-1, 0, 1, 0]
dc = [0, 1, 0, -1]
answer = 0

print(clean(robot_r, robot_c, d))
