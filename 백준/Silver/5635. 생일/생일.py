n = int(input())
man = []

for _ in range(n):
    man.append(input().split())

man.sort(key=lambda y: (int(y[3]), int(y[2]), int(y[1]))) # 년도, 월, 일 순으로 정렬(오름차순)

print(man[n-1][0])  # youngest
print(man[0][0])    # oldest