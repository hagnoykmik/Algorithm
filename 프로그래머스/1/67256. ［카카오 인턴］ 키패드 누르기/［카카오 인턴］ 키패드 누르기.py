def solution(numbers, hand):
    answer = ''
    left = {1, 4, 7}  # 열이 0
    right = {3, 6, 9} # 열이 2
    
    current_left = (3, 0)
    current_right = (3, 2)

    for n in numbers:
        row = n // 3
        if n in left:
            answer += 'L'
            current_left = (row, 0)
        elif n in right:
            answer += 'R'
            current_right = (row - 1, 2)
        else:
            # 0일 때는 //3으로 안되서 예외처리
            if n == 0:
                row = 3
            # 왼손이 더 가까울 때
            if abs(current_left[0] - row) + abs(current_left[1] - 1) < abs(current_right[0] - row) + abs(current_right[1] - 1):
                answer += 'L'
                current_left = (row, 1)
            # 오른손이 더 가까울 때    
            elif abs(current_left[0] - row) + abs(current_left[1] - 1) > abs(current_right[0] - row) + abs(current_right[1] - 1):
                
                answer += 'R'
                current_right = (row, 1)
            # 같을 때
            else:
                if hand == "left":
                    answer += 'L'
                    current_left = (row, 1)
                else:
                    answer += 'R'
                    current_right = (row, 1)
        
    return answer