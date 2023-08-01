def solution(name, yearning, photo):
    answer = []
    scores = {n:s for n, s in zip(name, yearning)}
    
    for p in photo:
        score_sum = 0
        for score in p:
            if score in scores:   # scores에 있으면 그리움 점수 더해주기 
                score_sum += scores.get(score)
        answer.append(score_sum)  # 다 더했으면 answer에 넣어주기
    
    return answer