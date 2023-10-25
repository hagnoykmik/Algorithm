import sys
input = sys.stdin.readline

def permutation(arr, k):
    # 종료조건
    if len(arr) == k:
        print(*arr)
        return
    
    for i in range(n):
        # 수열은 사전 순으로 증가하는 순서로 출력
        if len(arr) > 0:
            if numbers[i] >= arr[-1]:
                arr.append(numbers[i])
                permutation(arr, k)
                # 재귀에서 돌아왔을 때
                arr.pop()
        else:
            arr.append(numbers[i])
            permutation(arr, k)  
            arr.pop()


n, m = map(int, input().split())
numbers = [num for num in range(1, n + 1)]

permutation([], m)