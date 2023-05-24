def dfs(v):
    visited[v] = True
    stack = [v]

    while stack:
        v = stack.pop()
        for nx in graph[v]:
            if not visited[nx]:
                visited[nx] = True
                stack.append(nx)


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