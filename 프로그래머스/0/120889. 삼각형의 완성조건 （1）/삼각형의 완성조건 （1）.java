import java.util.*; 

class Solution {
    public int solution(int[] sides) {
        Arrays.sort(sides); // 0,1,2 2번째 변의 길이가 가장 긴 변
        int answer = (sides[0] + sides[1] > sides[2]) ? 1 : 2;
        return answer;
    }
}