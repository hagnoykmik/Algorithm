t = int(input())

for tc in range(1, t+1):
    n, k = map(int, input().split())          # 수강생 수, 과제 제출한 사람 수
    k_list = list(map(int, input().split()))  # 제출한 사람 번호

    check_list = [0] * (n + 1)                # 번호가 1번부터라서 범위 지정 n+1
    d = []                                    # 미제출한 사람의 번호를 담을 리스트

    for i in k_list:                          # 과제를 제출한 사람의 인덱스 값은 1로 표시해준다
        check_list[i] = 1

    for j in range(1, n + 1):                 # 번호는 1번부터
        if check_list[j] == 0:                # 값이 0이면 미제출이므로 그사람의 번호인 인덱스를 리스트에 담는다
            d.append(j)

    print(f'#{tc}', *d)