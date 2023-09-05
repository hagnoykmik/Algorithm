n = int(input())
stairs = []
for _ in range(n):
    stairs.append(int(input()))
dp = [0] * n

if n >= 3:
    dp[0] = stairs[0] 
    dp[1] = stairs[0] + stairs[1]
    dp[2] = max(stairs[0] + stairs[2], stairs[1] + stairs[2])

    for i in range(3, n):
        dp[i] = max(
            dp[i-3] + stairs[i-1] + stairs[i],
            dp[i-2] + stairs[i]
        )
    print(dp[n-1])
    
else:
    print(sum(stairs))
