'''
양 > 늑대 -> 양이 이긴다
울타리로 막히지 않은 영역에는 양과 늑대가 없다.
상하좌우만 이동 가능
'''
import sys
sys.setrecursionlimit(10**9)


def search(x, y, area):
    if ground[x][y] == 'k' or ground[x][y] == 'v':
        area.append(ground[x][y])
    ground[x][y] = 'x'

    # 울타리 내 탐색 시작
    for i in range(4):
        nx = x + dx[i]
        ny = y + dy[i]

        if 0 <= nx < r and 0 <= ny < c and not(ground[nx][ny] == '#' or ground[nx][ny] == 'x') :
            search(nx, ny, area)


dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]



r, c = map(int, input().split())
ground = [list(input()) for _ in range(r)]
# print(ground)
sheep = 0
wolf = 0

for x in range(r):
    for y in range(c):
        area = []
        if ground[x][y] == '#' or ground[x][y] == 'x':
            continue
        else:
            search(x, y, area)
            if area:
                if area.count('k') > area.count('v'):
                    sheep += area.count('k')
                else:
                    wolf += area.count('v')
            else:
                continue

print(sheep, wolf)