from collections import deque
import sys
sys.setrecursionlimit(10**9)
imput = sys.stdin.readline

def binary_search(l_list, start, end):
    global answer, min_sum

    # 종료 조건
    if start >= end:
        return None
    
    # 두 용액의 합이 제일 작은 것을 찾는다
    l_sum = l_list[start] + l_list[end]
    if abs(l_sum) < min_sum:
        min_sum = abs(l_sum)
        answer = [l_list[start], l_list[end]]

    # 합이 -면 -가 더 큰거니까 하나 큰 걸로 옯겨준다.
    if l_sum < 0:
        binary_search(l_list, start + 1, end)
    
    # 반대면 +가 더 큰거니까 하나 작은걸로 옮겨준다.
    else:
        binary_search(l_list, start, end - 1)


n = int(input())
l_list = list(map(int, input().split()))
num = 1000000000
answer = [0, 0]
min_sum = 9999999999

l_list.sort() # 정렬
# 찾으러 가기
binary_search(l_list, 0, n-1)
answer.sort()
print(*answer)
