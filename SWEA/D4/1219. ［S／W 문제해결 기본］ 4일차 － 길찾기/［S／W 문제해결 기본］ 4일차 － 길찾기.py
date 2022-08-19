
def dfs(v):
    visited[v] = True

    for next_v in graph[v]:
        if not visited[next_v]:
            dfs(next_v)


for tc in range(1, 11):
    t, n = map(int, input().split())
    edges = list(map(int, input().split()))
    visited = [False] * 100
    graph = [[] for _ in range(100)]

    for i in range(0, len(edges), 2):
        v1, v2 = edges[i], edges[i + 1]
        graph[v1].append(v2)

    dfs(0)

    if visited[99]: #True면
        print(f'#{tc} 1')
    else:
        print(f'#{tc} 0')
