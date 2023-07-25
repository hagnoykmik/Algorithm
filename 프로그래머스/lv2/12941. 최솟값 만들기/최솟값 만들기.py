def solution(A,B):
    answer = 0
    num_list = list(zip(sorted(A), sorted(B, reverse=True)))
    print(num_list)
    
    num = lambda a, b: a * b
    for a, b in num_list:
        answer += num(a, b)
        
    return answer
