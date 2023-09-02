from collections import deque
import sys
input = sys.stdin.readline

# 총 층수, 지금있는 층, 면접장 위치, 위로, 아래로
f, s, g, u, d = map(int, input().split())
visited = [0] * (f + 1)
answer = "use the stairs"

# 이동 방향
direction = [u * 1, d * (-1)]

q = deque([(s, 0)]) # 지금 층 수, 버튼cnt
visited[s] = 1

while q:
    s, cnt = q.popleft()
    # 도착
    if s == g: 
        answer = cnt
        break
    # 이동
    for i in range(2):
        ns = s + direction[i]

        if 1 <= ns <= f and visited[ns] == 0:
            visited[ns] = 1
            q.append((ns, cnt + 1))
print(answer)