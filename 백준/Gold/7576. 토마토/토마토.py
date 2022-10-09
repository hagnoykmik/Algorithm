from collections import deque

# 인접한 토마토 찾기
def search(x, y, tomato):
    for i in range(4):
        nx = x + dx[i]
        ny = y + dy[i]

        if 0 <= nx < m and 0 <= ny < n and box[nx][ny] == 0:
            box[nx][ny] = 1                                     # 인접한 토마토 익히기
            tomato.append((nx, ny))                             # 다음 날 익을 토마토의 좌표를 튜플로 리스트에 담기


# 상, 하, 좌, 우 (익힐 수 있는 토마토)
dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]


n, m = map(int, input().split())
box = [list(map(int, input().split())) for _ in range(m)]
day = -1              # 첫 날 익은 토마토 값을 넣고 시작할 것이기 때문에
tomato = deque()      # 다음날 익을 토마토 담을 리스트


# 익은 토마토 위치 담기
for x, list_box in enumerate(box):
    for y in range(n):
        if list_box[y] == 1:
            tomato.append((x, y))


while tomato:
    cnt = len(tomato)                  # 같은 날 익은 토마토를 체크하기 위함
    for j in range(cnt):
        result = tomato.popleft()
        x, y = result[0], result[-1]
        search(x, y, tomato)
    day += 1                           # 다 담으면 다음날이 됨


for check in box:     # 안 익은 토마토가 있다면 -1을 출력
    if 0 in check:
        day = -1

print(day)

