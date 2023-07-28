def solution(prices):
    answer = []
    
    for i, p in enumerate(prices):
        for j in range(i, len(prices)): # 내 다음부터 가격 보기
            if p > prices[j]:           # 내가격보다 떨어지면 몇초동안 떨어졌는지 확인 후 break
                answer.append(j-i)
                break
        else:                           # 아니면 몇초동안 유지됐는지 확인
            answer.append((len(prices)-1)-i)
    return answer