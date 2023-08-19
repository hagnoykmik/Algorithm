from collections import deque

n, m = map(int, input().split())
relationship = [[] for _ in range(n+1)]
for _ in range(m):
    a, b = map(int, input().split())
    relationship[b].append(a)

q = deque([])
cnt_list = [0] * (n + 1)
answer = []

for i in range(1, n + 1):
    visited = [False] * (n + 1)
    q.append(i)
    visited[i] = True
    hacked = 0

    while q:
        hacking = q.popleft()
        for trust_pc in relationship[hacking]:
            if not visited[trust_pc]:
                q.append(trust_pc)
                visited[trust_pc] = True
                cnt_list[i] += 1

for i, cnt in enumerate(cnt_list):
    if cnt == max(cnt_list):
        answer.append(i)

print(*answer)
