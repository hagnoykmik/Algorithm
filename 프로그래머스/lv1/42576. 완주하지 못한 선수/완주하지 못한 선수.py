def solution(participant, completion):
    # 정렬
    participant.sort()
    completion.sort()

    for p, c in zip(participant, completion):
        # 만약에 다르면 그사람이 완주하지 못한 선수
        if p != c:
            return p
    # 다돌았는데도 안나오면 나머지가 완주하지 못한 선수
    else:
        return participant[-1]        