me = list(map(int, input().split()))
chess = [1, 1, 2, 2, 2, 8]
need = []

for i in range(6):
    need.append(chess[i] - me[i])
    
print(*need)