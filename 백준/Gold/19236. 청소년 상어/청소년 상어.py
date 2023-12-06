from copy import deepcopy
'''
1. 아이디어
상어가 먹을 수 있는 물고기 번호의 합의 최댓값

크게 두가지 로직 반복
상어가 이동해서 잡아먹고 <-> 모든 물고기 이동
1. 잡아먹기 => 상어가 이동 (상어 위치 저장 후 갱신) -> queue
2. 물고기들 1번부터 돌기 => 이동할 수 있는지 보고 되면 이동 안되면 방향바꾸고 이동 -> for문(1 ~ 16)
3. 다 이동하면 상어 이동 : 여러칸 이동가능 -> 재귀(== 상어가 잡아먹기)
    -> 원본 데이터 유지 어떻게?-> 결국 deepcopy 씀(원본 데이터를 stack이나 q에 저장해도 deepcopy안하면 값이 바뀜 (참조라서))

'''
def solve(board, fish, shark_x, shark_y, sum_fish):
    global total_fish
    # backtracking을 하기 위해 복사본 이용(넘겨줄때 복사본 사용)
    copied_board = [[0, 0, 0, 0] for _ in range(4)]
    copied_fish = [[] for _ in range(17)]

    # 복사
    for i in range(4):
        for j in range(4):
            copied_board[i][j] = board[i][j]

    for k in range(17):
        copied_fish[k] = deepcopy(fish[k])  # 리스트안에 리스트로 저장해놔서 참조값 복사라서 원본 유지가 안됐다....

# eat
    eaten_fish = copied_board[shark_x][shark_y]

    # 잡아먹은 물고기걸로 갈아끼우기
    copied_board[shark_x][shark_y] = -1  # 잡아먹혔다
    shark_direction = copied_fish[eaten_fish][2]

    # 잡아먹은 물고기 -1 처리하기
    copied_fish[eaten_fish] = [-1, -1, -1]

    sum_fish += eaten_fish  # 잡아먹은 물고기값 더해주기

    if total_fish < sum_fish:
        total_fish = sum_fish

# move_fish
    for f in range(1, 17):
        # 잡아먹혔으면 pass
        if copied_fish[f][0] == -1:
            continue

        # 물고기의 현재위치와 방향
        cx = copied_fish[f][0]
        cy = copied_fish[f][1]
        cd = copied_fish[f][2]

        # 물고기의 이동(할) 방향
        nx = cx + dx[cd]
        ny = cy + dy[cd]
        nd = cd

        # 이동하지 못하는 경우
        while 0 > nx or nx >= 4 or 0 > ny or ny >= 4 or ((nx, ny) == (shark_x, shark_y)):
            nd = (nd + 1) % 8
            nx = cx + dx[nd]
            ny = cy + dy[nd]

        # 물고기끼리 자리 바꾸기
        if copied_board[nx][ny] != -1:
            target = copied_board[nx][ny]
            # 정보 바꾸기
            copied_fish[target][0] = cx
            copied_fish[target][1] = cy
            # copied_fish[target][2] = cd # 위치가 바뀌어도 방향은 그대로

            copied_fish[f][0] = nx
            copied_fish[f][1] = ny
            copied_fish[f][2] = nd # 이동하려고 하다가 방향 바뀔 수도 있으니까 반영

            # 자리 바꾸기
            copied_board[cx][cy] = target
            copied_board[nx][ny] = f

        else:
            copied_fish[f][0] = nx
            copied_fish[f][1] = ny
            copied_fish[f][2] = nd

            copied_board[cx][cy] = -1
            copied_board[nx][ny] = f


# move_shark
    # 상어는 1칸부터 최대 3칸까지 이동가능
    for step in range(1, 4):
        nx = shark_x + (dx[shark_direction] * step)
        ny = shark_y + (dy[shark_direction] * step)

        # 범위 밖으로 이동하면 멈춤
        if nx < 0 or nx >= 4 or ny < 0 or ny >= 4:
            break

        # 물고기가 있는 경우에만 이동~
        if copied_board[nx][ny] != -1:
            solve(copied_board, copied_fish, nx, ny, sum_fish)


# 초기 설정
dx = [-1, -1, 0, 1, 1, 1, 0, -1]
dy = [0, -1, -1, -1, 0, 1, 1, 1]


fish = [[] for _ in range(17)] # 0번 물고기의 [(x, y), 방향]
total_fish = 0
board = []
for x in range(4):
    line = list(map(int, input().split()))
    new_line = []
    for y in range(0, 8, 2):
        a, b = line[y], line[y + 1]
        b -= 1
        # a번 물고기의 x, y, 방향
        fish[a].append(x)
        fish[a].append(y // 2)
        fish[a].append(b)

        new_line.append(a)
    board.append(new_line)


# board, fish 정보, 상어 초기 위치, 잡아먹은 합
solve(board, fish, 0, 0, 0)

print(total_fish)