def divisor(n):
    answer = 0
    for i in range(1, int((n ** 0.5) + 1)):
        if n % i == 0:
            answer += 1
            if i ** 2 != n:
                answer += 1
    return answer

def solution(number, limit, power):
    powers = [1]
    result = 0
    
    # 약수의 개수 찾기
    for n in range(2, number + 1):
        powers.append(divisor(n))
        
    # limit을 안넘는거 합치기
    for p in powers:
        if p > limit:
            result += power
        else:
            result += p
    
    return result