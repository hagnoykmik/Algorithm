while 1:
    n = int(input())
    if n == -1:
        break
    
    divisor_list = set()
    for i in range(1, int(n**0.5)+1):
        if n % i == 0:
            divisor_list.add(i)
            divisor_list.add(n // i)
    divisor_list = sorted(list(divisor_list))[:len(divisor_list)-1]
    
    if sum(divisor_list) == n:
        result = ' + '.join(map(str, divisor_list))
        print(f"{n} = {result}")
    else:
        print(f"{n} is NOT perfect.")