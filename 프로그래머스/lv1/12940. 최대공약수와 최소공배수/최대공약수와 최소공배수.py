def solution(n, m):
    answer = []
    
    multiply = n * m
    
    # 큰수가 n에 들어가기 위해
    if n < m:
        tmp = n
        n = m
        m = tmp
    
    # 최대 공약수 (m이 0인 순간의 n)
    while m != 0:
        gcd = n % m
        n = m
        m = gcd
    
    # 최소 공배수 = 두수의 곱 / 최대공약수
    lcm = multiply // n
    
    answer.append(n)
    answer.append(lcm)
    
    
    return answer