import java.util.*;

class Solution {
    public int[] solution(int n) {
        ArrayList<Integer> array = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                array.add(i);
            }
        }
        // ArrayList -> int[]
        int[] answer = new int[array.size()];
        for (int i = 0; i < array.size(); i++) {
            answer[i] = array.get(i);
        }
        return answer;
    }
}