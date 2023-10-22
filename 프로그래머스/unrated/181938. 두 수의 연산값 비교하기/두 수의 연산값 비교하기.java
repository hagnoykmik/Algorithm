class Solution {
    public int solution(int a, int b) {
        int answer = 0;
        
        int aPlusB = Integer.parseInt("" + a + b);
        
        answer = (aPlusB > (2 * a * b)) ? aPlusB : (2 * a * b);
        
        return answer;
    }
}