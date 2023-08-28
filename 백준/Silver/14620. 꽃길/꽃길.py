from itertools import combinations as cb
import sys
input = sys.stdin.readline

# 꽃심을 곳 탐색
def check(f_list):
    visited = [] 
    total_cost = 0

    for x, y in f_list:
        visited.append((x, y))
        total_cost += flower_bed[x][y]

        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]

            if (nx, ny) not in visited:
                visited.append((nx, ny))
                total_cost += flower_bed[nx][ny]
            else:
                return # 종료
    return total_cost


n = int(input())
flower_bed = [list(map(int, input().split())) for _ in range(n)]
candidates = [(r, c) for r in range(1, n-1) for c in range(1, n-1)]
cost_list = set() # 비용 리스트

# 꽃이 만개했을 때
dx = [0, 0, -1, 1]
dy = [-1, 1, 0, 0]

# 전체 범위 중 위치 3개 보기(조합 사용)
for f_list in cb(candidates, 3):
    cost = check(f_list)
    # 중간에 종료된 경우가 아니라면 비용 리스트에 넣는다.
    if cost != None:
        cost_list.add(cost)
        
print(min(cost_list))