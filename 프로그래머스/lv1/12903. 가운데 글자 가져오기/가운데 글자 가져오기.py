def solution(s):
    answer = ''
    mid = len(s) // 2
    print(mid)
    if len(s) % 2 == 1:
        answer = s[mid]
    else:
        answer += s[mid - 1]
        answer += s[mid]

    return answer