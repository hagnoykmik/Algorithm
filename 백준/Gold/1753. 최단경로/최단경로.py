# Dijkstra
def dijkstra(start):
    visited = [False] * (n + 1)
    visited[start] = True
    distance[start] = 0  # 자기 자신은 거리가 0이다

    # 인접한 경로들의 최단 경로로 distance 갱신
    # 서로 다른 두 정점 사이에 여러개의 간선이 존재할 수도 있음
    for e, w in graph[start]:
        if distance[e] > w:
            distance[e] = w

    # 시작 정점 이외의 나머지 점들의 최단 거리 구하기
    for _ in range(n - 1):
        min_distance = INF
        # 1번부터 돌면서 최단 거리 갱신
        for i in range(1, n + 1):
            if not visited[i] and distance[i] < min_distance:
                min_node = i
                min_distance = distance[i]

        # 정해졌으면 방문 처리
        visited[min_node] = True

        # min_node와 인접한 정점들의 distance를 최단 거리로 갱신
        for next_node, dist in graph[min_node]:
            new_dist = dist + distance[min_node]
            if new_dist < distance[next_node]:
                distance[next_node] = new_dist


n, m = map(int, input().split())
start = int(input())

graph = [[] for _ in range(n + 1)]
for _ in range(m):
    s, e, w = map(int, input().split())
    graph[s].append((e, w))

INF = 9999999
distance = [INF] * (n + 1)

dijkstra(start)

for i in range(1, n + 1):
    if distance[i] == INF:
        print('INF')
    else:
        print(distance[i])
