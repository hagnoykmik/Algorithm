t = int(input())

for tc in range(1, t+1):
    n = int(input())      # 카드의 장 수
    card_list = list(input().split())

    # 반 씩 나눠담을 리스트
    A = []
    B = []

    if n % 2:              # n이 홀수면 앞에 리스트에 하나 더 담는다
        for i in range(n//2 + 1):
            A.append(card_list[i])
        for j in range(n//2 + 1, n):
            B.append(card_list[j])
    else:
        for i in range(n//2):
            A.append(card_list[i])
        for j in range(n//2, n):
            B.append(card_list[j])

    # A에 담긴 카드는 짝수번째에 B에 담긴 카드는 홀수번째에 번갈아가며 담는다
    new = []

    for k in range(n//2):
        new.append(A[k])
        new.append(B[k])

    if len(new) != n:     # n이 홀수일때는 A의 마지막 원소를 넣어준다
        new.append(A[-1])

    print(f'#{tc}', *new)