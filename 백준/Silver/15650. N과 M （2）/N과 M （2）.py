import sys
input = sys.stdin.readline

def combinations(arr, start):
    # 종료시점
    if len(arr) == m:
        print(*arr)
        return
    
    # 조합 진행
    for i in range(start, len(numbers)):
        arr.append(numbers[i])

        # 내숫자 다음부터 넣기 위해 재귀 진행
        combinations(arr, i + 1)

        # 재귀 종료 시 
        arr.pop()



n, m = map(int, input().split())
numbers = [num for num in range(1, n + 1)]
visited = [False] * n

combinations([], 0)