n = int(input())

if n != 1:
    divisor_list = [True] * (n + 1)
    n_list = []

    # 소수구하기
    for num in range(2, int(n ** 0.5) + 1):
        if divisor_list[num] == True:
            for i in range(num + num, n+1, num):
                divisor_list[i] = False
    n_list = [j for j in range(2, n + 1) if divisor_list[j]]

    # 소인수분해하기
    j = 0
    while n > 1:
        if n % n_list[j] == 0:
            n = n // n_list[j]
            print(n_list[j])
        else:
            j += 1