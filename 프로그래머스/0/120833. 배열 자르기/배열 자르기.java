import java.util.*;

class Solution {
    public int[] solution(int[] numbers, int num1, int num2) {
        // copyOfRange(배열, 시작인덱스, 마지막인덱스 앞요소까지만 복사)
        int[] answer = Arrays.copyOfRange(numbers, num1, num2+1);
        return answer;
    }
}