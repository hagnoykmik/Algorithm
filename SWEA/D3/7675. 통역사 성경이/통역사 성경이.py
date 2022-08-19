t = int(input())

for tc in range(1, t+1):
    n = int(input())      # 문장 수
    stc = input()

    stc = stc.replace('!', '.')
    stc = stc.replace('?', '.')

    stc = stc.split('.', maxsplit=n - 1)

    # 각 문장을 단어로 쪼개서 담기
    names = [[] for _ in range(n)]

    for i in range(n):
        names[i] = stc[i].split()

    # 이름 판별하기
    result = []            # 결과값을 담을 리스트

    for j in range(len(names)):

        cnt = 0            # 각 문장에서 이름 개수 카운트

        for k in range(len(names[j])):
            # 마지막 단어가 .으로 끝나면 .전까지 잘라준다
            if names[j][k][-1] == '.':
                names[j][k] = names[j][k][:-1]

            # 첫문자는 대문자고 나머지는 소문자인지 판별, 숫자나 문자열이 들어있으면 False
            if names[j][k].istitle() and names[j][k].isalpha():
                cnt += 1

        result.append(cnt)

    print(f'#{tc}', *result)