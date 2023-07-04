def solution(k, m, score):
    answer = 0
    cnt = 0     # m개씩 담기 위해 카운트
    apple = []
    
    score.sort(reverse=True)
        
    for i in range(len(score)):
        apple.append(score[i])
        cnt += 1
        if cnt % m == 0:
            answer += apple[i] * m * 1
        
    return answer