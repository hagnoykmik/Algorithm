def solution(s, skip, index):
    answer = ''
    pw = 'abcdefghijklmnopqrstuvwxyz' # 암호
    # 제외할 알파벳
    for skip_alpha in skip:
        pw = pw.replace(skip_alpha, '') # 반환받아야함
    n = len(pw)
    
    for c in s:
        alpha_i = pw.find(c) + index
        answer += pw[alpha_i - (n*(alpha_i//n))]
    return answer