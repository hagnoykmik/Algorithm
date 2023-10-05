'''
1. 아이디어
- 1번부터 친구들과의 관계 점수 매기기
- 제일 작은 점수 뽑기 때문에 backtracking으로 cut 해준다

2. 시간복잡도

3. 자료구조

'''
from collections import deque
import sys
input = sys.stdin.readline

# 친구 관계 찾기
def search(me):
    global min_score, result
    q = deque([(me, 0)])
    total_score = 0

    while q:
        person, score = q.popleft()
        total_score += score

        # 진행 중인데 이미 최소값을 넘었으면 멈춤
        if total_score > min_score:
            break
        
        # 점수 매기기 진행
        for friend in friends[person]:
            # 나 자신이면 pass
            if friend == me:
                continue

            # 아직 관계 점수 안매겼으면 진행
            if not relationship[me][friend]:
                q.append((friend, score + 1))
                relationship[me][friend] = score + 1

    # 최솟값 갱신
    if min_score > total_score:
        min_score = total_score
        result = me

n, m = map(int, input().split())
friends = [[] for _ in range(n + 1)]
for _ in range(m):
    a, b = map(int, input().split())
    friends[a].append(b)
    friends[b].append(a)
relationship = [[0] * (n + 1) for _ in range(n + 1)]
min_score = sys.maxsize
result = 0

# 1번부터 점수 매기기
for me in range(1, n + 1):
    search(me)
print(result)