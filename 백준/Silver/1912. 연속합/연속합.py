import sys
input = sys.stdin.readline

n = int(input())
n_list = list(map(int, input().split()))
dp = [n_list[0]]

for i in range(1, n):
    # 지금까지 누적된 최대값과 자기자신을 비교
    if dp[i - 1] + n_list[i] < n_list[i]:
        dp.append(n_list[i])
    else:
        dp.append(dp[i - 1] + n_list[i])
print(max(dp))