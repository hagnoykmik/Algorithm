tetromino = [
    [
        "1111",
        "0000",
        "0000",
        "0000",
    ],
    [
        "1000",
        "1000",
        "1000",
        "1000",
    ],
    [
        "1100",
        "1100",
        "0000",
        "0000",
    ],
    [
        "1000",
        "1100",
        "0100",
        "0000",
    ],
    [
        "0110",
        "1100",
        "0000",
        "0000",
    ],
    [
        "0100",
        "1100",
        "1000",
        "0000",
    ],
    [
        "1100",
        "0110",
        "0000",
        "0000",
    ],
    [
        "1000",
        "1000",
        "1100",
        "0000",
    ],
    [
        "1110",
        "1000",
        "0000",
        "0000",
    ],
    [
        "1100",
        "0100",
        "0100",
        "0000",
    ],
    [
        "0010",
        "1110",
        "0000",
        "0000",
    ],
    [
        "1110",
        "0010",
        "0000",
        "0000",
    ],
    [
        "1100",
        "1000",
        "1000",
        "0000",
    ],
    [
        "1000",
        "1110",
        "0000",
        "0000",
    ],
    [
        "0100",
        "0100",
        "1100",
        "0000",
    ],
    [
        "0100",
        "1110",
        "0000",
        "0000",
    ],
    [
        "1110",
        "0100",
        "0000",
        "0000",
    ],
    [
        "1000",
        "1100",
        "1000",
        "0000",
    ],
    [
        "0100",
        "1100",
        "0100",
        "0000",
    ],
]


def get_count(sx, sy, k):
    ret = 0

    # 4x4 돌면서 종이에 적힌 점수값을 더해준다.
    for x in range(4):
        for y in range(4):
            ret += int(tetromino[k][x][y]) * board[sx + x][sy + y]

    return ret


n, m = map(int, input().split())
board = [list(map(int, input().split())) for _ in range(n)]


# 테트로미노가 최대 4x4니까 3칸씩 더 늘려준다
for i in range(n):
    board[i].extend([-10000, -10000, -10000])

for _ in range(3):
    board.append([-10000] * (m + 3))


max_point = 0
for x in range(n):
    for y in range(m):
        for k in range(len(tetromino)):
            point = get_count(x, y, k)

            if max_point < point:
                max_point = point

print(max_point)