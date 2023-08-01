def solution(brown, yellow):
    answer = []
    l = brown + yellow
    for i in range(1, yellow+1):
        if yellow % i == 0:
            if (i+2) * (yellow//i+2) == l:
                answer.append((i+2, yellow//i+2))
        
    return answer[-1]