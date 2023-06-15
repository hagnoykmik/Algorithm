for t in range(1, 11):
    n = int(input())							# 덤프횟수
    dump = list(map(int, input().split()))
    dump.sort()
    new_list = [0] * 100

    while n > 0:
        dump.sort()         # 평탄화할 때마다 재정렬해준다
        dump[0] += 1        # 최고점에서 -1, 최저점에 +1
        dump[-1] -= 1
        n -= 1          	 # 평탄화 작업

    print(f'#{t} {max(dump) - min(dump)}')