t = int(input())
for tc in range(1, t + 1):
    n, m = map(int, input().split())
    num_list = list(map(int, input().split()))
    sum_list = []
    for i in range(n - m + 1):
        sum_list.append(sum(num_list[i:i+m]))

    print(f'#{tc} {max(sum_list) - min(sum_list)}')