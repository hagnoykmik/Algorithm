import sys
input = sys.stdin.readline

n, m = map(int, input().split())
numbers = [number for number in range(1, n+1)]

# 순열 만들기
def recur(arr):
    # 종료 조건
    if len(arr) == m:
        print(*arr)
        return
    
    # 순열 진행
    for j in range(n):
        arr.append(numbers[j])
        recur(arr)
        # 재귀 끝나면
        arr.pop()


for i in range(1, n+1):
    recur([i])