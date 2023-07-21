def solution(s, n):
    answer = ''

    # 시저 암호 대체 문자
    plain = 'abcdefghijklmnopqrstuvwxyz'
    cipher = 'ABCDEFGHIJKLMNOPQRSTUVWXYZ'
    
    for c in s:
        # 만약 찾는 문자열이 반드시 존재해야 하는 경우라면 index()를 사용하는 것이 좋다.
        if plain.find(c) != -1:
            answer += plain[(plain.find(c) + n) % 26]
        elif cipher.find(c) != -1:
            answer += cipher[(cipher.find(c) + n) % 26]
        else:
            answer += ' '
    
    return answer
