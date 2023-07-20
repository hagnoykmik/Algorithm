def solution(s):
    num_list = list(map(int, s.split(" "))) # 리스트를 감싸줘야 한다(안그러면 map타입으로 반환)
    answer = (lambda x, y: x + " " + y)(str(min(num_list)), str(max(num_list)))
    return answer

