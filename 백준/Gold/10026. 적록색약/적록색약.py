import sys
sys.setrecursionlimit(10000)


# 적녹색맹
def rgw(x, y, color):
    area[x][y] = 'O'

    for i in range(4):
        nx = x + dx[i]
        ny = y + dy[i]

        if 0 <= nx < n and 0 <= ny < n and area[nx][ny] == color:
            rgw(nx, ny, color)


# 일반인
def search(x, y, color):
    if color == 'B':
        area[x][y] = 0
    else:
        area[x][y] = 1

    for i in range(4):
        nx = x + dx[i]
        ny = y + dy[i]

        if 0 <= nx < n and 0 <= ny < n and area[nx][ny] == color:
            search(nx, ny, color)


# 상하좌우
dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]


n = int(input())
area = [list(input()) for _ in range(n)]
cnt_public = 0
cnt_red_green = 0

for x in range(n):
    for y in range(n):
        if area[x][y] == 0 or area[x][y] == 1:
            continue
        else:
            color = area[x][y]
            search(x, y, color)
            cnt_public += 1


for x in range(n):
    for y in range(n):
        if area[x][y] == 'O':
            continue
        else:
            color = area[x][y]
            rgw(x, y, color)
            cnt_red_green += 1


print(cnt_public, cnt_red_green)
