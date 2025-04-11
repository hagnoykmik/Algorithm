class Solution {
    public int solution(int n) {
        int i = 1;
        while (i < n) {
            if (i * i == n) return 1;
            i++;
        }
        return 2;
    }
}