class Solution {
    public int solution(int n, int k) {
        // 양꼬치 1인분에 12,000원, 음료수 2,000원
        // 10인분에 음료수 1개 서비스
        
        int answer = n*12000 + k*2000 -(n/10)*2000;
        return answer;
    }
}