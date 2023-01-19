n, x = map(int, input().split())
num_list = list(map(int, input().split()))

answer = []

for i in range(n):
    if num_list[i] < x:
        answer.append(num_list[i])
print(*answer)