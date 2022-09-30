# find-set
def find_set(node):
    if node != parent[node]:
        parent[node] = find_set(parent[node])
    return parent[node]


n = int(input())
m = int(input())

# 인접 행렬의 인덱스 + 1
# make-set
parent = list(range(n + 1))

for x in range(n):
    adj_matrix = list(map(int, input().split()))
    for y in range(n):
        if adj_matrix[y] == 1:
            # 루트 노드 찾기
            x_root, y_root = find_set(x + 1), find_set(y + 1)

            # union
            if x_root != y_root:
                parent[y_root] = x_root


city_list = list(map(int, input().split()))
result = 'YES'
# print(parent) [0, 1, 1, 1]

for i in range(1, m):
    if find_set(city_list[0]) != find_set(city_list[i]):
        result = 'NO'
        break

print(result)