def solution(n):
    result = 0
    
    for number in range(1, n+1):
        answer = 0
        # 1부터 n까지 연속한 숫자를 더한 합을 구한다.
        for i in range(number, n+1):
            answer += i
            if answer == n:
                result += 1
                break
            elif answer > n:
                break
    
    return result