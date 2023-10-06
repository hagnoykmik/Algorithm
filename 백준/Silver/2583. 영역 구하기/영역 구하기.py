
from collections import deque
import sys
imput = sys.stdin.readline

# 영역 넓이 구하기
def make_area(r, c):
    area = 0
    q = deque([(r, c)])
    paper[r][c] = 'x'
    
    while q:
        r, c = q.popleft()
        area += 1 # 넓이 +1 추가

        for i in range(4):
            nr = r + dr[i]
            nc = c + dc[i]

            if 0 <= nr < m and 0 <= nc < n and not paper[nr][nc]:
                q.append((nr, nc))
                paper[nr][nc] = 'x'
    
    return area


m, n, k = map(int, input().split())
paper = [[0] * n for _ in range(m)]
dr = [-1, 1, 0, 0]
dc = [0, 0, -1, 1]
area_list = []
cnt = 0

# 직사각형 그리기
for _ in range(k):
    x1, y1, x2, y2 = map(int, input().split())
    for y in range(x1, x2):
        for x in range(y1, y2):
            paper[x][y] = 'x'


# 영역 구하러 가기
for c in range(n):
    for r in range(m):
        if paper[r][c] == 0:
            result = make_area(r, c)
            area_list.append(result)
            cnt += 1
print(cnt)
print(*sorted(area_list))
