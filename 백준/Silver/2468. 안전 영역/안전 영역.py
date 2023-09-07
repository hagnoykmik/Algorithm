'''
1. 아이디어
- 높이에 따라 안전영역이 몇 개 생기는지 체크(bfs)
- 높이는 1부터 지도의 최대 높이까지(for문)

2. 시간복잡도
삼중for문 : 100 * 100 * 100 = 100만

3. 자료구조
- 그래프 : int[][]
- 잠기는지 여부 : bool[][] (0,1)
- queue : bfs
'''
from collections import deque
import sys
input = sys.stdin.readline

# bfs
def bfs(safe_area):
    cnt = 0
    # 방향
    dc = [-1, 1, 0, 0]
    dr = [0, 0, -1, 1]

    q = deque([]) # 같은 구역을 담을 q
    for c in range(n):
        for r in range(n):
            if safe_area[c][r] == 1:
                q.append((c, r))
                safe_area[c][r] = 0

                while q:
                    curent_c, curent_r = q.popleft()

                    for k in range(4):
                        nc = curent_c + dc[k]
                        nr = curent_r + dr[k]

                        if 0 <= nc < n and 0 <= nr < n and safe_area[nc][nr]:
                            q.append((nc, nr))
                            safe_area[nc][nr] = 0
                
                cnt += 1
    return cnt


n = int(input())
area = [list(map(int, input().split())) for _ in range(n)]
m = max(map(max, area))  # 빗물의 최대 높이
safe_cnt = 0                 # 안전영역의 최대 개수

for i in range(0, m + 1):    # 아무지역도 물에 잠기지 않을 수도 있다.
    safe_area = [[1] * n for _ in range(n)] # 안전영역 여부

    for x in range(n):
        for y in range(n):
            if area[x][y] <= i:
                safe_area[x][y] = 0 # 물에 잠기는 영역
    safe_cnt = max(safe_cnt, bfs(safe_area))
    
print(safe_cnt)
