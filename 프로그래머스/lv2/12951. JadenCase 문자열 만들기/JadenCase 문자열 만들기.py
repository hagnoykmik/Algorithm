def solution(s):
    jc = s.split(" ")
    answer = ''
    for i in range(len(jc)):
        if jc[i] == "":
            # answer += " "
            pass
        else:
            # answer += jc[i][0].upper()
            # answer += jc[i][1:].lower()
            answer += jc[i].capitalize()
        if i != len(jc) - 1:
            answer += " "
    return answer