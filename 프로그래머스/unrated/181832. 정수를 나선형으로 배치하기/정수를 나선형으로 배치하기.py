def solution(n):
    answer = [[0] * n for _ in range(n)]
    
    #우하좌상
    dx = [0, 1, 0, -1]
    dy = [1, 0, -1, 0]
    
    d = 0
    sx, sy = 0, 0
    num = 1
    answer[sx][sy] = num

    while num < n*n:

        nx = sx + dx[d]
        ny = sy + dy[d]

        if 0 > nx or nx >= n or 0 > ny or ny >= n or answer[nx][ny] != 0:
            d = (d + 1) % 4
            continue

        sx, sy = nx, ny
        num += 1
        answer[nx][ny] = num
    
    return answer