class Solution {
    public int solution(int num1, int num2) {
        double answer = (double) num1 / num2 * 1000; // 실수 나눗셈, 정확한 값
        return (int)answer; // int로 형변환
    }
}