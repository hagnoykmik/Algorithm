'''
1. 아이디어
- 경우의 수(조합)를 구해서 최소 비용을 가지는 경로 찾기

2. 시간 복잡도

3. 자료 구조

'''
from collections import deque
import sys
input = sys.stdin.readline

def permutation(arr):
    global min_pay

    # 종료 조건
    if len(arr) == n:
        # 최소 비용으로 업데이트
        min_pay = min(min_pay, check(arr))
        return
    
    # 경우의 수 뽑기
    for i in range(n):
        if not visited[i]:
            arr.append(num[i])
            visited[i] = True
            # 재귀
            permutation(arr)
            
            # 재귀 끝나고
            arr.pop()
            visited[i] = False

# 비용 계산하기
def check(arr):
    pay = 0
    for i in range(n):
        if city[arr[i] - 1][arr[(i + 1) % n] - 1] != 0:
            pay += city[arr[i] - 1][arr[(i + 1) % n] - 1]
        
        # 0이면 못가는 경로
        else:
            pay = 9999999 # 0으로 하면 min_pay가 0이 됨
            break
    return pay


n = int(input())
city = [list(map(int, input().split())) for _ in range(n)]
num = [i for i in range(1, n + 1)]
visited = [False] * n
min_pay = 9999999

permutation([])
print(min_pay)