from collections import deque
import sys
input = sys.stdin.readline

def escape():
    while q:
        x, y, time = q.popleft()


        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]

            # 상근이
            if building[x][y] == '@':
                if 0 <= nx < h and 0 <= ny < w:
                    if building[nx][ny] == '.':
                        q.append((nx, ny, time + 1))
                        building[nx][ny] = '@'
                else:
                    return time + 1
            # 불
            else:
                if 0 <= nx < h and 0 <= ny < w and building[nx][ny] != '#' and building[nx][ny] != '*':
                    q.append((nx, ny, -1))
                    building[nx][ny] = '*'
    
    return "IMPOSSIBLE"


t = int(input())
for _ in range(t):
    w, h = map(int, input().split())

    building = [list(input().strip()) for _ in range(h)]
    dx = [-1, 1, 0, 0]
    dy = [0, 0, -1, 1]
    q = deque([])
    time = 0

    # 위치 찾기
    for x in range(h):
        for y in range(w):
            # 상근이
            if building[x][y] == '@':
                # 바로 탈출 가능하면 탈출하기
                if not( 0 < x < (h - 1) and 0 < y < (w - 1)):
                    time = 1
                    break
                q.appendleft((x, y, 0))
            # 불
            elif  building[x][y] == '*':
                q.append((x, y, -1))
        if time > 0:
            break


    # 탈출하기
    if time == 0:
        time = escape()
    
    print(time)
