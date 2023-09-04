n = int(input())
dp = [0] * 1000001
#[0,0,1,2]

for i in range(2, n + 1):
    # 1을 뺀다
    dp[i] = dp[i - 1] + 1

    # 2로 나누어떨어질 때
    if i % 2 == 0:
        dp[i] = min(dp[i], dp[i // 2] + 1)

    # 3으로 나누어떨어질 때
    if i % 3 == 0:
        dp[i] = min(dp[i], dp[i // 3] + 1)

print(dp[n])