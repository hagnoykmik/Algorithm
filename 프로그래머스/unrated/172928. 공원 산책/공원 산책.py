def solution(park, routes):

    # 방향
    direction = 'NSWE'
    dx = [-1, 1, 0, 0]
    dy = [0, 0, -1, 1]
    sx, sy = 0, 0       # 시작위치

    # 시작점 찾기
    for x in range(len(park)):
        y = park[x].find('S')
        if y != -1:
            sx, sy = x, y
            break

    # 이동하기
    nx, ny = sx, sy
    for route in routes:       # 이동 방향 더해주기
        op, n = route.split()  # d, n : 이동방향, 이동칸수
        i = direction.find(op)
        for _ in range(int(n)): # 이동칸수만큼 이동
            nx += dx[i] # 이동 
            ny += dy[i] # 이동

            if nx > len(park)-1 or ny > len(park[0])-1 or nx < 0 or ny < 0 or park[nx][ny] == 'X' : # 장애물이 있을 때
                nx, ny = sx, sy
                break
        sx, sy = nx, ny  # x, y에 이동할 nx, ny를 넣어준다

    return [sx, sy]