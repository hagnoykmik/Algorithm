'''
1. 아이디어
- 자리배치 : 인접한 칸 (|r1 - r2| + |c1 - c2| = 1 -> 상하좌우)
    1. 그 자리가 비어있고 좋아하는 사람이 인접한 칸에 제일 많은 자리.
    2. 인접한 빈 칸이 제일 많아야 한다.

- 만족도 조사
    자리 배치 후에 인접한 곳에 좋아하는 학생이 앉았으면 점수
    (자리 찾으면서 못하는 이유가 후에 상황을 모르기 때문에)

2. 시간복잡도
  이중 for 문(자리 배치) : n * n = 20 * 20 = 400번 * 400명 = 160000
+ 이중 for 문(만족도 조사) : 400번


3. 자료 구조
- 자리배치도 : int[][]

'''
n = int(input())
seating_map = [[0] * n for _ in range(n)] # 자리 배치도
sum_score = 0
student_list = [[0] for _ in range(n ** 2 + 1)] # 나중 만족도 조사를 위함

# 인접한 자리(상하좌우)
dr = [-1, 1, 0, 0]
dc = [0, 0, -1, 1]


# 자리 배치 하기
def search_seat(num, like_list, seating_map):
    # 좋아하는 사람도 없고, 빈칸도 없을 때를 위해 기준값을 -1로 해준다.
    max_empty = -1
    max_like = -1
    # 앉을 수 있는 자리 (빈칸) 찾기
    for r in range(n):
        for c in range(n):
            # final_r, final_c = -1, -1
            empty = 0
            like = 0
            # 비어있으면 인접한 칸 탐색 시작
            if seating_map[r][c] == 0:

                for i in range(4):
                    nr = r + dr[i]
                    nc = c + dc[i]

                    # 인접한 곳에 좋아하는 애가 있니?
                    if 0 <= nr < n and 0 <= nc < n:
                        # 1. 좋아하는 애가 있어?
                        if seating_map[nr][nc] in like_list:
                            like += 1

                        # 빈칸이 몇개야?
                        if seating_map[nr][nc] == 0:
                            empty += 1
                        
    # 1번 조건. 주변 자리 다 탐색 하고나서 좋아하는 사람이 제일 많이 인접한 자리로 이동
                if max_like > like:
                    continue

                # 좋아하는 사람이 더 많을 때
                if max_like < like:
                    max_like = like
                    max_empty = empty
                    final_r, final_c = r, c

    # 2번 조건. 좋아하는 사람수가 같으면 빈칸 더 많은곳으로 이동
                elif max_like == like and max_empty < empty:
                    max_like = like
                    max_empty = empty
                    final_r, final_c = r, c

    # 2번 조건. 좋아하는 사람 없으면 인접한 빈칸이 제일 많은 칸으로 이동
                elif max_like == 0:
                    if max_empty < empty: 
                        max_empty = empty
                        final_r, final_c = r, c

    # 탐색 다 하고 나서 자리에 앉히기
    seating_map[final_r][final_c] = num

    return seating_map


# 순서대로 자리에 앉기
for _ in range(n**2):
    num, *like_list = map(int, input().split())

    # 자리 찾으러 가자
    search_seat(num, like_list, seating_map)
    # 다 찾고 만족도 조사를 위해 리스트에 넣기
    student_list[num] = like_list

# 만족도 조사
satisfaction = 0

for x in range(n):
    for y in range(n):
        like_cnt = 0
        
        for j in range(4):
            nx = x + dr[j]
            ny = y + dc[j]

            # 범위 내에 있고 인접한 자리에 좋아하는 사람이 몇명 있는지 체크
            if 0 <= nx < n and 0 <= ny < n and seating_map[nx][ny] in student_list[seating_map[x][y]]:
                like_cnt += 1
        
        if like_cnt > 0:
            satisfaction += 10 ** (like_cnt - 1)

print(satisfaction)
