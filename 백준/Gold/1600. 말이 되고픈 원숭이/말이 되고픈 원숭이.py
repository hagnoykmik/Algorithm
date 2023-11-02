from collections import deque
import sys
input = sys.stdin.readline

# 이동 가능한지 체크
def check(nh, nw, k):
    if 0 <= nh < H and 0 <= nw < W and not visited[nh][nw][k] and board[nh][nw] == 0:
        return True


# 이동(bfs)
def move():
    q = deque([(0, 0, 0)])
    visited[0][0][0] = 1

    while q:
        h, w, k = q.popleft()

        # 원숭이로 이동(상하좌우)
        for i in range(4):
            nh = h + monkey_dh[i]
            nw = w + monkey_dw[i]

            if check(nh, nw, k):
                # 도착
                if (nh, nw) == (H - 1, W - 1):
                    return visited[h][w][k]
                # 이동횟수 + 1
                visited[nh][nw][k] = visited[h][w][k] + 1
                q.append((nh, nw, k))


        # 말처럼 이동
        if k < K:
            for j in range(8):
                nh = h + horse_dh[j]
                nw = w + horse_dw[j]

                if check(nh, nw, k + 1): # 한 칸옆을 확인해줘야한다.
                    # 도착
                    if (nh, nw) == (H - 1, W - 1):
                        return visited[h][w][k]
                    
                    q.append((nh, nw, k + 1))
                    visited[nh][nw][k + 1] = visited[h][w][k] + 1

    return -1


K = int(input())
W, H = map(int, input().split())
board = [list(map(int, input().split())) for _ in range(H)]
visited = [[[0] * (K + 1) for _ in range(W)] for _ in range(H)] 

# 말처럼 이동
horse_dh = [-2, -1, 1, 2, 2, 1, -1, -2]
horse_dw = [1, 2, 2, 1, -1, -2, -2, -1]

# 원숭이 이동
monkey_dh = [-1, 1, 0, 0]
monkey_dw = [0, 0, -1, 1]

# 원숭이 시작
# 시작하자마자 도착일 때 예외처리(nw, nh일 때 종료조건 걸기 위해서 -> 동작횟수 줄일 것 같아서)
if len(board) == 1 and board[0][0] == 0:
    print(0)
    exit(0)

# 아니면 이동하러 가기
print(move())

