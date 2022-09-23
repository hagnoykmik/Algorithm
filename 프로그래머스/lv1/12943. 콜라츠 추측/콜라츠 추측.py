def solution(num):
    cnt = 0
    
    while num > 1 and cnt < 500:
        cnt += 1
        # 1-1 짝수면 2를 나눈다
        if num % 2 == 0:
            num //= 2
        # 1-2 홀수면 3을 곱하고 1을 더한다
        else:
            num = num * 3 + 1
    if cnt == 500:
        return -1
    return cnt