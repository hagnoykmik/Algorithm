class Solution {
    // 최대공약수 구하는 함수
    public static int getGCD(int num1, int num2) {
        if (num1 % num2 == 0) {
            return num2;
        }
        return getGCD(num2, num1%num2);
    }
    
    public int solution(int n) {
        int answer = 0;
        // n과 6의 최소공배수/6
        // 최소공배수 == 두 자연수의 곱 / 최대공약수
        int gcd = getGCD(n, 6);
        answer = n*6 / gcd / 6;
        
        return answer;
    }
}