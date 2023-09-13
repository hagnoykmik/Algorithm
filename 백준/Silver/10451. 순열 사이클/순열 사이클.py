'''
1. 아이디어
- 1부터 싸이클 찾기 (bfs) -> visited에 담겨있으면 탐색하지 않아도된다.
- 순환되는지 리스트의 첫 값과 마지막 값을 체크한다.

2. 시간복잡도

3. 자료구조
- 순환순열 : int[]
'''

from collections import deque
import sys
input = sys.stdin.readline

t = int(input())
for _ in range(t):
    n = int(input())
    numbers = list(map(int, input().split()))
    visited = []
    cnt = 0

    def bfs(i, cnt):
        q = deque([i])
        permutation = [i] # 순환순열인지 체크하기 위함

        while q:            
            i = q.popleft()

            # 값을 다음 index로 설정한다.
            ni = numbers[i - 1]

            # 값이 인덱스 범위 안에 들어가고 순열리스트 안에 있고 방문한 적 없으면 추가
            if ni in numbers and 1 <= ni <= n and ni not in visited:
                q.append(ni)       
                visited.append(ni) 
                permutation.append(ni)

        # 순환 순열인지 체크
        if permutation[0] == permutation[-1]:
            return True
        else:
            return False

    # 1부터 찾기
    for x in range(1, n+1):
        if x not in visited:
            if bfs(x, cnt): # 순환이면 cnt +1
                cnt += 1
    print(cnt)