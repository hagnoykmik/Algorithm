class Solution {
    public int solution(int n) {
        if (n % Math.sqrt(n) == 0) { // 자신을 자신의 제곱근으로 나눴을 때 나머지가 0이면 제곱수
            return 1;
        } else {
            return 2;
        }
    }
}