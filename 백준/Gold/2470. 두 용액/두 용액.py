from collections import deque
import sys
imput = sys.stdin.readline

n = int(input())
l_list = list(map(int, input().split()))
answer = [0, 0]
min_sum = 9999999999

l_list.sort() # 정렬
# 찾으러 가기
start, end = 0, n - 1

while True:
    # 종료 조건
    if start >= end:
        break
    
    # 두 용액의 합이 제일 작은 것을 찾는다
    l_sum = l_list[start] + l_list[end]
    if abs(l_sum) < min_sum:
        min_sum = abs(l_sum)
        answer = [l_list[start], l_list[end]]

    # 합이 -면 -가 더 큰거니까 하나 큰 걸로 옯겨준다.
    if l_sum < 0:
        start += 1
    
    # 반대면 +가 더 큰거니까 하나 작은걸로 옮겨준다.
    else:
        end -= 1

answer.sort()
print(*answer)
