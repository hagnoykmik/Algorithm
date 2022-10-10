def solution(board, moves):
    answer = 0
    basket = []
    result = 0
    n = len(board)

    for order in moves:
        for i in range(n):
            if board[i][order-1] != 0:
                if basket and basket[-1] == board[i][order-1]:
                    basket.pop()
                    board[i][order - 1] = 0
                    answer += 2
                    break
                else:
                    basket.append(board[i][order-1])
                    board[i][order-1] = 0
                    break
    return answer