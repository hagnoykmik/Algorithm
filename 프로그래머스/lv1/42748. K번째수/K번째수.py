def solution(array, commands):
    answer = []
    n = len(commands)
    for i in range(n):
        answer.append(sorted(array[commands[i][0] - 1:commands[i][1]])[commands[i][2]-1])
    return answer