class Solution {
    public int[] solution(int[] numbers, String direction) {
        int n = numbers.length;
        int[] answer = new int[n];
        
        if (direction.equals("right")) { // 오른쪽 방향일 때 +1
            for (int i = 0; i < n; i++) {
                answer[(i+1)%n] = numbers[i];
            }
        } else { // 왼쪽 방향일 때 -1
            for (int i = 0; i < n; i++) {
                answer[(i+n-1)%n] = numbers[i];
            }
        }

        return answer;
    }
}