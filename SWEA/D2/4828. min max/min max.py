t = int(input())
for tc in range(t):
    n = int(input())
    n_list = list(map(int, input().split()))
    print(f'#{tc + 1} {max(n_list) - min(n_list)}')