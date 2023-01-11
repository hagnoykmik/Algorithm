N = int(input())
int_list = list(input().split())
v = input()
count = 0

for n in range(N):
    if int_list[n] == v:
        count += 1
        
print(count) 