from collections import deque
import sys
input = sys.stdin.readline

# 물은 매 분마다 비어있는 칸으로 확장한다. (X, D)는 이동 불가능.
def water(water_list, w_cnt):

    # 물의 개수만큼만 물이 찰 예정인 칸 조사한다.
    while w_cnt > 0:
        w_cnt -= 1
        x, y = water_list.popleft()
        tiddup_forest[x][y] = '*'

        for d in range(4):
            nx = x + dx[d]
            ny = y + dy[d]

            if 0 <= nx < r and 0 <= ny < c and tiddup_forest[nx][ny] != 'D' and tiddup_forest[nx][ny] != 'X' and not visited[nx][ny]:
                water_list.append((nx, ny))
                visited[nx][ny] = 1
    
    return water_list


# 고슴도치는 인접한 네칸 중 하나로 이동할 수 있다. (*, X)는 이동 불가능.
# + 물이 찰 예정인 칸으로 이동할 수 없다.
def gosumdochi(move_list, move_cnt):
    global result

    while move_cnt > 0:
        move_cnt -= 1
        x, y, time = move_list.popleft()

        # 이미 물이 찬 지역이면 없던걸로 한다
        if tiddup_forest[x][y] == '*':
            continue
        
        for d in range(4):
            nx = x + dx[d]
            ny = y + dy[d]

            if 0 <= nx < r and 0 <= ny < c:
                if tiddup_forest[nx][ny] == 'D':
                    print(time + 1)
                    exit(0)
                
                elif tiddup_forest[nx][ny] != 'X' and tiddup_forest[nx][ny] != '*' and tiddup_forest[nx][ny] != 'S' and tiddup_forest[nx][ny] not in water_list:
                    move_list.append((nx, ny, time + 1))
                    tiddup_forest[nx][ny] = 'S'
                    visited[nx][ny] = 1


r, c = map(int, input().split())
tiddup_forest = [list(input().strip()) for _ in range(r)]
move_list = deque([])
water_list = deque([])
dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]
visited = [[0] * c for _ in range(r)]

# 고슴도치 위치와 물의 위치 찾기
for i in range(r):
    for j in range(c):
        if tiddup_forest[i][j] == 'S':
            move_list.append((i, j, 0))
        elif tiddup_forest[i][j] =='*':
            water_list.append((i, j))


while move_list:
    # 이동하기 전에 물이 찰 공간 체크
    w_cnt = len(water_list)

    if water_list:
        water(water_list, w_cnt)

    # 고슴도치 이동
    move_cnt = len(move_list)
    gosumdochi(move_list, move_cnt)


print("KAKTUS")
