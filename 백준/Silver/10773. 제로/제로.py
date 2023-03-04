d = []
sum_d = 0
k = int(input())

for i in range(k):
    n = int(input())
    
    if n == 0:
        d.pop()            
    else:
        d.append(n)
        
for j in range(len(d)):
    sum_d += d[j]

print(sum_d)