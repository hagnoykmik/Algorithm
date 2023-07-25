def solution(A,B):
    num_list = list(zip(sorted(A), sorted(B, reverse=True))) # 곱할 값을 하나로 묶기
    answer = sum(a * b for a, b in num_list)                 # 람다함수로 굳이 만들어 주지 않아도 됨
    return answer
