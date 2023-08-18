def solution(n):
    answer = 0
    for num in range(2, n+1):
        # 약수를 반만 찾는다 (num ** 1/2까지만 찾으면 뒤에는 반전)
        for i in range(2, int(num ** 0.5) + 1):
            if num % i == 0:
                break
        else:
            answer += 1
                
    return answer