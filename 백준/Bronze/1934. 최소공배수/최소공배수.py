for _ in range(int(input())):
    a, b = map(int, input().split())
    n = a * b

    if a > b:
        tmp = a
        a = b
        b = tmp
    
    # 최대공약수 구하기
    while a != 0:
        r = b % a
        b = a
        a = r
    print(n // b)
