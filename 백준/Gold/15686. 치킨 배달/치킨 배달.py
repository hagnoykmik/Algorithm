'''
1. 아이디어
- 치킨집 중에서 m개씩 뽑는다(조합)
- 집에서 출발했을 때 조합리스트내에 최단거리에 있는 최단 거리 치킨집을 발견하면 거리를 구하고 중단(bfs)

2. 시간복잡도

3. 자료구조
- bfs : queue
- 지도 : int[][]
'''

from collections import deque
from itertools import combinations
import sys
input = sys.stdin.readline

n, m = map(int, input().split())
city_map = [list(map(int, input().split())) for _ in range(n)]


# 조합별로 집에서 제일 가까운 치킨집 탐색
def search(store, home_list):
    total_distance = 0
    # 집 한개당 조합 안에 있는 가게중에 가장 가까운 거리만 저장해서 거리 더해준다
    for home in home_list:
        min_distance = 10000000
        r, c = home # 집 좌표
        for s in store:
            nr, nc = s # 치킨집 좌표
            distance = abs(nr - r) + abs(nc - c)
            # 최단거리 저장
            min_distance = min(min_distance, distance)
        total_distance += min_distance
    return total_distance # 최단거리


# 치킨집, 집 좌표 구하기
store_list = []
home_list = []
for x in range(n):
    for y in range(n):
        # 치킨집이면 치킨집 리스트에 추가
        if city_map[x][y] == 2:
            store_list.append((x, y))
        # 집이면 집 리스트에 추가
        elif city_map[x][y] == 1:
            home_list.append((x, y))

answer = 100000000000
# 치킨집중에 m개 선택(조합)
for store in list(combinations(store_list, m)): # 리스트에 안담고 그냥하면 메모리 초과
    answer = min(answer, search(store, home_list))

print(answer)

