from itertools import combinations

def solution(nums):
    answer = 0
    combi = list(combinations(nums, 3))
    for c in combi:
        n = sum(c)
        # 소수인지 판별하기
        for i in range(2, n): # 2부터 n-1까지 나눴을 때 나눠지면 소수가 아니다.
            if n % i == 0:
                break
        else:
            answer += 1

    return answer