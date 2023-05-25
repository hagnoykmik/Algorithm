char = input().upper()
result = set()
count_c = 0
char_set = set(char)

for c in char_set:
    if count_c < char.count(c):
        count_c = char.count(c)
        result = set()
        result.add(c)
    elif count_c == char.count(c):
        result.add(c)

if len(result) == 1:
    print(*result)
else:
    print('?')