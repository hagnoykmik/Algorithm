def solution(s, n):
    answer = ''
    
    for alpha in s:
        alpha_i = ord(alpha)
        if alpha_i >= 65 and alpha_i < 91:
            answer += chr(((alpha_i+n)//91)*65 + (alpha_i+n)%91)
        elif alpha_i >= 97 and alpha_i < 123:
            answer += chr(((alpha_i+n)//123)*97 + (alpha_i+n)%123)
        else:
            answer += " "
    return answer
