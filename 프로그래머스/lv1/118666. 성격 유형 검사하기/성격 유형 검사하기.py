def solution(survey, choices):
    personality = {"R": 0, "T": 0, "C": 0, "F": 0, "J": 0, "M": 0, "A": 0, "N": 0}
    scores = [0, 3, 2, 1, 0, 1, 2, 3]
    # 1이면 survey[i][0] 에 +=3
    # 2이면 survey[i][0] 에 +=2
    # 3이면 survey[i][0] 에 +=1
    # 4이면 += 0
    # 5이면 survey[i][1] 에 +=1
    # 6이면 survey[i][1] 에 +=2
    # 7이면 survey[i][1] 에 +=3

    n = len(survey)
    answer = ''
    p_list = []  # 성격유형 담기
    s_list = []  # 성격유형 점수 담기


    # i번째의 0번째 캐릭터가 비동의(1,2,3), 1번째가 동의(5,6,7) 캐릭터
    for i in range(n):
        if choices[i] <= 3:
            personality[survey[i][0]] += scores[choices[i]]
        elif choices[i] >= 5:
            personality[survey[i][1]] += scores[choices[i]]


    # 성격유형검사
    for p in personality:
        p_list.append(p)
        s_list.append(personality[p])

    for j in range(4):
        if s_list[2 * j] >= s_list[2 * j + 1]:
            answer += p_list[2 * j]
        else:
            answer += p_list[2 * j + 1]

    print(f'"{answer}"')
    return answer