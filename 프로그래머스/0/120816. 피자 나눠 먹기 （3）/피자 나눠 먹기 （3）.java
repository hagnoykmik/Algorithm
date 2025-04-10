class Solution {
    public int solution(int slice, int n) {
        int answer = (n-1)/slice + 1;
        return answer;
    }
}