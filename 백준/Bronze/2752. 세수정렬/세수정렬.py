list = list(map(int, input().split()))

for i in range(len(list)):
    for j in range(i, len(list)):
        if list[i] > list[j]:
            list[i], list[j] = list[j], list[i]
            
for _ in list:
    print(_)