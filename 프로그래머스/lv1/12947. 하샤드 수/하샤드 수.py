def solution(x):
    sum_x = 0
    n = x
    while n > 0:
        sum_x += n % 10
        n //= 10
        
    if x % sum_x == 0:
        answer = True
    else:
        answer = False
    return answer