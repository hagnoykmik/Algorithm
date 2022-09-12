def solution(n):
    answer = 0
    
    for number in range(n - 1, 0, -1):
        if n % number == 1:
            answer = number
        
    return answer