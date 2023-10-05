'''
1. 아이디어
자기보다 제일 최근에 작은 수 + 1을 해준다

2. 시간복잡도
- 이중 for문 : n * n = 1000 * 1000 = 1,000,000

3. 자료구조
- 누적 상자의 개수 : int[]

'''
import sys
input = sys.stdin.readline

n = int(input())
box_list = list(map(int, input().split()))
dp = [0] * n

dp[0] = 1

for i in range(1, n):
    # 자신의 앞에 있는 box들을 역순으로 조회한다.
    for j in range(i, -1, -1):
        # 자기보다 작은게 여러개라면 최대값을 넣어준다
        if box_list[i] > box_list[j] and dp[i] <= dp[j]:
            dp[i] = dp[j] + 1
        else:
            pass
 
    # 다 돌았는데도 자신보다 작은게 없으면 1을 줘야한다.
    if dp[i] == 0:
        dp[i] = 1
        
print(max(dp))