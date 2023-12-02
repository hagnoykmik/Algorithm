'''
현재 시간에 뱀의 위치가 어떻게 되어있는지를 그대로 코드로 구현
'''

'''
1초마다
먼저 뱀은 몸길이를 늘려 머리를 다음칸에 위치시킨다.
만약 벽이나 자기자신의 몸과 부딪히면 게임이 끝난다.
만약 이동한 칸에 사과가 있다면, 그 칸에 있던 사과가 없어지고 꼬리는 움직이지 않는다.
만약 이동한 칸에 사과가 없다면, 몸길이를 줄여서 꼬리가 위치한 칸을 비워준다. 즉, 몸길이는 변하지 않는다.
'''

'''
게임이 시작할때 뱀은 맨위 맨좌측에 위치하고 뱀의 길이는 1 이다. 뱀은 처음에 오른쪽을 향한다.
벽 또는 자기자신의 몸과 부딪히면 게임이 끝난다.
'''
n = int(input())
board = [[0] * (n + 1) for _ in range(n + 1)]

k = int(input())
apple_list = []
for _ in range(k):
    apple_x, apple_y = map(int, input().split())
    board[apple_x][apple_y] = 1 # 사과위치

# 명령어
command_list = [0] * 10001
l = int(input())
for _ in range(l):
    second, cmd = input().split()
    # 그 시간에 명령어
    command_list[int(second)] = cmd

# 그 시간에 뱀의 위치
snake_x = [0] * 10101
snake_y = [0] * 10101

# 이동위치(일단 처음엔 오른쪽으로 이동(반시계 방향)/거꾸로하면 시계방향
dx = [0, 1, 0, -1]
dy = [1, 0, -1, 0]


# 0. 초기 세팅
d = 0
time = 0
# 뱀의 머리= (1, 1), 길이가 1이라서 꼬리는 뱀의 머리와 같은 곳에 있다
head_x, head_y, tail_idx = 1, 1, time
# 0초에 뱀의 위치
snake_x[time], snake_y[time] = head_x, head_y
board[head_x][head_y] = -1  # 뱀의위치


# 뱀의 이동
while True:
    # 먼저 뱀은 몸길이를 늘려 머리를 다음칸에 위치시킨다.
    time += 1

    head_x += dx[d]
    head_y += dy[d]

    # 만약 벽이나 자기자신의 몸과 부딪히면 게임이 끝난다.
    if head_x < 1 or head_x > n or head_y < 1 or head_y > n or board[head_x][head_y] == -1:
        break

    # 현재 시간의 뱀의 좌표 넣어준다
    snake_x[time] = head_x
    snake_y[time] = head_y

    # 만약 이동한 칸에 사과가 있다면, 그 칸에 있던 사과가 없어지고 꼬리는 움직이지 않는다.
    # 만약 이동한 칸에 사과가 없다면, 몸길이를 줄여서 꼬리가 위치한 칸을 비워준다. 즉, 몸길이는 변하지 않는다.
    if board[head_x][head_y] == 0:
        tail_x = snake_x[tail_idx]
        tail_y = snake_y[tail_idx]
        # 뱀이 이동했으니까 다시 -1을 없애준다.
        board[tail_x][tail_y] = 0
        tail_idx += 1  # 뱀의 길이 줄여주기

    # 뱀의 위치 표시
    board[head_x][head_y] = -1

    # 명령어 따르기
    if command_list[time] == 'D':
        d = (d + 1) % 4

    elif command_list[time] == 'L':
        # 반대방향으로 이동
        d = (d + 3) % 4

# 시간 출력
print(time)
