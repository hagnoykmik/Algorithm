for t in range(10):
    n = int(input())
    view = list(map(int, input().split()))
    answer = 0

    for i in range(2, n - 2):
        compare = view[i - 2: i + 3]
        max_num = compare[2]
        compare.remove(max_num)
        if max_num - max(compare) >= 0:
            answer += max_num - max(compare)
    print(f'#{t + 1} {answer}')