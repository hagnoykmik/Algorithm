n, k = map(int, input().split())
divisor_list = set()

for i in range(1, int(n**0.5)+1):
    if n % i == 0:
        divisor_list.add(i)
        divisor_list.add(n // i)
        
divisor_list = sorted(list(divisor_list))

if k > len(divisor_list):
    print(0)
else:
    print(divisor_list[k - 1])