m = int(input())
n = int(input())
divisor_list = []

for num in range(m, n + 1):
    if num > 1:
        for i in range(2, int(num ** 0.5) + 1):
            if num % i == 0:
                break
        else:
            divisor_list.append(num)

if len(divisor_list) >= 1:
    print(sum(divisor_list))
    print(min(divisor_list))
else:
    print(-1)
