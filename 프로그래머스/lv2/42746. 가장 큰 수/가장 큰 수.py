def solution(numbers):

    numbers = list(map(str, numbers))
    numbers.sort(reverse=True, key=lambda x: (x * 4)[:4])
    # 3434,3333,3030
    
    answer = ''.join(numbers)
    
    if answer.count('0') == len(answer):
        return '0'
    else:
        return answer