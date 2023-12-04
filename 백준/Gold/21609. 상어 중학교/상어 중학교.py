from collections import deque


# 블록 그룹만들고 제거
def search_block_group():
    # 크기가 가장 큰 블록 그룹의 좌표, 점수, 무지개 블록 개수
    point = 0
    max_area_list = []
    max_rainbow = 0

    for color in range(1, m + 1):
        # 색깔이 달라질 때마다 방문 처리 초기화(무지개블록)
        visited = [[0] * n for _ in range(n)]

        for x in range(n):
            for y in range(n):
                # 현재 색깔과 같고 방문 안했던 곳이면 탐색
                if board[x][y] == color and not visited[x][y]:
                    q = deque([(x, y)])
                    area_list = [(x, y)]
                    visited[x][y] = 1
                    rainbow = 0

                    while q:
                        cx, cy = q.popleft()

                        for d in range(4):
                            nx = cx + dx[d]
                            ny = cy + dy[d]

                            # 범위 안에 있고 방문한적 없는 현재 컬러거나 무지개 블록이면 합침
                            if 0 <= nx < n and 0 <= ny < n and not visited[nx][ny] and \
                                    (board[nx][ny] == color or board[nx][ny] == 0):
                                q.append((nx, ny))
                                area_list.append((nx, ny))
                                visited[nx][ny] = 1
                                # 무지개 블록이면
                                if board[nx][ny] == 0:
                                    rainbow += 1

                    # 블록그룹을 다 만들었다면 max값 갱신해줘야 하는지 체크
                    if (len(max_area_list) < len(area_list)) or\
                            (len(max_area_list) == len(area_list) and max_rainbow < rainbow) or\
                            (len(max_area_list) == len(area_list) and max_rainbow == rainbow and max_area_list[0][0] < area_list[0][0]) or\
                            (len(max_area_list) == len(area_list) and max_rainbow == rainbow and max_area_list[0][0] == area_list[0][0] and max_area_list[0][1] < area_list[0][1]):
                        max_area_list = area_list
                        max_rainbow = rainbow

    # 유효한 블록 그룹이면 점수계산
    if len(max_area_list) >= 2:
        point += len(max_area_list) * len(max_area_list)

        # 제거해주기
        for block in max_area_list:
            board[block[0]][block[1]] = -2

    return point


# 중력
def down():
    # 아래부터 1열씩 빈 공간 체크
    for y in range(n):
        # 빈 공간
        cnt = 0
        for x in range(n-1, -1, -1):
            if board[x][y] == -2:
                cnt += 1
            # 검은 블록은 중력의 영향을 안받으니까 초기화
            elif board[x][y] == -1:
                cnt = 0
            # 중력의 영향으로 위치 이동
            else:
                if cnt != 0:
                    board[x + cnt][y] = board[x][y]
                    board[x][y] = -2


# 반시계 방향
def rotate():
    temp = [[0] * n for _ in range(n)]

    # 반시계 방향 바꾼 판 만들기
    for x in range(n):
        for y in range(n):
            temp[n - 1 - y][x] = board[x][y]

    # 원본 바꿔주기
    for x in range(n):
        for y in range(n):
            board[x][y] = temp[x][y]


n, m = map(int, input().split())
board = [list(map(int, input().split())) for _ in range(n)]
dx = [-1, 0, 1, 0]
dy = [0, -1, 0, 1]
total_point = 0
'''
오토 플레이

1. 크기가 가장 큰 블록 그룹을 찾는다.
(그러한 블록 그룹이 여러 개라면 포함된 무지개 블록의 수가 가장 많은 블록 그룹,
그러한 블록도 여러개라면 기준 블록의 행이 가장 큰 것을,
그 것도 여러개이면 열이 가장 큰 것을 찾는다.)
2. 1에서 찾은 블록 그룹의 모든 블록을 제거한다. 블록 그룹에 포함된 블록의 수를 B라고 했을 때, B2점을 획득한다.
3. 격자에 중력이 작용한다.
4. 격자가 90도 반시계 방향으로 회전한다.
5. 다시 격자에 중력이 작용한다.

'''
while True:
    cur_point = search_block_group()

    # 종료 조건
    if cur_point == 0:
        break

    total_point += cur_point

    down()
    rotate()
    down()

print(total_point)