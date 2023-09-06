import sys
input = sys.stdin.readline

def permutations(arr):
    # 종료조건
    if len(arr) == m:
        print(*arr)
        return 
    
    # 순열 진행
    for i in range(n):
        if not visited[i]:
            arr.append(numbers[i])
            visited[i] = True

            # 다음 번호 뽑으러 가기
            permutations(arr)

            # 재귀 종료 후 - 다른 때 뽑히기 위해 다시 방문처리 해지하고 배열에서 빼준다.
            visited[i] = False
            arr.pop()


n, m = map(int, input().split())

numbers = [num for num in range(1, n + 1)]
visited = [False] * n
permutations([])