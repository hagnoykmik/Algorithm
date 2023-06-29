def solution(n):
    answer = 0
    num = []
    cnt = 0
    
    while n > 0:
        num.append(n % 3)
        n = n // 3

    for i in range(len(num)-1, -1, -1):
        answer += num[i] * (3 ** (len(num)-1-i))
        
    
    return answer