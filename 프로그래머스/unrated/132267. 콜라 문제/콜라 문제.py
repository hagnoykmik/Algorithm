def solution(a, b, n):
    answer = 0
    c = 0 # 남은 콜라 대기 중

    while n >= a:  # 더이상 바꿀 수 없을 때까지 콜라 교환
        answer += (n//a) * b
        n = (n//a)*b + (n%a)  

    return answer