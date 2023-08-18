while 1:
    n, m = map(int, input().split())
    if n == 0 and m == 0:
        break
    # 더 큰수를 작은 수로 나눈다
    if n > m and n % m == 0:
        print("multiple")
    elif n < m and m % n == 0:
        print("factor")
    else:
        print("neither")
