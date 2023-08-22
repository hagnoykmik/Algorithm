from collections import Counter

def solution(X, Y):
    answer = []
    
    # 집합에서 공통원소들로 새로운 집합 반환
    x = set(X)
    y = set(Y)
    common_num = x.intersection(y)
    
    x_count = Counter(X)
    y_count = Counter(Y)

    for n in common_num:
        n_count = min(x_count[n], y_count[n])
        answer.extend([n] * n_count)
    
    # 내림차순으로 정렬할 뒤 문자열로 바꾼다.
    if answer == []:
        return "-1"
    elif answer.count("0") == len(answer):
        return "0"
    else:
        answer.sort(reverse=True)
        answer = ''.join(answer)
        
    return answer