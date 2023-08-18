def solution(n):
    answer = 0

    # 에라토스테네스의 체
    num_list = [True] * (n + 1)
    
    num = int(n ** 0.5)
    for i in range(2, num + 1):
        if num_list[i] == True:
            # 소수의 배수들을 지운다
            for j in range(i + i, n + 1, i):
                num_list[j] = False
    return num_list[2:].count(True)