from collections import deque
import sys
input = sys.stdin.readline

n = int(input())
map = [list(map(int, input().strip())) for _ in range(n)]
cnt_list = []


# 단지구하기
def bfs(x, y):
    # 이동방향
    dx = [0, 0, -1, 1]
    dy = [-1, 1, 0, 0]

    q = deque([(x, y)]) # x, y
    map[x][y] = 0       # 방문한 집은 1->0으로 바꿔준다
    cnt = 0
    
    while q:
        x, y = q.popleft()
        cnt += 1

        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]

            if 0 <= nx < n and 0 <= ny < n and map[nx][ny] == 1:
                map[nx][ny] = 0
                q.append((nx, ny))
    return cnt


# 집 찾기
for x in range(n):
    for y in range(n):
        if map[x][y] == 1:
            cnt_list.append(bfs(x, y))


print(len(cnt_list))
for home in sorted(cnt_list):
    print(home)
