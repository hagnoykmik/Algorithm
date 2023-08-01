def solution(brown, yellow):
    answer = []
    l = brown + yellow
    for i in range(1, int(yellow**(1/2))+1): #루트n까지만 구해야 약수를 중복되지 않게 구한다.
        if yellow % i == 0:
            if (i+2) * (yellow//i+2) == l:
                answer = [yellow//i+2, i+2] # 큰 수를 먼저 넣는다
    return answer