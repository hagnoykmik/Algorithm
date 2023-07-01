def solution(d, budget):
    answer = 0
    d.sort()
    

    for m in d:        
        budget -= m
        if budget >= 0:
            answer += 1

    return answer