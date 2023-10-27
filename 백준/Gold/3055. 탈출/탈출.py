from collections import deque
import sys
input = sys.stdin.readline

# 이동
def move(q):
    while q:
        x, y = q.popleft()

        for d in range(4):
            nx = x + dx[d]
            ny = y + dy[d]

            if 0 <= nx < r and 0 <= ny < c:
                # 고슴도치일 때(물, 돌, 방문했던 곳 X)
                if tiddup_forest[x][y] == 'S':
                    if tiddup_forest[nx][ny] == 'D':
                        return visited[x][y] + 1
                    
                    elif tiddup_forest[nx][ny] != 'X' and tiddup_forest[nx][ny] != '*' and not visited[nx][ny]:
                        visited[nx][ny] = visited[x][y] + 1 # 방문처리 + 거리
                        tiddup_forest[nx][ny] = 'S'
                        q.append((nx, ny))
                
                # 물일 때(비버굴, 돌, 방문했던 곳 X)
                else:
                    if tiddup_forest[nx][ny] != 'D' and tiddup_forest[nx][ny] != 'X' and tiddup_forest[nx][ny] != '*':
                        tiddup_forest[nx][ny] = '*'          # 방문처리
                        q.append((nx, ny))
    
    return "KAKTUS"


r, c = map(int, input().split())
tiddup_forest = [list(input().strip()) for _ in range(r)]
q = deque([])
visited = [[0] * c for _ in range(r)] # 각 위치별 거리
dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

for i in range(r):
    for j in range(c):
        if tiddup_forest[i][j] == 'S':
            q.appendleft((i, j))
        elif tiddup_forest[i][j] =='*':
            q.append((i, j))

print(move(q))