from collections import deque
import sys
input = sys.stdin.readline

# 탈출
def escape(position):
    while position:
        x, y = position.popleft()
        
        # 지훈이는 미로의 가장자리에 접한 공간 살아남아서 갔을 때에만 탈출할 수 있다.
        if maze[x][y] == 'J' and not (1 <= x < r - 1 and 1 <= y < c - 1):
            return time[x][y] + 1
        
        # 이동
        for d in range(4):
            nx = x + dx[d]
            ny = y + dy[d]

            # 갈 수 있는 곳이면 이동
            if 0 <= nx < r and 0 <= ny < c and maze[nx][ny] != '#':
                # 지훈이가 안갔던 곳이면
                if maze[x][y] == 'J' and maze[nx][ny] == '.' and maze[nx][ny] != 'J': 
                    time[nx][ny] = time[x][y] + 1 # 걸리는 시간

                    
                    position.append((nx, ny))    
                    maze[nx][ny] = 'J'            # 방문처리
                
                # 불!이고 안갔던 곳이면
                if maze[x][y] == 'F' and maze[nx][ny] != 'F':
                    position.append((nx, ny))
                    maze[nx][ny] = 'F'

    return "IMPOSSIBLE"


r, c = map(int, input().split())
maze = [list(input().strip()) for _ in range(r)]
time = [[0] * c for _ in range(r)]
position = deque([])
dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]


# 지훈이의 위치와 불의 위치를 찾는다.
for i in range(r):
    for j in range(c):
        # 지훈이 먼저 넣기
        if maze[i][j] == 'J':
            # 바로 탈출 가능하면 탈출하기
            if not (1 <= i < r - 1 and 1 <= j < c - 1):
                print(1)
                exit(0)
            position.appendleft((i, j))
        elif maze[i][j] == 'F':
            position.append((i, j))

# 탈출하러가기
print(escape(position))