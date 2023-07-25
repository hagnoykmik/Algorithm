def solution(strings, n):
    answer = []
    
    # n번째 글자와 문자열을 같이 저장
    for i in range(len(strings)):
        strings[i] = (strings[i], ord(strings[i][n]))
    # n번째 글자기준(같으면 사전순)으로 정렬
    strings.sort(key=lambda c: (c[1], c[0])) 
    # answer에 담기    
    for word in strings:
        answer.append(word[0])
    
    return answer