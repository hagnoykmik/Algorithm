n = int(input())
member_list = []

for i in range(n):
    age, name = input().split()
    member_list.append((i, int(age), name))
member_list.sort(key=lambda x : (x[1], x[0]))

for j in range(n):
    print(member_list[j][1], member_list[j][2])