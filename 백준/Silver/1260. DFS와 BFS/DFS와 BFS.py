import sys
from collections import deque

n, m, v = map(int, sys.stdin.readline().split())
graph = [[] for _ in range(n + 1)]
for _ in range(m):
    a, b = map(int, sys.stdin.readline().split())
    graph[a].append(b)
    graph[b].append(a)

# DFS
visited_dfs = [False] * (n + 1)
dfs_result = []

def dfs(v):
    dfs_result.append(v)
    visited_dfs[v] = True
    graph[v].sort()

    for nv in graph[v]:        # 연결되어 있는 정점번호
        if not visited_dfs[nv]:    # 방문한적 없으면
            dfs(nv)
    
    return dfs_result

print(*dfs(v))

# BFS
visited_bfs = [False] * (n + 1)
bfs_result = []

def bfs(v):
    q = deque([v])
    visited_bfs[v] = True

    while q:
        v = q.popleft()
        bfs_result.append(v)
        graph[v].sort()
        for nv in graph[v]:
            if not visited_bfs[nv]:
                visited_bfs[nv] = True
                q.append(nv)

    return bfs_result

print(*bfs(v))