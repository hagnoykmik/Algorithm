def solution(k, score):
    answer = []
    top3 = []
    for day in range(len(score)):
        if not top3 or day <= k-1:   # 명예의 전당이 비어있거나, k-1일 이하(인덱스는 0부터라서)이면
            top3.append(score[day])  # 무조건 넣는다
        elif top3[0] < score[day]:   # 그렇지 않으면 k번째 점수와 비교한다
            top3.remove(top3[0])     # 그날의 점수가 top3의 점수보다 크면 교체한다
            # top3.pop(0)     # 그날의 점수가 top3의 점수보다 크면 교체한다
            
            top3.append(score[day])
        top3.sort()              # 오름차순으로 정렬(0번째 값과 비교하기 위해)
        answer.append(min(top3))   
    return answer