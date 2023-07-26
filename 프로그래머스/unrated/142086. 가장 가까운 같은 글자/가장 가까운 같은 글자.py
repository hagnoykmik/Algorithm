def solution(s):
    answer = []
    word = ''
    for i, c in enumerate(s):
        # 찾는 값이 없을 때
        if word.rfind(c) == -1: # 인덱스 중에 가장 큰 값을 찾아준다
            answer.append(-1)
            word += c
        # 찾는 값이 있을 때
        else:
            answer.append(i - word.rfind(c))
            word += c
            
    return answer