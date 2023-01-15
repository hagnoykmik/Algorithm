num_list = []
for _ in range(5):
    n = int(input())
    num_list.append(n)
num_list.sort()

print(sum(num_list)//5)
print(num_list[2])
