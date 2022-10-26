def solution(s):
    answer = ''
    check = []
    for char in s:
        check.append(ord(char))
    check.sort(reverse=True)
    for char in check:
        answer += chr(char)
    return answer