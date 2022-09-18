def solution(n):
    answer = -1
    for x in range(1, n+1):
        if x * x == n:
            answer = (x + 1)**2
            break
        if x * x > n:
            break
    return answer