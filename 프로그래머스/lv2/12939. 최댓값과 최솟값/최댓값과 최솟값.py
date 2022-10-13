def solution(s):
    answer = []
    num = list(map(int, s.split()))
    answer.append(str(min(num)))
    answer.append(str(max(num)))
    new = ' '.join(answer)
    return new