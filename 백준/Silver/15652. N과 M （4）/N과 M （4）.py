import sys
input = sys.stdin.readline

def permutation(arr, start):
    # 종료조건
    if len(arr) == m:
        print(*arr)
        return
    
    for j in range(start, n + 1):
        arr.append(j)
        permutation(arr, j)
        # 재귀에서 돌아왔을 때
        arr.pop()


n, m = map(int, input().split())
numbers = [num for num in range(1, n + 1)]

for i in numbers:
    permutation([i], i)