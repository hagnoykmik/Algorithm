from collections import deque
import sys
input = sys.stdin.readline

n, k = map(int, input().split())
visited = [False] * (100001)

q = deque([(n, 0)]) # 시작점, 걸린시간
visited[n] = True

if n == k:
    print(0)
else:
    while q:
        x, s = q.popleft()
        dx = [-1, 1, x] # 이동
        
        # 동생이 있는 위치에 가면 종료
        if x == k:
            break
        
        # 이동
        for i in range(len(dx)):
            nx = x + dx[i]
            
            if 0 <= nx <= 100000 and not visited[nx]:
                q.append((nx, s + 1))
                visited[nx] = True

    print(s)