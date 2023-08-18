n = int(input())

# 테스트 케이스가 하나라서 그냥 작은수부터 나누기를 해주면된다
for i in range(2, n+1):
    while n > 1:
        if n % i == 0:
            n = n // i
            print(i)
        else:
            break
    if n == 1:
        break
        