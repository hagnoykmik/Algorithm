from collections import deque
import sys
input = sys.stdin.readline

# bfs 이동
def move(board, q):
    while q:
        r, c, cnt = q.popleft()

        # 도착지점이면 종료
        if (r, c) == (end_r, end_c):
            return cnt
        
        for d in range(8):
            nr = r + dr[d]
            nc = c + dc[d]

            if 0 <= nr < i and 0 <= nc < i and board[nr][nc] != 'k':
                q.append((nr, nc, cnt + 1))
                board[nr][nc] = 'k'


t = int(input())
dr = [-2,-1, 1, 2, 2, 1, -1, -2]
dc = [1, 2, 2, 1, -1, -2, -2, -1]


for _ in range(t):
    i = int(input())
    start_r, start_c = map(int, input().split())
    end_r, end_c = map(int, input().split())

    board = [[0] * i for _ in range(i)] # 체스판
    board[start_r][start_c] = 'k'       # 나이트 위치 체크
    q = deque([(start_r, start_c, 0)])

    print(move(board, q))