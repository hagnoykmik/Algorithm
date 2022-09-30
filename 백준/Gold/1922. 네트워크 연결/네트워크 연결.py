# find-set
def find_set(node):
    if node != parent[node]:
        parent[node] = find_set(parent[node])
    return parent[node]


n = int(input())
m = int(input())
edges = []
parent = list(range(n + 1))   # make-set
for _ in range(m):
    a, b, c = map(int, input().split())
    edges.append((c, a, b))
edges.sort()

costs = 0   # 총 비용 (최소 비용)
counts = 0  # n-1이 되면 멈춰라

for cost, x, y in edges:
    # print(cost, x, y)
    x_root, y_root = find_set(x), find_set(y)

    # union
    if x_root != y_root:
        parent[y_root] = x_root

        costs += cost
        counts += 1
        if counts >= n - 1:
            break

print(costs)
