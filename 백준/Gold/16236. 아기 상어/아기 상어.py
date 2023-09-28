'''
1. 아이디어
엄마 상어에게 도움을 요청하지 않고 물고기를 잡아먹을 수 있는 시간

    - 이동
    이중포문으로 완전 탐색하면서 물고기의 위치 파악
    상어 위치에서 탐색 -> dfs(visited 사용) 
    거리가 가장 가까운 가까운 -> 탐색할 때 거리도 잰다
    자신보다 큰 물고기는 못지나간다...->?
    가장 가까운 물고기부터 먹는다 -> 먹을 때마다 다시 물고기 search

    - 먹기
    자신의 크기(2)와 같은 수의 물고기를 먹을 때마다 크기 +1 
    먹으면 칸 빈칸

2. 시간복잡도
- 물고기 위치 찾기 : 이중 for문 = n * n = 20 * 20 
- 물고기 잡아먹기 : deque O(1)

3. 자료 구조

'''
from collections import deque
import sys
input = sys.stdin.readline


# 잡아 먹을 수 있는 물고기 위치 찾기(현재 상어 위치, 상어크기)
def search_fish(shark_r, shark_c, shark_size):
    fish_list = set() # 먹을 수 있는 물고기(중복x)
    visited = []

    dr = [-1, 1, 0, 0]
    dc = [0, 0, -1, 1]

    q = deque([(shark_r, shark_c, 0)])

    while q:
        r, c, d = q.popleft()

        # 상하좌우 탐색    
        for i in range(4):
            nr = r + dr[i]
            nc = c + dc[i]

            # 이동가능 범위이고 이동가능한 사이즈, 방문한 적이 없으면 지나간다.    
            if 0 <= nr < n and 0 <= nc < n and space[nr][nc] <= shark_size and (nr, nc) not in visited:
                q.append((nr, nc, d + 1))
                visited.append((nr, nc))
                
                # 먹을 수 있으면 리스트에 넣는다.
                if 0 < space[nr][nc] < shark_size:
                    fish_list.add((nr, nc, d + 1))

    # 탐색끝나고 가까운 순, 행, 열 순으로 정렬
    fish_list = list(fish_list)
    fish_list.sort(key=lambda x: (x[2], x[0], x[1]))
    # print(fish_list)
    if not fish_list:
        return 0

    return fish_list[0] # 이동할 위치 반환



# 입력값 받기
n = int(input())
space = [list(map(int, input().split())) for _ in range(n)]
shark_size = 2 
ate_count = 0
total_time = 0

# 크기별 물고기 위치 찾기
fish_dict = {s:[] for s in range(1, 7)}

for fish_r in range(n):
    for fish_c in range(n):

        # 아기상어 위치 찾기
        if space[fish_r][fish_c] == 9:
            shark_r, shark_c = fish_r, fish_c

        # 물고기 위치 저장
        elif 0 < space[fish_r][fish_c]:
            fish_dict[space[fish_r][fish_c]].append((fish_r, fish_c))


# 잡아먹을 수 있는 물고기 찾으러 가기
space[shark_r][shark_c] = 0
while 1:
    fish = search_fish(shark_r, shark_c, shark_size)
    # print(fish)
    # 먹을 수 있는 물고기가 없으면 종료
    if fish == 0:
        break

    shark_r, shark_c = fish[0], fish[1] # 현재 상어 위치 갱신
    space[shark_r][shark_c] = 0 # 잡아먹었으면 0 처리
    ate_count += 1
    total_time += fish[2]

    # 자신의 크기만큼 잡아먹었으면 크기 +1
    if ate_count == shark_size:
        shark_size += 1
        ate_count = 0
print(total_time)