def solution(s):
    jc = s.split(" ")
    answer = ''
    for i in range(len(jc)):
        jc[i] = jc[i].capitalize()
    answer = " ".join(jc)
    return answer