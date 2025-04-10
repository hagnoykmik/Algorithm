class Solution {
    public int solution(int n) {
        int answer = 0;
        for (int i = 1; i * i <= n; i++) {
            if (n % i == 0) {
                if (i * i == n) { // 제곱이면 +1만 한다(1쌍만 나옴)
                    answer += 1;
                    continue;
                };
                answer += 2; // 아닐땐 2쌍이 나옴
            }
        }
        return answer;
    }
}