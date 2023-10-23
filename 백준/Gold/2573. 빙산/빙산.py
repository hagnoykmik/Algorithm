from collections import deque
import sys
input = sys.stdin.readline

# 빙산 개수 체크
def check_iceburg(n, m, visited):
    global cnt
    for x in range(n):
        for y in range(m):
            if sea[x][y] != 0 and visited[x][y] != 1:
                count_iceberg(x, y)
                cnt += 1

# 빙산 개수 + 바다와 닿은 면 개수 체크
def count_iceberg(x, y):
    global iceburg_list
    q.append((x, y))
    visited[x][y] = 1

    while q:
        x, y = q.popleft()
        melting_cnt = 0    # 바다에 닿은 면 개수

        # 인접한 면 체크
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]

            if 0 <= nx < n and 0 <= ny < m and not visited[nx][ny]:
                # 빙산이면 q에 담아주기
                if sea[nx][ny] != 0:
                    q.append((nx, ny))
                    visited[nx][ny] = 1
                # 바다(0)이면 닿는 면 체크
                else:
                    melting_cnt += 1
        
        # 빙산 리스트에 담기
        iceburg_list.append((x, y, melting_cnt)) 


# 녹을 수 있는 면 체크
def melt(iceburg_list):
    # 빙산 리스트를 돌면서 바다가 닿은 면 만큼 녹여주기
    while iceburg_list:
        x, y, cnt = iceburg_list.popleft()

        sea[x][y] -= cnt

        if sea[x][y] < 0:
            sea[x][y] = 0


n, m = map(int, input().split())
sea = [list(map(int, input().split())) for _ in range(n)]
dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]
year = 0
q = deque([])

while True:
    # 1년이 지나면 초기화 해줘야함
    cnt = 0           # 빙산 개수
    iceburg_list = deque([]) # 빙산 리스트 담을 리스트
    visited = [[0] * m for _ in range(n)] # 카운트 하기전에 매번 초기화

    # 빙산 개수 체크하기
    check_iceburg(n, m, visited)

    # 빙산이 2개 이상되면 종료
    if cnt >= 2:
        print(year)
        break

    # 그냥 다 녹았으면 0 출력
    if cnt == 0:
        print(0)
        break
    
    # 녹이기
    melt(iceburg_list)

    # 시간 더해주기
    year += 1

