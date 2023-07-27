def solution(survey, choices):
    answer = ''
    score_d = {'R': 0, 'T': 0, 'C': 0, 'F': 0, 'J': 0, 'M': 0, 'A': 0, 'N': 0} #점수표
    
    for q, score in zip(survey, choices):
        if score < 4:
            score_d[q[0]] += 4 - score # 앞의 지표에 점수주기
        elif score > 4:
            score_d[q[1]] += score - 4 # 뒤의 지표에 점수주기
    
    score_l = list(score_d.items())    # 딕셔너리 -> 리스트
    
    for i in range(0, len(score_l)-1, 2):
        if score_l[i][1] >= score_l[i+1][1]:
            answer += score_l[i][0]
        else:
            answer += score_l[i+1][0]
    
    return answer
    