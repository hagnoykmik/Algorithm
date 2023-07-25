def solution(strings, n):
    strings.sort(key=lambda c: (c[n], c))  # n번째 글자로 정렬(같으면 사전순정렬))
    return strings