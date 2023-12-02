'''
블록은 검은색 블록, 무지개 블록, 일반 블록이 있다.
일반 블록은 M가지 색상이 있고, 색은 M이하의 자연수로 표현한다.
검은색 블록은 -1,
무지개 블록은 0으로 표현한다.

|r1 - r2| + |c1 - c2| = 1을 만족하는 두 칸 (r1, c1)과 (r2, c2)를 인접한 칸
'''
from collections import deque
from copy import deepcopy


'''
블록만들기
1. 최소 2개이상
2. 일반블록 1개 이상, 일반 블록의 색은 모두 같아야 한다.
3. 검은색 블록은 포함되면 안 되고, 무지개 블록은 얼마나 들어있든 상관없다. 
4. 블록 그룹의 기준 블록은 무지개 블록이 아닌 블록 중에서 행의 번호가 가장 작은 블록,
   그러한 블록이 여러개면 열의 번호가 가장 작은 블록이다.
'''
def cal_point():
    point = 0        # 점수
    max_area = []    # 가장 큰 블록그룹의 좌표 위치
    max_rainbow = 0

    # 색깔별로 찾기
    for color in range(1, m + 1):
        visited = [[0] * n for _ in range(n)]

        for x in range(n):
            for y in range(n):
                if not visited[x][y] and board[x][y] == color:
                    rainbow = 0
                    q = deque([(x, y)])
                    area_list = [(x, y)]  # 기준 좌표(맨왼쪽 맨위)
                    visited[x][y] = 1

                    while q:
                        cx, cy = q.popleft()

                        for d in range(4):
                            nx = cx + dx[d]
                            ny = cy + dy[d]

                            if 0 <= nx < n and 0 <= ny < n and not visited[nx][ny] and (board[nx][ny] == color or board[nx][ny] == 0):
                                q.append((nx, ny))
                                area_list.append((nx, ny))
                                visited[nx][ny] = 1

                                # 무지개블록일때 count
                                if board[nx][ny] == 0:
                                    rainbow += 1

                    # 최대 값과 비교해서 갱신(그러한 블록 그룹이 여러 개라면 포함된 무지개 블록의 수가 가장 많은 블록 그룹, 그러한 블록도 여러개라면 기준 블록의 행이 가장 큰 것을, 그 것도 여러개이면 열이 가장 큰 것을 찾는다.)
                    if len(max_area) < len(area_list) \
                            or (len(max_area) == len(area_list) and max_rainbow < rainbow) \
                            or (len(max_area) == len(area_list) and max_rainbow == rainbow and max_area[0][0] < area_list[0][0]) \
                            or (len(max_area) == len(area_list) and max_rainbow == rainbow and max_area[0][0] == area_list[0][0] and max_area[0][1] < area_list[0][1]):
                        max_area = deepcopy(area_list)
                        max_rainbow = rainbow

    # 블록 그룹은 2개 이상
    if len(max_area) >= 2:
        point = len(max_area) * len(max_area)

        # 보드에 있는 블럭 삭제
        for area in max_area:
            x, y = area[0], area[1]
            board[x][y] = -2

    return point


def down():
    # 열마다 비교
    for y in range(n):
        blank = 0
        for x in range(n - 1, -1, -1): # 아래서부터 체크
            if board[x][y] == -2:
                blank += 1
            # 검은 블럭은 중력의 영향 받지 않음(블랭크 초기화)
            elif board[x][y] == -1:
                blank = 0
            # 아래로 내려주기
            else:
                if blank != 0:
                    board[x + blank][y] = board[x][y]
                    board[x][y] = -2


def rotate():
    global board
    temp = [[0] * n for _ in range(n)]

    for x in range(n):
        for y in range(n):
            temp[n - 1 - y][x] = board[x][y]

    for x in range(n):
        for y in range(n):
            board[x][y] = temp[x][y]


n, m = map(int, input().split()) # 한변의 크기, 색상의 개수
board = [list(map(int, input().split())) for _ in range(n)]
dx = [0, -1, 0, 1]
dy = [1, 0, -1, 0]
total_point = 0


# 오토모드
while True:
    '''
    1. 크기가 가장 큰 블록 그룹을 찾는다. 
    2. 1에서 찾은 블록 그룹의 모든 블록을 제거한다. 블록 그룹에 포함된 블록의 수를 B라고 했을 때, B2점을 획득한다.
    '''
    cur_point = cal_point()
    total_point += cur_point

    # 종료조건
    if cur_point == 0:
        break
    # 3. 격자에 중력이 작용한다.
    down()

    # 4. 격자가 90도 반시계 방향으로 회전한다.
    rotate()

    # 5. 다시 격자에 중력이 작용한다.
    down()


print(total_point)