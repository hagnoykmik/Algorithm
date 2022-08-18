t = int(input())

for tc in range(1, t+1):
    number = int(input())
    arr = [[] * number for _ in range(1, number + 1)]    # 리스트 크기 자동조절을 이용(append)
                                                         # 범위 1부터로

# nCr에서 아이디어
    for n in range(1, number + 1):
        for r in range(n):
            if r == 0 or r == n - 1:  # r이 0이거나 n과 같으면 1
                arr[n - 1].append(1)  # 빈문자열이므로 앞 인덱스만 지적(r까지 지정하면 자리가 없어서 오류남)
            else:                     # nCr = n-1Cr + n-1Cr-1
                arr[n - 1].append(arr[n - 2][r] + arr[n - 2][r - 1])
    print(f'#{tc}')
    for i in range(number):
        for j in range(i + 1):
            print(arr[i][j], end=' ')
        print()