num_list = []
for _ in range(9):
    n = int(input())
    num_list.append(n)
    
max_num = max(num_list)

print(max_num)
print(num_list.index(max_num) + 1)