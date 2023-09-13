'''
1. 아이디어
- 주어진 수열을 다 돌면서 자기보다 앞에있는 것들이 자기보다 작은 것중에 max값에 +1(자기자신)
- dp리스트에 수열의 최댓값 저장하기

2. 시간복잡도
- 이중 for문 : 1000 * 1000 = 100만

3. 자료구조
- 수열 : int[]
- dp : int[]
'''

import sys
input = sys.stdin.readline

n = int(input())
A = list(map(int, input().split()))
dp = [] # 처음부터 그 숫자까지 증가하는 수열 개수 저장


for i in range(len(A)):
    answer = 0
    num = A[i]
    for j in range(0, i):
        # 자신보다 작은 수 중 가장 많은 수열을 가지고 있는 수에 +1을 해준다.
        if A[j] < num:
            answer = max(answer, dp[j])
    dp.append(answer + 1) # 자기자신 +1

print(max(dp))