A = int(input())
B = input()

print(A * int(B[-1]))
print(A * int(B[1]))
print(A * int(B[0]))
print((A * int(B[-1])) + (A * int(B[1]) * 10) + (A * int(B[0]) * 100))