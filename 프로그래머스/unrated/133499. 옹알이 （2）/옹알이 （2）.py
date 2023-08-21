def solution(babbling):
    answer = 0
    pr = ["aya", "ye", "woo", "ma"]
    for b in babbling:
        for p in pr:
            # 연속된 숫자가 아니면
            if p*2 not in b:
                b = b.replace(p, ' ') # 공백으로 채워준다(''로하면 연속된 발음이 된다.)
                if len(b.strip()) == 0:
                    answer += 1
                    break
    return answer