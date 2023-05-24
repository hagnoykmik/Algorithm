def dfs(v):
    visited[v] = True  # 방문처리
    stack = [v]   

    while stack:
        for next_v in graph[v]:         # 인접한 정점 다 방문처리
            if not visited[next_v]:     # 아직 방문안했으면
                stack.append(v)
                v = next_v
                visited[v] = True
                break
        else:                           # 더이상 방문할 곳이 없다면
            v = stack.pop()


n = int(input())
m = int(input())
graph = [[] for _ in range(n + 1)]
visited = [False] * (n + 1)

for i in range(m):
    v1, v2 = map(int, input().split())
    graph[v1].append(v2)
    graph[v2].append(v1)

dfs(1)
print(visited.count(True) - 1)