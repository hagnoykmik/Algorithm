from collections import deque
def solution(maps):
    answer = -1 # 도착할 수 없을 때
    n = len(maps)
    m = len(maps[0])
    
    # 이동방향
    dx = [0, 0, -1, 1]
    dy = [-1, 1, 0, 0]
    
    # 출발위치 담고 방문 처리
    q = deque([(0, 0, 1)]) # x, y, count
    maps[0][0] = 0
    
    # bfs
    while q:
        x, y, c = q.popleft()
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if 0 <= nx < n and 0 <= ny < m and maps[nx][ny] == 1:
                # 도착했는지 체크
                if nx == n - 1 and ny == m - 1:
                    return c + 1
                # 도착안했으면 이동 후 방문 처리
                q.append((nx, ny, c + 1))
                maps[nx][ny] = 0
    
    return answer