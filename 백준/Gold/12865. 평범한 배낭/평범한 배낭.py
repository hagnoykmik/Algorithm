import sys
input = sys.stdin.readline

n, k = map(int, input().split())
object_list = [(0, 0)]
for _ in range(n):
    w, v = map(int, input().split())
    object_list.append((w, v))

# 행 - 가방의 무게(1 ~ k), 열 - 물건의 개수(n) 
dp = [[0] * (k + 1) for _ in range(n + 1)]

for y in range(1, k + 1):
    for x in range(1, n + 1):
        # 현재 가치, 현재 무게
        value = object_list[x][1]
        weight = object_list[x][0]
        
        # 배낭에 넣을 수 없다면
        if y < object_list[x][0]:
            dp[x][y] = dp[x - 1][y]
        
        # 배낭에 넣을 수 있다면
        else:
            # dp[이전 물건][현재 무게], 현재 물건 가치 + dp[이전 물건][현재 무게 - 물건 무게(남은 무게)]
            dp[x][y] = max(dp[x - 1][y], value + dp[x - 1][y - weight])

print(dp[n][k])